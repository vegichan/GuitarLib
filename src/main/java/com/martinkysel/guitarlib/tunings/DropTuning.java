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

package com.martinkysel.guitarlib.tunings;

import com.martinkysel.guitarlib.basics.Note;

public class DropTuning implements Tuning {
    private Note baseNote;
    private final int[] distances = {0, 5, 9, 14, 19, 26};
    private Note[] notesInTuning;
    
    public DropTuning(Note.NoteName baseNote) {
        this.baseNote = Note.getNote(baseNote);
        fillNoteArray();
    }

    public DropTuning() {
        this.baseNote = Note.getNote(Note.NoteName.E);
        fillNoteArray();
    }

    @Override
    public Note getString1() {
        return notesInTuning[0];
    }

    @Override
    public Note getString2() {
        return notesInTuning[1];
    }

    @Override
    public Note getString3() {
        return notesInTuning[2];
    }

    @Override
    public Note getString4() {
        return notesInTuning[3];
    }

    @Override
    public Note getString5() {
        return notesInTuning[4];
    }

    @Override
    public Note getString6() {
        return notesInTuning[5];
    }

    private void fillNoteArray(){
        notesInTuning = new Note[]{
                baseNote.subtract(distances[0]),
                baseNote.subtract(distances[1]),
                baseNote.subtract(distances[2]),
                baseNote.subtract(distances[3]),
                baseNote.subtract(distances[4]),
                baseNote.subtract(distances[5]),
        };
    }
}
