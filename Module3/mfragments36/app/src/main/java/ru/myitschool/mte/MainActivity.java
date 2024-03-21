package ru.myitschool.mte;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import ru.myitschool.mte.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    private Boolean isRunning = false;
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (isRunning) {
                handler.postDelayed(this, 3000);
                toggleFragments();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ru.myitschool.mte.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handler = new Handler(Looper.getMainLooper());

        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.output_fragment, new FirstFragment())
                    .commit();

        Button btnStart = binding.content.startBtn;
        Button btnStop = binding.content.stopBtn;

        btnStart.setOnClickListener(view -> {
            if (!isRunning) {
                isRunning = true;
                handler.post(runnable);
            }
        });

        btnStop.setOnClickListener(view -> {
            isRunning = false;
            handler.removeCallbacks(runnable);
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    private void toggleFragments() {
        Fragment fragment = (getSupportFragmentManager().findFragmentById(R.id.output_fragment) instanceof FirstFragment) ? new ProceedingFragment() : new FirstFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.output_fragment, fragment)
                .commit();
    }
}
