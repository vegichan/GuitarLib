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

package com.martinkysel.guitarlib.tunings;

import com.martinkysel.guitarlib.basics.Note;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DropTuningTest {

    @Test
    public void testDropDTuning(){
        Tuning t = new DropTuning();

        assertEquals(Note.NoteName.E, t.getString1().getNoteName());
        assertEquals(Note.NoteName.B, t.getString2().getNoteName());
        assertEquals(Note.NoteName.G, t.getString3().getNoteName());
        assertEquals(Note.NoteName.D, t.getString4().getNoteName());
        assertEquals(Note.NoteName.A, t.getString5().getNoteName());
        assertEquals(Note.NoteName.D, t.getString6().getNoteName());
    }
}