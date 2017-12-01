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

import com.martinkysel.guitarlib.modes.Modes;

import java.util.ArrayList;
import java.util.List;

public class IdentifyModeQuestion implements Question {
    public class IdentifyModeQuestionVariant extends QuestionVariant {
        public Modes.ModeName modeName;
        public Modes.ModeName alternativeName;
        public String pattern;

        public IdentifyModeQuestionVariant(Modes.ModeName n, String p) {
            this.modeName = n;
            this.pattern = p;

            if (modeName == Modes.ModeName.Ionian) {
                alternativeName = Modes.ModeName.Mixolydian;
            }
            if (modeName == Modes.ModeName.Mixolydian) {
                alternativeName = Modes.ModeName.Ionian;
            }
        }

        @Override
        String getQuestion() {
            return String.format("Identify the following pattern:\n\n%s\n", pattern);
        }

        @Override
        String validateAnswer(String rawAnswer) {
            try {

                if (modeName.name().startsWith(rawAnswer) ||
                        (alternativeName != null && alternativeName.name().startsWith(rawAnswer))) {
                    return "Correct!";
                } else {
                    return String.format("Wrong! The correct answer is %s", modeName);
                }


            } catch (IllegalArgumentException iae) {
                return String.format("'%s' is not a valid answer", rawAnswer);
            }
        }
    }

    public IdentifyModeQuestion() {
    }

    @Override
    public List<QuestionVariant> generateAllVariants() {
        Modes.ModeName modeNamesInOrder[] =  Modes.ModeName.values();

        List<QuestionVariant> result = new ArrayList<>();

        for(int idx = 0; idx < modeNamesInOrder.length; idx++) {
            IdentifyModeQuestionVariant variant =
                    new IdentifyModeQuestionVariant(modeNamesInOrder[idx], Modes.patterns[idx]);
            result.add(variant);
        }

        return result;
    }
}
