package com.martinkysel.guitarlib.tester;

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

import com.martinkysel.guitarlib.basics.Note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class DistanceTester {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random rand = new Random();

        Note n = new Note(Note.NoteName.A);

        int totalTests = 0;
        long totalTime = 0;

        while(true) {
            try {
                int distance = rand.nextInt(13);
                Note nNote = n.add(distance);

                System.out.println(String.format("%s + %d semitones is?", n.getNoteName(), distance));
                long start = System.nanoTime();
                String rawAnswer = reader.readLine();
                long end = System.nanoTime();
                long elapsedTime = end - start;
                totalTests++;
                totalTime += elapsedTime;

                try {
                    Note answer = new Note(Note.NoteName.valueOf(rawAnswer));

                    if (nNote.getNoteName() == answer.getNoteName()) {
                        System.out.println(String.format("Correct! (%.2f s)", (double)elapsedTime / 1000000000.0));
                    } else {
                        System.out.println(String.format("Wrong! The correct answer is %s", nNote.getNoteName()));
                    }

                } catch (IllegalArgumentException iae) {
                    System.out.println(String.format("'%s' is not a valid note name", rawAnswer));
                    continue;
                }

                System.out.println(String.format("Average time (%.2f s) for %d tests",
                        (double)totalTime / 1000000000.0 / totalTests, totalTests));

            } catch (IOException ioe) {

            }

        }

    }
}
