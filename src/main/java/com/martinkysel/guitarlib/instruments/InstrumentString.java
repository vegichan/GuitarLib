package com.martinkysel.guitarlib.instruments;

import com.martinkysel.guitarlib.basics.Note;

import java.util.HashSet;
import java.util.Set;

public class InstrumentString {
    public InstrumentString(Note baseNote){
        this.baseNote = baseNote;
    }

    public Note getNoteAtPosition(int pos){
        return baseNote.add(pos);
    }

    public Set<Note> getNotesInRange(int low, int high) {
        Set<Note> notes = new HashSet<>();

        for (int i=low; i<= high; i++){
            Note n = getNoteAtPosition(i);
            notes.add(n);
        }

        return notes;
    }


    Note baseNote;
}
