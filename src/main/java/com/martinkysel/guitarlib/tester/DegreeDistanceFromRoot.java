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

public class DegreeDistanceFromRoot implements Question {
    public class DistanceQuestionVariant extends QuestionVariant {
        public int degree;
        public int distance;

        public DistanceQuestionVariant(int degree, int d) {
            this.degree = degree;
            this.distance = d;
        }

        @Override
        String getQuestion() {
            return String.format("Degree %d?", degree);
        }

        @Override
        String validateAnswer(String rawAnswer) {
            try {
                int answer = Integer.valueOf(rawAnswer);

                if (answer == distance) {
                    return "Correct!";
                } else {
                    return String.format("Wrong! The correct answer is %d", distance);
                }

            } catch (IllegalArgumentException iae) {
                return String.format("'%s' is not a valid number", rawAnswer);
            }
        }
    }

    public DegreeDistanceFromRoot() {
    }

    @Override
    public List<QuestionVariant> generateAllVariants() {
        List<QuestionVariant> result = new ArrayList<>();

        int[] distances = {0, 2, 4, 5, 7, 9, 11};

        for (int i = 0; i < 7; i++) {
            result.add(new DistanceQuestionVariant(i+1, distances[i]));
        }

        return result;
    }
}
