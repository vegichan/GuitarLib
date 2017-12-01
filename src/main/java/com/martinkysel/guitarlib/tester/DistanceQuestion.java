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

import java.util.ArrayList;
import java.util.List;

public class DistanceQuestion implements Question {
    public class DistanceQuestionVariant extends QuestionVariant {
        public Note startNote;
        public Note note;
        public int distance;

        public DistanceQuestionVariant(Note s, Note n, int d) {
            this.startNote = s;
            this.note = n;
            this.distance = d;
        }

        @Override
        String getQuestion() {
            return String.format("%s + %d semitones is?", startNote.getNoteName(), distance);
        }

        @Override
        String validateAnswer(String rawAnswer) {
            try {
                Note parsedAnswer = Note.getNote(Note.NoteName.valueOf(rawAnswer));

                if (this.note.getNoteName() == parsedAnswer.getNoteName()) {
                    return "Correct!";
                } else {
                    return String.format("Wrong! The correct answer is %s", this.note.getNoteName());
                }

            } catch (IllegalArgumentException iae) {
                return String.format("'%s' is not a valid note name", rawAnswer);
            }
        }
    }

    private Note startNote;
    private int range;

    public DistanceQuestion(Note n, int r) {
        this.startNote = n;
        this.range = r;
    }

    @Override
    public List<QuestionVariant> generateAllVariants() {
        List<QuestionVariant> result = new ArrayList<>();

        for (int i =0; i<=range; i++) {
            Note n = startNote.add(i);
            result.add(new DistanceQuestionVariant(startNote, n, i));
        }

        return result;
    }
}
