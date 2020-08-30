package com.example.androidpl_hw_8;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        startAsyncTask();
    }

    private void startAsyncTask() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                for (int i = 0; i < 30; i++) {
                    SystemClock.sleep(1000);
                }

                return null;
            }
        }.execute();
    }

    @OnClick({R.id.btn_arithm_exception})
    void getAritmException() {
        throw new ArithmeticException();
    }

    @OnClick({R.id.btn_array_exception})
    void getArrayException() {
        throw new ArrayIndexOutOfBoundsException();
    }

    @OnClick({R.id.btn_runtime_exception})
    void getRuntimeException() {
        throw new RuntimeException();
    }
}