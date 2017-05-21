package com.example.przemek.hsport.myapplication4;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityBPart extends Activity implements FragmentA0.OnWyborOpcjiFragmentBListener {
    FragmentA1 a1;
    FragmentA2 a2;
    FragmentA3 a3;
    FragmentTransaction transakcja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpart);

        a1 = new FragmentA1();
        a2 = new FragmentA2();
        a3 = new FragmentA3();
        transakcja = getFragmentManager().beginTransaction();
        transakcja.add(R.id.frameForFragmentsA, a1);
        transakcja.detach(a1);
        transakcja.add(R.id.frameForFragmentsA, a2);
        transakcja.detach(a2);
        transakcja.add(R.id.frameForFragmentsA, a3);
        transakcja.detach(a3);
        transakcja.commit();
    }

    @Override
    public void onWyborOpcji(int opcja) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        System.out.println("------------------------------ onWyborOpcji w mainActv --------------------");
        switch (opcja) {
            case 2:
                System.out.println("Zmieniam Fragment na a2 w mainActv");
                transaction.detach(a1);
                transaction.detach(a3);
                transaction.attach(a2);
                transaction.commit();
                break;
            case 1:
                System.out.println("Zmieniam Fragment na a1 w mainActv");
                transaction.detach(a2);
                transaction.detach(a3);
                transaction.attach(a1);
                transaction.commit();
                break;
            case 3:
                System.out.println("Zmieniam Fragment na a3 w mainActv");
                transaction.detach(a2);
                transaction.detach(a1);
                transaction.attach(a3);
                transaction.commit();
                break;
        }
    }
}
