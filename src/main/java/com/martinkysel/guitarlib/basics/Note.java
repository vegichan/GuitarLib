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
    public Note(NoteName name){
        noteName = name;
    }

    public Note(int value){
        noteName = NoteName.values()[value];
    }

    public static int getDistance(Note a, Note b){
        return (12 + b.noteName.ordinal() - a.noteName.ordinal()) % 12;
    }

    public Note add(int distance) {
        return new Note((noteName.ordinal() + distance ) % 12);
    }

    public Note subtract(int distance) {
        return new Note((36 + noteName.ordinal() - distance ) % 12);
    }

    public NoteName getNoteName() {
        return noteName;
    }

    private NoteName noteName;
}

