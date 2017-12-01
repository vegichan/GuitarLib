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

package com.martinkysel.guitarlib.basics;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class NoteTest {

    @Test
    public void testDistances(){
        Note C1 = Note.getNote(Note.NoteName.C);
        Note C2 = Note.getNote(Note.NoteName.C);
        Note A = Note.getNote(Note.NoteName.A);

        assertEquals(0, Note.getDistance(C1, C2));

        assertEquals(3, Note.getDistance(A, C1));
        assertEquals(9, Note.getDistance(C1, A));
    }

    @Test
    public void testAdd(){
        Note C = Note.getNote(Note.NoteName.C);

        assertEquals(Note.NoteName.C, C.add(0).getNoteName());
        assertEquals(Note.NoteName.E, C.add(4).getNoteName());
        assertEquals(Note.NoteName.F, C.add(5).getNoteName());
        assertEquals(Note.NoteName.G, C.add(7).getNoteName());
    }

    @Test
    public void testSubtract(){
        Note C = Note.getNote(Note.NoteName.C);

        assertEquals(Note.NoteName.C, C.subtract(0).getNoteName());
        assertEquals(Note.NoteName.B, C.subtract(1).getNoteName());
        assertEquals(Note.NoteName.A, C.subtract(3).getNoteName());
        assertEquals(Note.NoteName.G, C.subtract(5).getNoteName());
    }

    @Test
    public void testEquivalency() {
        Note C1 = Note.getNote(Note.NoteName.C);
        Note C2 = Note.getNote(Note.NoteName.C);
        Note A = Note.getNote(Note.NoteName.A);

        assertTrue(C1.equals(C2));
        assertFalse(C1.equals(A));
    }

    @Test
    public void testSets() {
        Note C1 = Note.getNote(Note.NoteName.C);
        Note C2 = Note.getNote(Note.NoteName.C);
        Note A = Note.getNote(Note.NoteName.A);

        Set<Note> s1 = new HashSet<>();
        Set<Note> s2 = new HashSet<>();

        s1.add(C1);

        s2.add(C2);
        s2.add(A);

        s1.retainAll(s2);
        assertEquals(1, s1.size());
    }

}