package com.martinkysel.guitarlib;

import org.junit.Test;

import static org.junit.Assert.*;

public class StandardTuningTest {

    @Test
    public void testETuning(){
        Tuning t = new StandardTuning();

        assertEquals(Note.NoteName.E, t.getString1().getNoteName());
        assertEquals(Note.NoteName.B, t.getString2().getNoteName());
        assertEquals(Note.NoteName.G, t.getString3().getNoteName());
        assertEquals(Note.NoteName.D, t.getString4().getNoteName());
        assertEquals(Note.NoteName.A, t.getString5().getNoteName());
        assertEquals(Note.NoteName.E, t.getString6().getNoteName());
    }

    @Test
    public void testBTuning(){
        Tuning t = new StandardTuning(Note.NoteName.B);

        assertEquals(Note.NoteName.B, t.getString1().getNoteName());
        assertEquals(Note.NoteName.Gb, t.getString2().getNoteName());
        assertEquals(Note.NoteName.D, t.getString3().getNoteName());
        assertEquals(Note.NoteName.A, t.getString4().getNoteName());
        assertEquals(Note.NoteName.E, t.getString5().getNoteName());
        assertEquals(Note.NoteName.B, t.getString6().getNoteName());
    }

}