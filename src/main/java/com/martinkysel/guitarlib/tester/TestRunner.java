package com.martinkysel.guitarlib.tester;

/**
 GuitarLib
 Copyright (C) 2017 Martin Kysel

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **/

import com.martinkysel.guitarlib.basics.Note;
import com.martinkysel.guitarlib.scales.ChromaticScale;
import com.martinkysel.guitarlib.scales.MajorScale;
import com.martinkysel.guitarlib.scales.Scale;
import com.martinkysel.guitarlib.tunings.StandardTuning;
import com.martinkysel.guitarlib.tunings.Tuning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class TestRunner {
    public static void main(String[] args) throws IOException {

        // TODO use reflection to find all instances
        Question[] questions = {
            getDistanceQuestion(),
            getNotesOnFretboardQuestion()
        };

        {
            StringBuilder sb = new StringBuilder();
            sb.append("=== Pick your test ===\n");
            for (int i = 0; i < questions.length; i++) {
                sb.append(String.format("%d: %s\n", i + 1, questions[i].getClass().getName()));
            }

            System.out.println(sb.toString());
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rawAnswer = reader.readLine();
        int index = Integer.valueOf(rawAnswer) - 1;

        System.out.println(String.format("You picked: %s", questions[index].getClass().getName()));

        TestRunner t = new TestRunner(questions[index]);
        t.run();
    }

    private static Question getDistanceQuestion() {
        Note n = Note.getNote(Note.NoteName.C);
        return new DistanceQuestion(n, 12);
    }

    private static Question getNotesOnFretboardQuestion() {
        Tuning tuning = new StandardTuning();
        Scale scale = new ChromaticScale();
        int lowFret = 0;
        int highFret = 12;

        return new PositionOnStringQuestion(tuning, scale, lowFret, highFret);
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

    private Question.QuestionVariant pickVariant(List<Question.QuestionVariant> variants) {
        int index = rand.nextInt(variants.size());
        return variants.get(index);
    }


    Question question;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Random rand = new Random();
}
