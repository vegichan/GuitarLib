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

package com.martinkysel.guitarlib.modes;

import com.martinkysel.guitarlib.basics.Note;
import com.martinkysel.guitarlib.scales.MajorScale;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LocrianMode implements Mode {
    private Note keyNote;
    private Note[] notesInScale;
    private final int distanceFromBaseNote = 11;

    LocrianMode(Note.NoteName keyNote) {
        this.keyNote = Note.getNote(keyNote);
        MajorScale scale = new MajorScale(this.keyNote.subtract(distanceFromBaseNote).getNoteName());
        this.notesInScale = new Note[]{
                scale.note7(),
                scale.note1(),
                scale.note2(),
                scale.note3(),
                scale.note4(),
                scale.note5(),
                scale.note6(),
        };
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

    @Override
    public Modes.ModeName getName() {
        return Modes.ModeName.Locrian;
    }
}
