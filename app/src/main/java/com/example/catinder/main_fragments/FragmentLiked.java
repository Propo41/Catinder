package com.example.catinder.main_fragments;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.example.catinder.CatProfile;
import com.example.catinder.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragmentLiked extends Fragment {


    private ArrayList<CatProfile> loved;
    public FragmentLiked(ArrayList<CatProfile> loved) {
        this.loved = loved;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liked, container, false);
        if (loved.size()==0){
            init_default(view);
        }else {
            for (CatProfile i : loved) {
                init(view, i);
            }
        }

        return view;
    }

    private void init_default(View view) {
        Context context = getActivity();
        TableLayout tableLayout =  view.findViewById(R.id.table_main);

        TableRow table_row = new TableRow(getActivity());
        table_row.setPadding(0, 60, 0, 60);

        Typeface typeface = ResourcesCompat.getFont(context, R.font.montserrat);

        TextView alertText = new TextView(context);
        alertText.setTypeface(typeface);
        alertText.setText("Nothing here yet, Meow!");
        alertText.setTextSize(18);

        alertText.setTextColor(Color.rgb(33,168,255));
        alertText.setLayoutParams(setMargin(-1, -1, 30, 50,0));
        table_row.addView(alertText);

        tableLayout.addView(table_row);


    }

    public void init(View view, CatProfile catProfile) {


        Context context = getActivity();
        Typeface typeface = ResourcesCompat.getFont(context, R.font.montserrat);

        TableLayout tableLayout = view.findViewById(R.id.table_main);


        TableRow table_row = new TableRow(getActivity());
        table_row.setPadding(0, 60, 0, 0);

        ImageView imageView = new ImageView(getActivity());
        imageView.setImageResource(catProfile.getImage());
        imageView.setLayoutParams(setMargin(-1, -1, 0, 0,0));
        table_row.addView(imageView);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(setMargin(-1, -1, 30, 0,0));

        TextView nameView = new TextView(context);
        nameView.setTypeface(typeface);
        nameView.setText("Name : " + catProfile.getName());
        nameView.setTextColor(Color.rgb(33,168,255));
        nameView.setLayoutParams(setMargin(350, -1, 0, 60,0));
        linearLayout.addView(nameView);

        TextView genderView = new TextView(context);
        genderView.setTypeface(typeface);
        genderView.setText("Gender : " + catProfile.getGender());
        nameView.setTextColor(Color.rgb(33,168,255));
        genderView.setLayoutParams(setMargin(350, -1, 0, 0,0));
        genderView.setPadding(5, 5, 5, 5);
        linearLayout.addView(genderView);


        TextView ageView = new TextView(context);
        ageView.setTypeface(typeface);
        ageView.setText("Age : " + catProfile.getAge());
        nameView.setTextColor(Color.rgb(33,168,255));
        ageView.setLayoutParams(setMargin(350, -1, 0, 0,0));
        ageView.setPadding(5, 5, 5, 5);
        linearLayout.addView(ageView);


        table_row.addView(linearLayout);


        FloatingActionButton button = new FloatingActionButton(context);
        button.setImageResource(R.drawable.ic_heart);
        button.setRippleColor(Color.BLACK);
        button.setLayoutParams(setMargin(-1, -1, 60, 70,0));
        button.setClickable(true);
        button.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE ));
        table_row.addView(button);

        tableLayout.addView(table_row);







    }

    public TableRow.LayoutParams setMargin(int layoutWidth, int layoutHeight, int start, int top, int bottom) {

        if (layoutHeight == -1) {
            layoutHeight = TableRow.LayoutParams.WRAP_CONTENT;
        }
        if (layoutWidth == -1) {
            layoutWidth = TableRow.LayoutParams.WRAP_CONTENT;
        }
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(layoutWidth, layoutHeight);
        layoutParams.setMarginStart(start);
        layoutParams.setMargins(0, top, 0, bottom);
        return layoutParams;

    }




}
