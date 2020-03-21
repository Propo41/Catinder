package com.example.catinder.UIElements;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.catinder.Util.CatProfile;
import com.example.catinder.R;
import com.example.catinder.Util.FragmentAllListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;




public class FragmentAll extends Fragment {

    private int[] IMAGES = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g};
    private String[] NAMES = {"Evee", "Jirachi", "Umbreon", "Butterfree", "Luna", "Flareon", "Pikachu"};
    private String[] GENDER = {"Female", "Female", "Male", "Female", "Female", "Female", "Male"};
    private String[] AGE = {"6 months", "1 years", "2 years", "5 months", "8 years", "6 months", "5 years"};
    private ArrayList<CatProfile> loved;
    private FragmentAllListener listener;

    public FragmentAll(ArrayList<CatProfile> loved){
        this.loved = loved;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof  FragmentAllListener){
            listener = (FragmentAllListener) context;
        }else{
            throw new RuntimeException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all, container, false);
        ListView listView = view.findViewById(R.id.list_view);
        CustomAdapter customAdapter = new CustomAdapter(loved, listener, getActivity(), NAMES, GENDER, AGE, IMAGES);
        listView.setAdapter(customAdapter);

       // called only once. Control is given to customAdapter object.

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener  = null;
    }
}


class CustomAdapter extends BaseAdapter {

    private String[] NAMES;
    private String[] GENDER;
    private String[] AGE;
    private int[] IMAGES;

    private static LayoutInflater inflater = null;
    private Context context;
    private ArrayList<CatProfile> loved;

    private FragmentAllListener listener;



    CustomAdapter(ArrayList<CatProfile> loved, FragmentAllListener listener, FragmentActivity activity, String[] NAMES, String[] GENDER, String[] AGE, int[] IMAGES) {
        this.GENDER = GENDER;
        this.NAMES = NAMES;
        this.AGE = AGE;
        this.IMAGES = IMAGES;
        context = activity;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listener = listener;
        this.loved = loved;

    }


    public ArrayList<CatProfile> getLoved(){
        return loved;
    }
    @Override
    public int getCount() {
        return IMAGES.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class Holder {
        TextView name;
        TextView age;
        TextView gender;
        ImageView img;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //the goal is to recycle the already existing view in that list, not to init it
        // each time you display it when scrolling the list for example.
        // hence, if the condition is not given, it throws a warning message

        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.custom_list_view, null);

        holder.name = rowView.findViewById(R.id.name);
        holder.age = rowView.findViewById(R.id.age);
        holder.gender = rowView.findViewById(R.id.gender);
        holder.img = rowView.findViewById(R.id.dp);

        holder.name.setText(NAMES[position]);
        holder.age.setText(AGE[position]);
        holder.gender.setText(GENDER[position]);
        holder.img.setImageResource(IMAGES[position]);

        FloatingActionButton buttonView = rowView.findViewById(R.id.love);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, NAMES[position] + " will be notified of your love", Toast.LENGTH_SHORT).show();
                loved.add(new CatProfile(NAMES[position], AGE[position], GENDER[position], IMAGES[position]));

                listener.onCommunicate(loved);

            }
        });

        /*rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Toast.makeText(context, "You Clicked " + NAMES[position], Toast.LENGTH_LONG).show();
            }
        });*/

        return rowView;

    }




}


