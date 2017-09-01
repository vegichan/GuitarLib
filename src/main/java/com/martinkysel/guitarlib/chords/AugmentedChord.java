package com.martinkysel.guitarlib.chords;


import com.martinkysel.guitarlib.basics.Note;

import java.util.LinkedList;
import java.util.List;

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

public class AugmentedChord implements Chord {


    public AugmentedChord(Note b) {
        this.baseNote = b;
    }

    @Override
    public List<Note> getNotes() {
        List<Note> notes = new LinkedList();
        notes.add(baseNote);
        notes.add(baseNote.add(4));
        notes.add(baseNote.add(8));

        return notes;
    }

    Note baseNote;
}
