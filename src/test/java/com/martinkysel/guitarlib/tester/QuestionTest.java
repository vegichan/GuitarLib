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

package com.martinkysel.guitarlib.tester;

import com.martinkysel.guitarlib.basics.Note;
import com.martinkysel.guitarlib.scales.ChromaticScale;
import com.martinkysel.guitarlib.scales.MajorScale;
import com.martinkysel.guitarlib.scales.Scale;
import com.martinkysel.guitarlib.tunings.StandardTuning;
import com.martinkysel.guitarlib.tunings.Tuning;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuestionTest {
    @Test
    public void testDistanceQuestion_Range5CBaseNote() {
        final int rangeTestedByThisTest = 5;
        final Note n = Note.getNote(Note.NoteName.C);
        final Question q = new DistanceQuestion(n, rangeTestedByThisTest);

        List<Question.QuestionVariant> variants = q.generateAllVariants();

        for (Question.QuestionVariant variant: variants) {
            assertTrue(variant instanceof DistanceQuestion.DistanceQuestionVariant);
            DistanceQuestion.DistanceQuestionVariant castedVariant = (DistanceQuestion.DistanceQuestionVariant) variant;
            assertTrue(Note.getDistance(n, castedVariant.note) <= rangeTestedByThisTest);
            assertTrue(Note.getDistance(n, castedVariant.note) == castedVariant.distance);
            assertEquals(n, castedVariant.startNote);
        }

    }

    @Test
    public void testPositionOnString_BaseNotesChromaticScale() {
        final Tuning tuning = new StandardTuning();
        final Scale scale = new ChromaticScale();
        final int lowFret = 0;
        final int highFret = 0;

        Set<Note> notesInTuning = new HashSet<>();
        notesInTuning.add(tuning.getString1());
        notesInTuning.add(tuning.getString2());
        notesInTuning.add(tuning.getString3());
        notesInTuning.add(tuning.getString4());
        notesInTuning.add(tuning.getString5());
        notesInTuning.add(tuning.getString6());

        final Question q = new PositionOnStringQuestion(tuning, scale, lowFret, highFret);

        List<Question.QuestionVariant> variants = q.generateAllVariants();
        for (Question.QuestionVariant variant: variants) {
            assertTrue(variant instanceof PositionOnStringQuestion.PositionOnStringQuestionVariant);
            PositionOnStringQuestion.PositionOnStringQuestionVariant castedVariant =
                    (PositionOnStringQuestion.PositionOnStringQuestionVariant) variant;
            assertEquals(0, castedVariant.fret);
            assertTrue(notesInTuning.contains(castedVariant.note));
        }
    }

    @Test
    public void testPositionOnString_AllNotesCScale() {
        final Tuning tuning = new StandardTuning();
        final Scale scale = new MajorScale(Note.NoteName.C);
        final int lowFret = 0;
        final int highFret = 12;

        Set<Note> notesInScale = new HashSet<>();
        notesInScale.addAll(scale.getAllNotesInScale());

        final Question q = new PositionOnStringQuestion(tuning, scale, lowFret, highFret);

        List<Question.QuestionVariant> variants = q.generateAllVariants();
        for (Question.QuestionVariant variant: variants) {
            assertTrue(variant instanceof PositionOnStringQuestion.PositionOnStringQuestionVariant);
            PositionOnStringQuestion.PositionOnStringQuestionVariant castedVariant =
                    (PositionOnStringQuestion.PositionOnStringQuestionVariant) variant;
            assertTrue(castedVariant.fret <= 12);
            assertTrue(castedVariant.fret >= 0);
            assertTrue(notesInScale.contains(castedVariant.note));
        }
    }

}
