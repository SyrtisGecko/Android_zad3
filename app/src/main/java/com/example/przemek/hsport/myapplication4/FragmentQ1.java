package com.example.przemek.hsport.myapplication4;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentQ1 extends Fragment implements Button.OnClickListener {




    public interface OnQ1AnsweredListener {
        public void onWyborOpcjiQ1(int opcja);
    }

    Activity Q;
    OnQ1AnsweredListener q1Listener;

    boolean ansQ1;

    public FragmentQ1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_q1, container, false);
    }

    public void onAttach(Context c) {
        super.onAttach(c);
        System.out.println("------------------------------------------Jestesmy w onAttach Q1---------------------");
        try {
            Q = (Activity) c;
            System.out.println("A0: " + Q.toString());
            q1Listener = (OnQ1AnsweredListener) c;
            System.out.println("sluchaczQ1: " + q1Listener.toString());
        } catch (ClassCastException e) {
            throw new ClassCastException(Q.toString() + " musi implementowac OnWyborOpcjiFragmentBListener");
        }

    }

//    public void onClickT(View v) {
//        Button button = (Button) v;
//        System.out.println("--------- Clicked on button: " + button.getText());
//
//            q1Listener.onWyborOpcjiQ1(1);
//
//    }
//
//    public void onClickF(View v) {
//        Button button = (Button) v;
//        System.out.println("--------- Clicked on button: " + button.getText());
//
//            q1Listener.onWyborOpcjiQ1(2);
//
//    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String ans = (String) button.getText();
        System.out.println("--------- Clicked on button: " + ans);
        if(ans.equals("True")) {
            q1Listener.onWyborOpcjiQ1(1);
        } else if(ans.equals("False")) {
            q1Listener.onWyborOpcjiQ1(2);
        } else {
            System.out.println("--------------- Unrecognized answer on Q1 ---------------");
        }

    }

    public void onActivityCreated(Bundle savedInstance) {
        super.onActivityCreated(savedInstance);
        getActivity().findViewById(R.id.trueButton).setOnClickListener(this);
        getActivity().findViewById(R.id.falseButton).setOnClickListener(this);
    }

}
