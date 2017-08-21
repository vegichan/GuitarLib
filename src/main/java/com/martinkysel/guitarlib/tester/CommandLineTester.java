package com.martinkysel.guitarlib.tester;

import com.martinkysel.guitarlib.basics.Note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineTester {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        NoteGenerator ng = new NoteGenerator();

        int totalTests = 0;
        long totalTime = 0;

        while(true) {
            try {
                NoteGenerator.GeneratedNote note = ng.generateNextNote();

                System.out.println(String.format("String nr %d, fret %d", note.stringPos+1, note.fretPos));
                long start = System.nanoTime();
                String rawAnswer = reader.readLine();
                long end = System.nanoTime();
                long elapsedTime = end - start;
                totalTests++;
                totalTime += elapsedTime;

                try {
                    Note answer = new Note(Note.NoteName.valueOf(rawAnswer));

                    if (note.note.getNoteName() == answer.getNoteName()) {
                        System.out.println(String.format("Correct! (%.2f s)", (double)elapsedTime / 1000000000.0));
                    } else {
                        System.out.println(String.format("Wrong! The correct answer is %s", note.note.getNoteName()));
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
