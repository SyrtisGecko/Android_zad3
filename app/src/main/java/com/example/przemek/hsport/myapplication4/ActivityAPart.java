package com.example.przemek.hsport.myapplication4;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class ActivityAPart extends Activity implements Fragment1.OnWyborOpcjiListener {
    Fragment11 f11;
    Fragment12 f12;
    FragmentTransaction transakcja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apart);

        f11 = new Fragment11();
        f12 = new Fragment12();
        transakcja = getFragmentManager().beginTransaction();
        transakcja.add(R.id.frameForFragments, f11);
        transakcja.detach(f11);
        transakcja.add(R.id.frameForFragments, f12);
        transakcja.detach(f12);
        transakcja.commit();
    }

    @Override
    public void onWyborOpcji(int opcja) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        System.out.println("------------------------------ onWyborOpcji w mainActv --------------------");
        switch (opcja) {
            case 2:
                System.out.println("Zmieniam Fragment na f12 w mainActv");
                transaction.detach(f11);
                transaction.attach(f12);
                transaction.commit();
                break;
            case 1:
                System.out.println("Zmieniam Fragment na f11 w mainActv");
                transaction.detach(f12);
                transaction.attach(f11);
                transaction.commit();
                break;
        }
//        transaction.commit();
    }
}
