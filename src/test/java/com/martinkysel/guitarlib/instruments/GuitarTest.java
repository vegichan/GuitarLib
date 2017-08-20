package com.martinkysel.guitarlib.instruments;

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
import com.martinkysel.guitarlib.tunings.DropTuning;
import com.martinkysel.guitarlib.tunings.Tuning;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuitarTest {

    @Test
    public void testGetStringStandardTuning() {
        Guitar g = new Guitar();

        assertEquals(Note.NoteName.E, g.getStringByName(Guitar.StringNames.HighE).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.B, g.getStringByName(Guitar.StringNames.B).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.G, g.getStringByName(Guitar.StringNames.G).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.D, g.getStringByName(Guitar.StringNames.D).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.A, g.getStringByName(Guitar.StringNames.A).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.E, g.getStringByName(Guitar.StringNames.LowE).getNoteAtPosition(0).getNoteName());

        assertEquals(Note.NoteName.E, g.getStringByPosition(0).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.B, g.getStringByPosition(1).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.G, g.getStringByPosition(2).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.D, g.getStringByPosition(3).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.A, g.getStringByPosition(4).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.E, g.getStringByPosition(5).getNoteAtPosition(0).getNoteName());

    }

    @Test
    public void testGetStringDropDTuning() {
        Tuning t = new DropTuning();
        Guitar g = new Guitar(t);

        assertEquals(Note.NoteName.E, g.getStringByName(Guitar.StringNames.HighE).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.B, g.getStringByName(Guitar.StringNames.B).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.G, g.getStringByName(Guitar.StringNames.G).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.D, g.getStringByName(Guitar.StringNames.D).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.A, g.getStringByName(Guitar.StringNames.A).getNoteAtPosition(0).getNoteName());
        assertEquals(Note.NoteName.D, g.getStringByName(Guitar.StringNames.LowE).getNoteAtPosition(0).getNoteName());

    }
}