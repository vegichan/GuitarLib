package com.martinkysel.guitarlib.tester;

import com.martinkysel.guitarlib.basics.Note;
import com.martinkysel.guitarlib.instruments.Guitar;
import com.martinkysel.guitarlib.tunings.StandardTuning;
import com.martinkysel.guitarlib.tunings.Tuning;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NoteGenerator {
    public class GeneratedNote {
        public GeneratedNote(Note note, int stringPos, int fretPos) {
            this.note = note;
            this.stringPos = stringPos;
            this.fretPos = fretPos;
        }

        Note note;
        int stringPos;
        int fretPos;
    }


    public GeneratedNote generateNextNote(){
        int stringPos = getRandomAllowedString();
        int fretPos = rand.nextInt(highFret - lowFret + 1) + lowFret;
        com.martinkysel.guitarlib.instruments.String string = g.getStringByPosition(stringPos);
        Note note = string.getNoteAtPosition(fretPos);
        return new GeneratedNote(note, stringPos, fretPos);
    }


    private int getRandomAllowedString() {
        List<Integer> allowedStrings = new ArrayList();
        for (int i =0; i <6; i++) {
            if(useString[i]) {
                allowedStrings.add(i);
            }
        }
        int rnd = rand.nextInt(allowedStrings.size());
        return allowedStrings.get(rnd);
    }

    private Tuning t = new StandardTuning();
    private Guitar g = new Guitar(t);

    private int lowFret = 0;
    private int highFret = 4;

    private boolean[] useString = {true, false, false, false, false, false};
    //private boolean[] useString = {true, true, true, true, true, true};

    Random rand = new Random();
}
