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

public class ModeOrderQuestion implements Question {
    public class ModeOrderQuestionVariant extends QuestionVariant {
        public int modeNr;
        public String modeName;

        public ModeOrderQuestionVariant(int nr, String n) {
            this.modeName = n;
            this.modeNr = nr;
        }

        @Override
        String getQuestion() {
            return String.format("What is the %dth mode?", modeNr+1);
        }

        @Override
        String validateAnswer(String rawAnswer) {
            try {

                if (modeName.startsWith(rawAnswer)) {
                    return "Correct!";
                } else {
                    return String.format("Wrong! The correct answer is %s", modeName);
                }


            } catch (IllegalArgumentException iae) {
                return String.format("'%s' is not a valid answer", rawAnswer);
            }
        }
    }

    public ModeOrderQuestion() {
    }

    @Override
    public List<QuestionVariant> generateAllVariants() {
        String modeNamesInOrder[] = {
                "Ionian",
                "Dorian",
                "Phrygian",
                "Lydian",
                "Mixolydian",
                "Aeolian",
                "Locrian"
        };

        List<QuestionVariant> result = new ArrayList<>();

        for(int idx = 0; idx < modeNamesInOrder.length; idx++) {
            ModeOrderQuestionVariant variant = new ModeOrderQuestionVariant(idx, modeNamesInOrder[idx]);
            result.add(variant);
        }

        return result;
    }
}
