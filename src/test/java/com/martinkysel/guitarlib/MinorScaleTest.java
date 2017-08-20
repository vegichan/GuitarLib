package com.martinkysel.guitarlib;

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
import com.martinkysel.guitarlib.scales.DiatonicScale;
import com.martinkysel.guitarlib.scales.NaturalMinorScale;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinorScaleTest {

    @Test
    public void AMinorTest(){
        DiatonicScale AMajor = new NaturalMinorScale(Note.NoteName.A);

        assertEquals(Note.NoteName.A, AMajor.note1().getNoteName());
        assertEquals(Note.NoteName.B, AMajor.note2().getNoteName());
        assertEquals(Note.NoteName.C, AMajor.note3().getNoteName());
        assertEquals(Note.NoteName.D, AMajor.note4().getNoteName());
        assertEquals(Note.NoteName.E, AMajor.note5().getNoteName());
        assertEquals(Note.NoteName.F, AMajor.note6().getNoteName());
        assertEquals(Note.NoteName.G, AMajor.note7().getNoteName());

    }

    @Test
    public void EMinorTest(){
        DiatonicScale EMajor = new NaturalMinorScale(Note.NoteName.E);

        assertEquals(Note.NoteName.E, EMajor.note1().getNoteName());
        assertEquals(Note.NoteName.Gb, EMajor.note2().getNoteName());
        assertEquals(Note.NoteName.G, EMajor.note3().getNoteName());
        assertEquals(Note.NoteName.A, EMajor.note4().getNoteName());
        assertEquals(Note.NoteName.B, EMajor.note5().getNoteName());
        assertEquals(Note.NoteName.C, EMajor.note6().getNoteName());
        assertEquals(Note.NoteName.D, EMajor.note7().getNoteName());

    }
}