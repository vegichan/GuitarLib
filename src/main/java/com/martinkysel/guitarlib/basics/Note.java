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
        C(0), Db(1), D(2), Eb(3), E(4), F(5), Gb(6), G(7), Ab(8), A(9), Bb(10), B(11);
        private final int value;

        NoteName(int value) {
            this.value = value;
        }

    }
    public Note(NoteName name){
        noteName = name;
    }

    public Note(int value){
        noteName = NoteName.values()[value];
    }

    public static int getDistance(Note a, Note b){
        return (12 + b.noteName.value - a.noteName.value) % 12;
    }

    public Note add(int distance) {
        return new Note((noteName.value + distance ) % 12);
    }

    public Note subtract(int distance) {
        return new Note((36 + noteName.value - distance ) % 12);
    }

    public NoteName getNoteName() {
        return noteName;
    }

    private NoteName noteName;
}

