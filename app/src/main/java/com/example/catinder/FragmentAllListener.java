package com.example.catinder;

import java.util.ArrayList;

// it's used to communicate between the fragments or between fragment and activity
public interface FragmentAllListener{
    void onCommunicate(ArrayList<CatProfile> loved);
}

