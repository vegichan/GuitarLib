package com.martinkysel.guitarlib.instruments;

import com.martinkysel.guitarlib.tunings.StandardTuning;
import com.martinkysel.guitarlib.tunings.Tuning;

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

public class Guitar {
    public enum StringNames {
        HighE, B, G, D, A, LowE
    }


    public Guitar(){
        this.tuning = new StandardTuning();
        strings[0] = new String(tuning.getString1());
        strings[1] = new String(tuning.getString2());
        strings[2] = new String(tuning.getString3());
        strings[3] = new String(tuning.getString4());
        strings[4] = new String(tuning.getString5());
        strings[5] = new String(tuning.getString6());
    }

    public Guitar(Tuning tuning){
        this.tuning = tuning;
        strings[0] = new String(tuning.getString1());
        strings[1] = new String(tuning.getString2());
        strings[2] = new String(tuning.getString3());
        strings[3] = new String(tuning.getString4());
        strings[4] = new String(tuning.getString5());
        strings[5] = new String(tuning.getString6());
    }

    public String getStringByName(StringNames sn) {
        return strings[sn.ordinal()];
    }

    public String getStringByPosition(int pos) {
        return strings[pos];
    }

    private Tuning tuning;
    private String[] strings = new String[6];
}
