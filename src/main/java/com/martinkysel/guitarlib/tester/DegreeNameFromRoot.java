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
import com.martinkysel.guitarlib.scales.MajorScale;

import java.util.ArrayList;
import java.util.List;

public class DegreeNameFromRoot implements Question {
    public class DistanceQuestionVariant extends QuestionVariant {
        public Note startNote;
        public int degree;
        public int distance;

        public DistanceQuestionVariant(Note s, int degree, int d) {
            this.startNote = s;
            this.degree = degree;
            this.distance = d;
        }

        @Override
        String getQuestion() {
            return String.format("%s degree %d is?", startNote.getNoteName(), degree);
        }

        @Override
        String validateAnswer(String rawAnswer) {
            try {
                Note parsedAnswer = Note.getNote(Note.NoteName.valueOf(rawAnswer));
                Note expected = startNote.add(distance);

                if (expected.getNoteName() == parsedAnswer.getNoteName()) {
                    return "Correct!";
                } else {
                    return String.format("Wrong! The correct answer is %s", expected.getNoteName());
                }

            } catch (IllegalArgumentException iae) {
                return String.format("'%s' is not a valid note name", rawAnswer);
            }
        }
    }

    private Note rootNote;

    public DegreeNameFromRoot(Note n) {
        this.rootNote = n;
    }

    @Override
    public List<QuestionVariant> generateAllVariants() {
        List<QuestionVariant> result = new ArrayList<>();

        MajorScale s = new MajorScale(rootNote.getNoteName());

        result.add(new DistanceQuestionVariant(rootNote, 1, Note.getDistance(rootNote, s.note1())));
        result.add(new DistanceQuestionVariant(rootNote, 2, Note.getDistance(rootNote, s.note2())));
        result.add(new DistanceQuestionVariant(rootNote, 3, Note.getDistance(rootNote, s.note3())));
        result.add(new DistanceQuestionVariant(rootNote, 4, Note.getDistance(rootNote, s.note4())));
        result.add(new DistanceQuestionVariant(rootNote, 5, Note.getDistance(rootNote, s.note5())));
        result.add(new DistanceQuestionVariant(rootNote, 6, Note.getDistance(rootNote, s.note6())));
        result.add(new DistanceQuestionVariant(rootNote, 7, Note.getDistance(rootNote, s.note7())));


        return result;
    }
}
