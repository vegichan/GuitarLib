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
        fillStringArray();
    }

    public Guitar(Tuning tuning){
        this.tuning = tuning;
        fillStringArray();
    }

    private void fillStringArray(){
        strings = new InstrumentString[] {
                new InstrumentString(tuning.getString1()),
                new InstrumentString(tuning.getString2()),
                new InstrumentString(tuning.getString3()),
                new InstrumentString(tuning.getString4()),
                new InstrumentString(tuning.getString5()),
                new InstrumentString(tuning.getString6())
        };
    }

    public InstrumentString getStringByName(StringNames sn) {
        return strings[sn.ordinal()];
    }

    public InstrumentString getStringByPosition(int pos) {
        return strings[pos];
    }

    private Tuning tuning;
    private InstrumentString[] strings;
}
