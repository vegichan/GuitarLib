package com.martinkysel.guitarlib.modes;

public class Modes {
    public enum ModeName {
        Ionian,
        Dorian,
        Phrygian,
        Lydian,
        Mixolydian,
        Aeolian,
        Locrian
    }

    public final static String patterns[] = {
            "X-X-X\nX-X-X",
            "X-X-X\nX-XX-",
            "X-XX-\nXX-X-",
            "-XX-X\nX-X-X",
            "X-X-X\nX-X-X",
            "X-XX-\nX-XX-",
            "XX-X-\nXX-X-"
    };
}
