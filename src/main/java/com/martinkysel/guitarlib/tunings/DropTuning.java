package com.martinkysel.guitarlib.tunings;

import com.martinkysel.guitarlib.basics.Note;

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

public class DropTuning implements Tuning {
    public Note getString1() {
        return baseNote;
    }
    public Note getString2() {
        return baseNote.subtract(distances[1]);
    }
    public Note getString3() {
        return baseNote.subtract(distances[2]);
    }
    public Note getString4() {
        return baseNote.subtract(distances[3]);
    }
    public Note getString5() {
        return baseNote.subtract(distances[4]);
    }
    public Note getString6() {
        return baseNote.subtract(distances[5]);
    }

    public DropTuning(Note.NoteName baseNote) {
        this.baseNote = new Note(baseNote);
    }

    public DropTuning() {
        this.baseNote = new Note(Note.NoteName.E);
    }


    private Note baseNote;
    private final int[] distances = {0, 5, 9, 14, 19, 26};
}
