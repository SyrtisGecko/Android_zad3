package com.example.przemek.hsport.myapplication4;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityAPart extends AppCompatActivity implements OnWyborOpcjiListener {
    Fragment11 f11;
    Fragment12 f12;
    FragmentTransaction transakcja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apart);

        f11 = new Fragment11();
        f12 = new Fragment12();
        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.frameForFragments, f11);
        transakcja.detach(f11);
        transakcja.add(R.id.frameForFragments, f12);
        transakcja.detach(f12);
        transakcja.commit();
    }

    @Override
    public void onWyborOpcji(int opcja) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (opcja) {
            case R.id.ropt2:
                transaction.detach(f11);
                transaction.attach(f12);
                break;
            case R.id.ropt1:
                transaction.detach(f12);
                transaction.attach(f11);
                break;
        }
        transaction.commit();
    }
}
