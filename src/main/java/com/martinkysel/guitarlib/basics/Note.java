package com.martinkysel.guitarlib.basics;

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

public class Note {
    public enum NoteName {
        C, Db, D, Eb, E, F, Gb, G, Ab, A, Bb, B;

    }
    private Note(NoteName name){
        noteName = name;
    }

    private Note(int value){
        noteName = NoteName.values()[value];
    }

    public static Note getNote(NoteName name) {
        return staticArray[name.ordinal()];
    }

    public static Note getNote(int value) {
        return staticArray[value];
    }

    public static int getDistance(Note a, Note b){
        return (12 + b.noteName.ordinal() - a.noteName.ordinal()) % 12;
    }

    public Note add(int distance) {
        return staticArray[(noteName.ordinal() + distance ) % 12];
    }

    public Note subtract(int distance) {
        return staticArray[(36 + noteName.ordinal() - distance ) % 12];
    }

    public NoteName getNoteName() {
        return noteName;
    }

    private NoteName noteName;
    private static final Note[] staticArray = {new Note(NoteName.C),
            new Note(NoteName.Db),
            new Note(NoteName.D),
            new Note(NoteName.Eb),
            new Note(NoteName.E),
            new Note(NoteName.F),
            new Note(NoteName.Gb),
            new Note(NoteName.G),
            new Note(NoteName.Ab),
            new Note(NoteName.A),
            new Note(NoteName.Bb),
            new Note(NoteName.B),
    };
}

