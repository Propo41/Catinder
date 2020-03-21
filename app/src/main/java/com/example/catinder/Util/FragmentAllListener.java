package com.example.catinder.Util;

import com.example.catinder.Util.CatProfile;

import java.util.ArrayList;

// it's used to communicate between the fragments or between fragment and activity
public interface FragmentAllListener{
    void onCommunicate(ArrayList<CatProfile> loved);
}

