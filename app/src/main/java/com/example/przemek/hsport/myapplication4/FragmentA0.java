package com.example.przemek.hsport.myapplication4;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA0 extends Fragment implements RadioGroup.OnCheckedChangeListener {

    public interface OnWyborOpcjiFragmentBListener {
        public void onWyborOpcji(int opcja);
    }

    Activity A0;
    OnWyborOpcjiFragmentBListener sluchaczA0;

    public FragmentA0() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_a0, container, false);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch(checkedId) {
            case R.id.radioForA1:
                System.out.println("Wybrano radio 1");
                sluchaczA0.onWyborOpcji(1);
                break;
            case R.id.radioForA2:
                System.out.println("Wybrano radio 2");
                sluchaczA0.onWyborOpcji(2);
                break;
            case R.id.radioForA3:
                System.out.println("Wybrano radio 3");
                sluchaczA0.onWyborOpcji(3);
                break;
        }
    }
}
