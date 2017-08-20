package com.martinkysel.guitarlib;

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