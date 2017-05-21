package com.example.przemek.hsport.myapplication4;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ActivityMPart extends Activity implements FragmentQ1.OnQ1AnsweredListener {

    FragmentQ1 q1;
    FragmentAnswer answer;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpart);

        q1 = new FragmentQ1();
        answer = new FragmentAnswer();
        transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.frameForFragmentsQ, q1);
        transaction.add(R.id.frameForFragmentsQ, answer);
        transaction.detach(answer);
        transaction.commit();
    }

    public boolean onCreateOptionsMenu(Menu myMenu) {
        super.onCreateOptionsMenu(myMenu);

        return true;
    }

    @Override
    public void onWyborOpcjiQ1(int opcja) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        System.out.println("------------------------------ onWyborOpcjiQ1 w mainActv --------------------");
        switch (opcja) {
            case 2:
                System.out.println("Zmieniam Fragment na answer w mainActv");
                transaction.detach(q1);
                setQ1AnsTexts("False", "WRONG");
                transaction.attach(answer);
                transaction.commit();
                break;
            case 1:
                System.out.println("Zmieniam Fragment na answer w mainActv");
                transaction.detach(q1);
                setQ1AnsTexts("True", "CORRECT");
                transaction.attach(answer);
                transaction.commit();
                break;
        }
    }

    private void setQ1AnsTexts(String answ, String result) {
        TextView ta = (TextView) findViewById(R.id.q1AnswerText);
        ta.setText(answ);

        TextView tr = (TextView) findViewById(R.id.q1AnswerResult);
        tr.setText(result);
    }
}
