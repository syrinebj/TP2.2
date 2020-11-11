package com.example.travail_a_fairetp22;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.assist.AssistStructure;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private AssistStructure.ViewNode textView;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);

        // Initialize all the view variables.
         View editText = findViewById(R.id.editTextTextPersonName);


        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible) {
                mShowCount.setText(savedInstanceState
                        .getString("count"));
                mShowCount.setVisibility(View.VISIBLE);

            }
        }
        Log.d(TAG,"R1:Le compteur est réinitialisé à 0, mais le contenu de l'EditText est préservé.");
        Log.d(TAG,"R2: Android arrête votre activité en appelant onPause(), onStop() et onDestroy(), puis redémarre l'opération en appelant onCreate(), onStart() et onResume().");
        Log.d(TAG,"R3: onSaveInstanceState() est appelée avant la méthode onStop()");
        Log.d(TAG,"R4:onPause() ou onStop()");
        
    }
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));

        }
    }



    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // If the heading is visible, message needs to be saved.
        // Otherwise we're still using default layout.
        if (mShowCount.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("count",
                    mShowCount.getText().toString());

        }
    }
}