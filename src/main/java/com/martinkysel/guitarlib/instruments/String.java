package com.martinkysel.guitarlib.instruments;

import com.martinkysel.guitarlib.basics.Note;

public class String {
    public String(Note baseNote){
        this.baseNote = baseNote;
    }

    public Note getNoteAtPosition(int pos){
        return baseNote.add(pos);
    }


    Note baseNote;
}
