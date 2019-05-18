package com.runupstdio.culturenesia.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ProvinsiEnsiklopedi implements Parcelable {

    public final String name;

    public String getName() {
        return name;
    }

    public ProvinsiEnsiklopedi(String name) {
        this.name = name;
    }

    protected ProvinsiEnsiklopedi(Parcel in) {
        name = in.readString();
    }

    public static final Creator<ProvinsiEnsiklopedi> CREATOR = new Creator<ProvinsiEnsiklopedi>() {
        @Override
        public ProvinsiEnsiklopedi createFromParcel(Parcel in) {
            return new ProvinsiEnsiklopedi(in);
        }

        @Override
        public ProvinsiEnsiklopedi[] newArray(int size) {
            return new ProvinsiEnsiklopedi[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
