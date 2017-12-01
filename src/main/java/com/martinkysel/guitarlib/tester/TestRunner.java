/**
 * GuitarLib
 * Copyright (C) 2017 Martin Kysel
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **/

package com.martinkysel.guitarlib.tester;

import com.martinkysel.guitarlib.basics.Note;
import com.martinkysel.guitarlib.scales.ChromaticScale;
import com.martinkysel.guitarlib.scales.Scale;
import com.martinkysel.guitarlib.tunings.StandardTuning;
import com.martinkysel.guitarlib.tunings.Tuning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class TestRunner {
    private static class NamedQuestion {
        public NamedQuestion(String n, Question q) {
            this.name = n;
            this.question = q;
        }

        String name;
        Question question;
    }

    private Question question;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Random rand = new Random();
    private int lastRandValue = -1;

    public static void main(String[] args) throws IOException {
        NamedQuestion[] questions = {
                getDistanceQuestion(),
                getNotesOnFretboardQuestion(),
                getStringBaseTonesQuestion(),
                getModeOrderQuestion(),
                getIdentifyModePatternQuestion()
        };

        {
            StringBuilder sb = new StringBuilder();
            sb.append("=== Pick your test ===\n");
            for (int i = 0; i < questions.length; i++) {
                sb.append(String.format("%d: %s\n", i + 1, questions[i].name));
            }

            System.out.println(sb.toString());
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rawAnswer = reader.readLine();
        int index = Integer.valueOf(rawAnswer) - 1;

        System.out.println(String.format("You picked: %s", questions[index].name));

        TestRunner t = new TestRunner(questions[index].question);
        t.run();
    }

    public TestRunner(Question q) {
        this.question = q;
    }

    public void run() {

        List<Question.QuestionVariant> variants = question.generateAllVariants();

        int totalTests = 0;
        long totalTime = 0;

        while(true) {
            try {
                Question.QuestionVariant variant = pickVariant(variants);


                System.out.println(variant.getQuestion());
                long start = System.nanoTime();
                String rawAnswer = reader.readLine();
                long end = System.nanoTime();
                long elapsedTime = end - start;
                totalTests++;
                totalTime += elapsedTime;

                System.out.println(String.format("%s (%.2f s)", variant.validateAnswer(rawAnswer),
                        (double)elapsedTime / 1000000000.0));

                System.out.println(String.format("Average time (%.2f s) for %d tests",
                        (double)totalTime / 1000000000.0 / totalTests, totalTests));

            } catch (IOException ioe) {

            }

        }
    }

    private static NamedQuestion getDistanceQuestion() {
        Note n = Note.getNote(Note.NoteName.C);
        return new NamedQuestion("Distance from C in semitones",
                new DistanceQuestion(n, 12));
    }

    private static NamedQuestion getNotesOnFretboardQuestion() {
        Tuning tuning = new StandardTuning();
        Scale scale = new ChromaticScale();
        int lowFret = 0;
        int highFret = 12;

        return new NamedQuestion("All notes on fretboard",
                new PositionOnStringQuestion(tuning, scale, lowFret, highFret));
    }

    private static NamedQuestion getStringBaseTonesQuestion() {
        Tuning tuning = new StandardTuning();
        Scale scale = new ChromaticScale();
        int lowFret = 0;
        int highFret = 0;

        return new NamedQuestion("6-String guitar string names",
                new PositionOnStringQuestion(tuning, scale, lowFret, highFret));
    }

    private static NamedQuestion getModeOrderQuestion() {
        return new NamedQuestion("Mode names",
                new ModeOrderQuestion());
    }

    private static NamedQuestion getIdentifyModePatternQuestion() {
        return new NamedQuestion("Identify mode by pattern",
                new IdentifyModeQuestion());
    }

    private Question.QuestionVariant pickVariant(List<Question.QuestionVariant> variants) {

        // always generate a new value
        int index;
        do {
           index = rand.nextInt(variants.size());
        } while (lastRandValue == index);
        lastRandValue = index;

        return variants.get(index);
    }
}
