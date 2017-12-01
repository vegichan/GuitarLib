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

package com.martinkysel.guitarlib.instruments;

import com.martinkysel.guitarlib.basics.Note;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class InstrumentStringTest {

    @Test
    public void EStringTest() {
        InstrumentString e = new InstrumentString(Note.getNote(Note.NoteName.E));

        assertEquals(Note.NoteName.E, e.getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.Gb, e.getNoteAtPosition(2).getNoteName());
        assertEquals(Note.NoteName.G, e.getNoteAtPosition(3).getNoteName());
        assertEquals(Note.NoteName.A, e.getNoteAtPosition(5).getNoteName());
        assertEquals(Note.NoteName.B, e.getNoteAtPosition(7).getNoteName());
        assertEquals(Note.NoteName.C, e.getNoteAtPosition(8).getNoteName());
        assertEquals(Note.NoteName.E, e.getNoteAtPosition(12).getNoteName());
        assertEquals(Note.NoteName.G, e.getNoteAtPosition(15).getNoteName());
        assertEquals(Note.NoteName.E, e.getNoteAtPosition(24).getNoteName());
    }

    @Test
    public void EStringRangeTest() {
        InstrumentString e = new InstrumentString(Note.getNote(Note.NoteName.E));

        Set<Note> notesInRange = e.getNotesInRange(0, 4);
        assertTrue(notesInRange.contains(Note.getNote(Note.NoteName.E))); // 0
        assertTrue(notesInRange.contains(Note.getNote(Note.NoteName.F))); // 1
        assertTrue(notesInRange.contains(Note.getNote(Note.NoteName.Gb))); // 2
        assertTrue(notesInRange.contains(Note.getNote(Note.NoteName.G))); // 3
        assertTrue(notesInRange.contains(Note.getNote(Note.NoteName.Ab))); // 4
    }

}