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

import java.util.HashSet;
import java.util.Set;

public class NaturalMinorScale implements DiatonicScale {
    @Override
    public Note note1() {
        return keyNote.add(distances[0]);
    }

    @Override
    public Note note2() {
        return keyNote.add(distances[1]);
    }

    @Override
    public Note note3() {
        return keyNote.add(distances[2]);
    }

    @Override
    public Note note4() {
        return keyNote.add(distances[3]);
    }

    @Override
    public Note note5() {
        return keyNote.add(distances[4]);
    }

    @Override
    public Note note6() {
        return keyNote.add(distances[5]);
    }

    @Override
    public Note note7() {
        return keyNote.add(distances[6]);
    }

    @Override
    public Set<Note> getAllNotesInScale() {
        Set<Note> list = new HashSet<>();
        list.add(note1());
        list.add(note2());
        list.add(note3());
        list.add(note4());
        list.add(note5());
        list.add(note6());
        list.add(note7());

        return list;
    }

    public NaturalMinorScale(){
        this.keyNote = Note.getNote(Note.NoteName.C);
    }

    public NaturalMinorScale(Note.NoteName keyNote){
        this.keyNote = Note.getNote(keyNote);
    }

    Note keyNote;
    private final int[] distances = {0, 2, 3, 5, 7, 8, 10};
}
