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


package com.martinkysel.guitarlib.modes;

import com.martinkysel.guitarlib.basics.Note;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModeTest {

    @Test
    public void testCIonianMode() {
        Mode mode = new IonianMode(Note.NoteName.C);

        assertEquals(Note.NoteName.C, mode.note1().getNoteName());
        assertEquals(Note.NoteName.D, mode.note2().getNoteName());
        assertEquals(Note.NoteName.E, mode.note3().getNoteName());
        assertEquals(Note.NoteName.F, mode.note4().getNoteName());
        assertEquals(Note.NoteName.G, mode.note5().getNoteName());
        assertEquals(Note.NoteName.A, mode.note6().getNoteName());
        assertEquals(Note.NoteName.B, mode.note7().getNoteName());

    }

    @Test
    public void testDorianMode() {
        Mode mode = new DorianMode(Note.NoteName.C);

        assertEquals(Note.NoteName.C, mode.note1().getNoteName());
        assertEquals(Note.NoteName.D, mode.note2().getNoteName());
        assertEquals(Note.NoteName.Eb, mode.note3().getNoteName());
        assertEquals(Note.NoteName.F, mode.note4().getNoteName());
        assertEquals(Note.NoteName.G, mode.note5().getNoteName());
        assertEquals(Note.NoteName.A, mode.note6().getNoteName());
        assertEquals(Note.NoteName.Bb, mode.note7().getNoteName());

    }

    @Test
    public void testCPhrygianMode() {
        Mode mode = new PhrygianMode(Note.NoteName.C);

        assertEquals(Note.NoteName.C, mode.note1().getNoteName());
        assertEquals(Note.NoteName.Db, mode.note2().getNoteName());
        assertEquals(Note.NoteName.Eb, mode.note3().getNoteName());
        assertEquals(Note.NoteName.F, mode.note4().getNoteName());
        assertEquals(Note.NoteName.G, mode.note5().getNoteName());
        assertEquals(Note.NoteName.Ab, mode.note6().getNoteName());
        assertEquals(Note.NoteName.Bb, mode.note7().getNoteName());

    }

    @Test
    public void testCLydianMode() {
        Mode mode = new LydianMode(Note.NoteName.C);

        assertEquals(Note.NoteName.C, mode.note1().getNoteName());
        assertEquals(Note.NoteName.D, mode.note2().getNoteName());
        assertEquals(Note.NoteName.E, mode.note3().getNoteName());
        assertEquals(Note.NoteName.Gb, mode.note4().getNoteName());
        assertEquals(Note.NoteName.G, mode.note5().getNoteName());
        assertEquals(Note.NoteName.A, mode.note6().getNoteName());
        assertEquals(Note.NoteName.B, mode.note7().getNoteName());

    }

    @Test
    public void testCMixloydianMode() {
        Mode mode = new MixolydianMode(Note.NoteName.C);

        assertEquals(Note.NoteName.C, mode.note1().getNoteName());
        assertEquals(Note.NoteName.D, mode.note2().getNoteName());
        assertEquals(Note.NoteName.E, mode.note3().getNoteName());
        assertEquals(Note.NoteName.F, mode.note4().getNoteName());
        assertEquals(Note.NoteName.G, mode.note5().getNoteName());
        assertEquals(Note.NoteName.A, mode.note6().getNoteName());
        assertEquals(Note.NoteName.Bb, mode.note7().getNoteName());

    }

    @Test
    public void testCAeolianMode() {
        Mode mode = new AeolianMode(Note.NoteName.C);

        assertEquals(Note.NoteName.C, mode.note1().getNoteName());
        assertEquals(Note.NoteName.D, mode.note2().getNoteName());
        assertEquals(Note.NoteName.Eb, mode.note3().getNoteName());
        assertEquals(Note.NoteName.F, mode.note4().getNoteName());
        assertEquals(Note.NoteName.G, mode.note5().getNoteName());
        assertEquals(Note.NoteName.Ab, mode.note6().getNoteName());
        assertEquals(Note.NoteName.Bb, mode.note7().getNoteName());

    }

    @Test
    public void testCLocrianMode() {
        Mode mode = new LocrianMode(Note.NoteName.C);

        assertEquals(Note.NoteName.C, mode.note1().getNoteName());
        assertEquals(Note.NoteName.Db, mode.note2().getNoteName());
        assertEquals(Note.NoteName.Eb, mode.note3().getNoteName());
        assertEquals(Note.NoteName.F, mode.note4().getNoteName());
        assertEquals(Note.NoteName.Gb, mode.note5().getNoteName());
        assertEquals(Note.NoteName.Ab, mode.note6().getNoteName());
        assertEquals(Note.NoteName.Bb, mode.note7().getNoteName());

    }

    @Test
    public void testGIonianMode() {
        Mode mode = new IonianMode(Note.NoteName.G);

        assertEquals(Note.NoteName.G, mode.note1().getNoteName());
        assertEquals(Note.NoteName.A, mode.note2().getNoteName());
        assertEquals(Note.NoteName.B, mode.note3().getNoteName());
        assertEquals(Note.NoteName.C, mode.note4().getNoteName());
        assertEquals(Note.NoteName.D, mode.note5().getNoteName());
        assertEquals(Note.NoteName.E, mode.note6().getNoteName());
        assertEquals(Note.NoteName.Gb, mode.note7().getNoteName());

    }

    @Test
    public void testDMixolidianMode() {
        Mode mode = new MixolydianMode(Note.NoteName.D);

        assertEquals(Note.NoteName.D, mode.note1().getNoteName());
        assertEquals(Note.NoteName.E, mode.note2().getNoteName());
        assertEquals(Note.NoteName.Gb, mode.note3().getNoteName());
        assertEquals(Note.NoteName.G, mode.note4().getNoteName());
        assertEquals(Note.NoteName.A, mode.note5().getNoteName());
        assertEquals(Note.NoteName.B, mode.note6().getNoteName());
        assertEquals(Note.NoteName.C, mode.note7().getNoteName());

    }

    @Test
    public void testDMixolidianContainsSameAsCIonian() {
        Mode cIonian = new IonianMode(Note.NoteName.G);
        Mode dMixolydian = new MixolydianMode(Note.NoteName.D);

        assertTrue(cIonian.getAllNotesInScale().containsAll(dMixolydian.getAllNotesInScale()));
    }
}
