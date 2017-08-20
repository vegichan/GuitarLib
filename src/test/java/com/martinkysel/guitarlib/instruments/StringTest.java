package com.martinkysel.guitarlib.instruments;

import com.martinkysel.guitarlib.basics.Note;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringTest {

    @Test
    public void EStringTest() {
        String e = new String(new Note(Note.NoteName.E));

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


}