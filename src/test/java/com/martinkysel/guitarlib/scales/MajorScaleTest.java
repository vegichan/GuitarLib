package com.martinkysel.guitarlib.scales;

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
import org.junit.Test;

import static org.junit.Assert.*;

public class MajorScaleTest {

    @Test
    public void CMajorTest(){
        DiatonicScale CMajor = new MajorScale();

        assertEquals(Note.NoteName.C, CMajor.note1().getNoteName());
        assertEquals(Note.NoteName.D, CMajor.note2().getNoteName());
        assertEquals(Note.NoteName.E, CMajor.note3().getNoteName());
        assertEquals(Note.NoteName.F, CMajor.note4().getNoteName());
        assertEquals(Note.NoteName.G, CMajor.note5().getNoteName());
        assertEquals(Note.NoteName.A, CMajor.note6().getNoteName());
        assertEquals(Note.NoteName.B, CMajor.note7().getNoteName());

    }

    @Test
    public void EMajorTest(){
        DiatonicScale EMajor = new MajorScale(Note.NoteName.E);

        assertEquals(Note.NoteName.E, EMajor.note1().getNoteName());
        assertEquals(Note.NoteName.Gb, EMajor.note2().getNoteName());
        assertEquals(Note.NoteName.Ab, EMajor.note3().getNoteName());
        assertEquals(Note.NoteName.A, EMajor.note4().getNoteName());
        assertEquals(Note.NoteName.B, EMajor.note5().getNoteName());
        assertEquals(Note.NoteName.Db, EMajor.note6().getNoteName());
        assertEquals(Note.NoteName.Eb, EMajor.note7().getNoteName());

    }

    @Test
    public void GMajorTest(){
        DiatonicScale GMajor = new MajorScale(Note.NoteName.G);

        assertEquals(Note.NoteName.G, GMajor.note1().getNoteName());
        assertEquals(Note.NoteName.A, GMajor.note2().getNoteName());
        assertEquals(Note.NoteName.B, GMajor.note3().getNoteName());
        assertEquals(Note.NoteName.C, GMajor.note4().getNoteName());
        assertEquals(Note.NoteName.D, GMajor.note5().getNoteName());
        assertEquals(Note.NoteName.E, GMajor.note6().getNoteName());
        assertEquals(Note.NoteName.Gb, GMajor.note7().getNoteName());
    }
}