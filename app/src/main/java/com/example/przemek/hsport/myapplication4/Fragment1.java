package com.example.przemek.hsport.myapplication4;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;



/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements RadioGroup.OnCheckedChangeListener {

    public interface OnWyborOpcjiListener {
        public void onWyborOpcji(int opcja);
    }

    Activity A1;
    OnWyborOpcjiListener sluchaczF1;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    public void onAttach(Context c) {
        super.onAttach(c);
        System.out.println("------------------------------------------Jestesmy w onAttach---------------------");
        try {
            A1 = (Activity) c;
            System.out.println("A1: " + A1.toString());
            sluchaczF1 = (OnWyborOpcjiListener) c;
            System.out.println("sluchaczF1: " + sluchaczF1.toString());
        } catch (ClassCastException e) {
            throw new ClassCastException(A1.toString() + " musi implementowac OnWyborOpcjiListener");
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch(checkedId) {
            case R.id.ropt1:
                System.out.println("Wybrano radio 1");
                sluchaczF1.onWyborOpcji(1);
                break;
            case R.id.ropt2:
                System.out.println("Wybrano radio 2");
                sluchaczF1.onWyborOpcji(2);
                break;
        }
    }

    public void onActivityCreated(Bundle savedInstance) {
        super.onActivityCreated(savedInstance);
        ((RadioGroup) getActivity().findViewById(R.id.radioGroup)).setOnCheckedChangeListener(this);
    }
}
