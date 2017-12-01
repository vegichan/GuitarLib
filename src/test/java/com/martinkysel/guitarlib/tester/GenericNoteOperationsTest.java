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
import com.martinkysel.guitarlib.instruments.InstrumentString;
import com.martinkysel.guitarlib.scales.MajorScale;
import com.martinkysel.guitarlib.scales.Scale;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GenericNoteOperationsTest {
    @Test
    public void testStringScaleIntersection() {
        InstrumentString instrumentString = new InstrumentString(Note.getNote(Note.NoteName.E));
        Scale s = new MajorScale(Note.NoteName.C);

        Set<Note> stringNotes = instrumentString.getNotesInRange(0, 5); // E-A
        Set<Note> scaleNotes = s.getAllNotesInScale();

        stringNotes.retainAll(scaleNotes);

        assertTrue(stringNotes.contains(Note.getNote(Note.NoteName.E))); // 0
        assertTrue(stringNotes.contains(Note.getNote(Note.NoteName.F))); // 1
        assertTrue(stringNotes.contains(Note.getNote(Note.NoteName.G))); // 3
        assertTrue(stringNotes.contains(Note.getNote(Note.NoteName.A))); // 5

        assertFalse(stringNotes.contains(Note.getNote(Note.NoteName.Gb))); // 2
        assertFalse(stringNotes.contains(Note.getNote(Note.NoteName.Ab))); // 4
    }
}
