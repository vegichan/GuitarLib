/**
 * GuitarLib
 * Copyright (C) 2017 Martin Kysel
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **/

package com.martinkysel.guitarlib.scales;

import com.martinkysel.guitarlib.basics.Note;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HarmonicMinorScale implements DiatonicScale {
    private Note keyNote;
    private final int[] distances = {0, 2, 3, 5, 7, 8, 11}; // R, W, H, W, W, H, 1 1/2, H
    private Note[] notesInScale;

    public HarmonicMinorScale(){
        this.keyNote = Note.getNote(Note.NoteName.C);
        fillNoteArray();
    }

    public HarmonicMinorScale(Note.NoteName keyNote){
        this.keyNote = Note.getNote(keyNote);
        fillNoteArray();
    }

    @Override
    public Note note1() {
        return notesInScale[0];
    }

    @Override
    public Note note2() {
        return notesInScale[1];
    }

    @Override
    public Note note3() {
        return notesInScale[2];
    }

    @Override
    public Note note4() {
        return notesInScale[3];
    }

    @Override
    public Note note5() {
        return notesInScale[4];
    }

    @Override
    public Note note6() {
        return notesInScale[5];
    }

    @Override
    public Note note7() {
        return notesInScale[6];
    }

    @Override
    public Set<Note> getAllNotesInScale() {
        Set<Note> list = new HashSet<>();
        list.addAll(Arrays.asList(notesInScale));
        return list;
    }

    private void fillNoteArray(){
        notesInScale = new Note[]{
                keyNote.add(distances[0]),
                keyNote.add(distances[1]),
                keyNote.add(distances[2]),
                keyNote.add(distances[3]),
                keyNote.add(distances[4]),
                keyNote.add(distances[5]),
                keyNote.add(distances[6]),
        };
    }
}
