package com.example.rishabhgoyal.indiaguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * Created by Rishabh Goyal on 04-02-2017.
 */
public class PlacesFragment extends Fragment {

    public PlacesFragment() {
        /**Empty Constructor*/
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Detail> detail = new ArrayList<Detail>();
        detail.add(new Detail(R.string.place_one, R.string.place_review_one,R.drawable.shimla));
        detail.add(new Detail(R.string.place_two, R.string.place_review_two,R.drawable.kashmir));
        detail.add(new Detail(R.string.place_three, R.string.place_review_three,R.drawable.leh));
        detail.add(new Detail(R.string.place_four, R.string.place_review_four,R.drawable.banglore));
        detail.add(new Detail(R.string.place_five, R.string.place_review_five,R.drawable.mumbai));
        detail.add(new Detail(R.string.place_six, R.string.place_review_six,R.drawable.udaipur));
        detail.add(new Detail(R.string.place_seven, R.string.place_review_seven,R.drawable.goa));
        detail.add(new Detail(R.string.place_eight, R.string.place_review_eight,R.drawable.darjeeling));

        Adapter adapter = new Adapter(getActivity(), detail, R.color.category_colors);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}

