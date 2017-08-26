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