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

package com.martinkysel.guitarlib.chords;

import com.martinkysel.guitarlib.basics.Note;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChordTest {

    @Test
    public void testCMajorChord() {
        Chord chord = new MajorChord(Note.getNote(Note.NoteName.C));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.C), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.E), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.G), notes.get(2));
    }

    @Test
    public void testFMajorChord() {
        Chord chord = new MajorChord(Note.getNote(Note.NoteName.F));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.F), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.A), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.C), notes.get(2));
    }

    @Test
    public void testGMajorChord() {
        Chord chord = new MajorChord(Note.getNote(Note.NoteName.G));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.G), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.B), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.D), notes.get(2));
    }

    @Test
    public void testBbMajorChord() {
        Chord chord = new MajorChord(Note.getNote(Note.NoteName.Bb));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.Bb), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.D), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.F), notes.get(2));
    }

    @Test
    public void testCMinorChord() {
        Chord chord = new MinorChord(Note.getNote(Note.NoteName.C));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.C), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.Eb), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.G), notes.get(2));
    }

    @Test
    public void testFMinorChord() {
        Chord chord = new MinorChord(Note.getNote(Note.NoteName.F));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.F), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.Ab), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.C), notes.get(2));
    }

    @Test
    public void testGMinorChord() {
        Chord chord = new MinorChord(Note.getNote(Note.NoteName.G));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.G), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.Bb), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.D), notes.get(2));
    }

    @Test
    public void testBbMinorChord() {
        Chord chord = new MinorChord(Note.getNote(Note.NoteName.Bb));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.Bb), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.Db), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.F), notes.get(2));
    }

    @Test
    public void testCDiminishedChord() {
        Chord chord = new DiminishedChord(Note.getNote(Note.NoteName.C));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.C), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.Eb), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.Gb), notes.get(2));
    }

    @Test
    public void testFDiminishedChord() {
        Chord chord = new DiminishedChord(Note.getNote(Note.NoteName.F));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.F), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.Ab), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.B), notes.get(2));
    }

    @Test
    public void testGDiminishedChord() {
        Chord chord = new DiminishedChord(Note.getNote(Note.NoteName.G));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.G), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.Bb), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.Db), notes.get(2));
    }

    @Test
    public void testBbDiminishedChord() {
        Chord chord = new DiminishedChord(Note.getNote(Note.NoteName.Bb));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.Bb), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.Db), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.E), notes.get(2));
    }

    @Test
    public void testCAugmentedChord() {
        Chord chord = new AugmentedChord(Note.getNote(Note.NoteName.C));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.C), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.E), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.Ab), notes.get(2));
    }

    @Test
    public void testFAugmentedChord() {
        Chord chord = new AugmentedChord(Note.getNote(Note.NoteName.F));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.F), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.A), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.Db), notes.get(2));
    }

    @Test
    public void testGAugmentedChord() {
        Chord chord = new AugmentedChord(Note.getNote(Note.NoteName.G));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.G), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.B), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.Eb), notes.get(2));
    }

    @Test
    public void testBbAugmentedChord() {
        Chord chord = new AugmentedChord(Note.getNote(Note.NoteName.Bb));
        List<Note> notes = chord.getNotes();
        assertEquals(3, notes.size());
        assertEquals(Note.getNote(Note.NoteName.Bb), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.D), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.Gb), notes.get(2));
    }

    @Test
    public void testCMajor7Chord() {
        Chord chord = new Major7Chord(Note.getNote(Note.NoteName.C));
        List<Note> notes = chord.getNotes();
        assertEquals(4, notes.size());
        assertEquals(Note.getNote(Note.NoteName.C), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.E), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.G), notes.get(2));
        assertEquals(Note.getNote(Note.NoteName.B), notes.get(3));
    }

    @Test
    public void testFMajor7Chord() {
        Chord chord = new Major7Chord(Note.getNote(Note.NoteName.F));
        List<Note> notes = chord.getNotes();
        assertEquals(4, notes.size());
        assertEquals(Note.getNote(Note.NoteName.F), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.A), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.C), notes.get(2));
        assertEquals(Note.getNote(Note.NoteName.E), notes.get(3));
    }

    @Test
    public void testGMajor7Chord() {
        Chord chord = new Major7Chord(Note.getNote(Note.NoteName.G));
        List<Note> notes = chord.getNotes();
        assertEquals(4, notes.size());
        assertEquals(Note.getNote(Note.NoteName.G), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.B), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.D), notes.get(2));
        assertEquals(Note.getNote(Note.NoteName.Gb), notes.get(3));
    }

    @Test
    public void testBbMajor7Chord() {
        Chord chord = new Major7Chord(Note.getNote(Note.NoteName.Bb));
        List<Note> notes = chord.getNotes();
        assertEquals(4, notes.size());
        assertEquals(Note.getNote(Note.NoteName.Bb), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.D), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.F), notes.get(2));
        assertEquals(Note.getNote(Note.NoteName.A), notes.get(3));
    }

    @Test
    public void testCMinor7Chord() {
        Chord chord = new Minor7Chord(Note.getNote(Note.NoteName.C));
        List<Note> notes = chord.getNotes();
        assertEquals(4, notes.size());
        assertEquals(Note.getNote(Note.NoteName.C), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.Eb), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.G), notes.get(2));
        assertEquals(Note.getNote(Note.NoteName.Bb), notes.get(3));
    }

    @Test
    public void testFMinor7Chord() {
        Chord chord = new Minor7Chord(Note.getNote(Note.NoteName.F));
        List<Note> notes = chord.getNotes();
        assertEquals(4, notes.size());
        assertEquals(Note.getNote(Note.NoteName.F), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.Ab), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.C), notes.get(2));
        assertEquals(Note.getNote(Note.NoteName.Eb), notes.get(3));
    }

    @Test
    public void testGMinor7Chord() {
        Chord chord = new Minor7Chord(Note.getNote(Note.NoteName.G));
        List<Note> notes = chord.getNotes();
        assertEquals(4, notes.size());
        assertEquals(Note.getNote(Note.NoteName.G), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.Bb), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.D), notes.get(2));
        assertEquals(Note.getNote(Note.NoteName.F), notes.get(3));
    }

    @Test
    public void testBbMinor7Chord() {
        Chord chord = new Minor7Chord(Note.getNote(Note.NoteName.Bb));
        List<Note> notes = chord.getNotes();
        assertEquals(4, notes.size());
        assertEquals(Note.getNote(Note.NoteName.Bb), notes.get(0));
        assertEquals(Note.getNote(Note.NoteName.Db), notes.get(1));
        assertEquals(Note.getNote(Note.NoteName.F), notes.get(2));
        assertEquals(Note.getNote(Note.NoteName.Ab), notes.get(3));
    }
}
