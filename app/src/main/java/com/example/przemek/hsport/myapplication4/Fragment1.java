package com.example.przemek.hsport.myapplication4;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements OnWyborOpcjiListener, RadioGroup.OnCheckedChangeListener {
    AppCompatActivity A1;
    OnWyborOpcjiListener sluchaczF1;

    Bundle savedInstance;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        savedInstance = savedInstanceState;
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    public void onAttach(Context c) {
        super.onAttach(c);

        try {
            A1 = (AppCompatActivity) c;
            sluchaczF1 = (OnWyborOpcjiListener) c;
        } catch (ClassCastException e) {
            throw new ClassCastException(A1.toString() + " musi implementowac OnWyborOpcjiListener");
        }

    }



    @Override
    public void onWyborOpcji(int opcja) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch(checkedId) {
            case R.id.ropt1:
                sluchaczF1.onWyborOpcji(1);
                break;
            case R.id.ropt2:
                sluchaczF1.onWyborOpcji(2);
                break;
        }
    }

    public void onActivityCreated() {
        super.onActivityCreated(savedInstance);
        ((RadioGroup) getActivity().findViewById(R.id.radioGroup)).setOnCheckedChangeListener(this);
    }
}
