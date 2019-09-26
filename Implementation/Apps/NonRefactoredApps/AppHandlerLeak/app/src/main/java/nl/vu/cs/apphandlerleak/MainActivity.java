package nl.vu.cs.apphandlerleak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;



public class MainActivity extends AppCompatActivity {

    final int rounds = 1000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.prepareForNextRun();

        this.startExerciser();
    }

    private void startExerciser() {
        // Just the following line of code must be changed so that it refers to another class (one class for each type of performance issue).
        Exerciser exerciser = new HandlerLeakExerciser();

        long startTimeStamp = System.currentTimeMillis();

        for(int i=0; i<this.rounds; i++) {
            exerciser.exercise();
        }

        long endTimestamp = System.currentTimeMillis();


        Log.i("experiment_nl_vu_cs_s2", "START: " + Long.toString(startTimeStamp));
        Log.i("experiment_nl_vu_cs_s2", "END: " + Long.toString(endTimestamp));
        Log.i("experiment_nl_vu_cs_s2", "DIFFERENCE: " + Long.toString(endTimestamp - startTimeStamp));
    }

    private void prepareForNextRun() {
        try {
            for (int i = 0; i < 5; i++) {
                System.gc();
                Thread.sleep(200);
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



