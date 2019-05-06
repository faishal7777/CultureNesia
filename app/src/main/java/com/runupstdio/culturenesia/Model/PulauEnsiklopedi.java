package com.runupstdio.culturenesia.Model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class PulauEnsiklopedi extends ExpandableGroup<ProvinsiEnsiklopedi> {
    public PulauEnsiklopedi(String title, List<ProvinsiEnsiklopedi> items) {
        super(title, items);
    }
}
