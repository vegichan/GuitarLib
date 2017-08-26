package com.martinkysel.guitarlib.tester;

import com.martinkysel.guitarlib.basics.Note;
import com.martinkysel.guitarlib.instruments.Guitar;
import com.martinkysel.guitarlib.instruments.InstrumentString;
import com.martinkysel.guitarlib.scales.ChromaticScale;
import com.martinkysel.guitarlib.scales.Scale;
import com.martinkysel.guitarlib.tunings.StandardTuning;
import com.martinkysel.guitarlib.tunings.Tuning;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

public class PositionOnStringQuestion implements Question {
    public class PositionOnStringQuestionVariant extends QuestionVariant {
        @Override
        String getQuestion() {
            return String.format("Fret %d on the %d string?", fret, stringPos+1);
        }

        @Override
        String validateAnswer(String rawAnswer) {
            try {
                Note parsedAnswer = Note.getNote(Note.NoteName.valueOf(rawAnswer));

                if (this.note.getNoteName() == parsedAnswer.getNoteName()) {
                    return "Correct!";
                } else {
                    return String.format("Wrong! The correct answer is %s", this.note.getNoteName());
                }

            } catch (IllegalArgumentException iae) {
                return String.format("'%scale' is not a valid note name", rawAnswer);
            }
        }

        public PositionOnStringQuestionVariant(InstrumentString s, int sp, int fp, Note n) {
            this.string = s;
            this.stringPos = sp;
            this.fret = fp;
            this.note = n;
        }

        public InstrumentString string;
        public int fret;
        public int stringPos;
        public Note note;
    }

    @Override
    public List<QuestionVariant> generateAllVariants() {
        List<QuestionVariant> result = new ArrayList<>();

        for (int stringPos = 0; stringPos < guitar.getNrStrings(); stringPos++) {
            if (!useString[stringPos]) {
                continue;
            }

            InstrumentString instrumentString = guitar.getStringByPosition(stringPos);

            Set<Note> stringNotes = instrumentString.getNotesInRange(lowFret, highFret);
            Set<Note> scaleNotes = scale.getAllNotesInScale();
            stringNotes.retainAll(scaleNotes);

            for (Note note: stringNotes) {
                int fretPos = Note.getDistance(instrumentString.getNoteAtPosition(0), note);


                PositionOnStringQuestionVariant variant =
                        new PositionOnStringQuestionVariant(instrumentString, stringPos, fretPos, note);
                result.add(variant);
            }


        }

        return result;
    }

    public PositionOnStringQuestion (Tuning t, Scale s, int lf, int hf) {
        this.tuning = t;
        this.guitar = new Guitar(tuning);
        this.scale = s;
        this.lowFret = lf;
        this.highFret = hf;

    }


    private Tuning tuning;
    private Guitar guitar;
    private Scale scale;

    private int lowFret;
    private int highFret;

    private boolean[] useString = {true, true, true, true, true, true};
}
