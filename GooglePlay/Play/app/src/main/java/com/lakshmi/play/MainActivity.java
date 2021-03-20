package com.lakshmi.play;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class MainActivity extends AppCompatActivity {
    ImageButton like, notlike,dislike,notdislike;
    ImageButton play,pause,play_main,pause_main;
    private SlidingUpPanelLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initviews();
    }

    private void Initviews() {
        like = (ImageButton) findViewById(R.id.imageButton2);
        notlike = (ImageButton) findViewById(R.id.imageButton2new);
        dislike = (ImageButton) findViewById(R.id.button);
        notdislike = (ImageButton) findViewById(R.id.buttontwo);
        play = (ImageButton) findViewById(R.id.play_button);
        pause = (ImageButton) findViewById(R.id.pause_button);
        play_main = (ImageButton) findViewById(R.id.play_button_main);
        pause_main = (ImageButton) findViewById(R.id.pause_button_main);


        mLayout = findViewById(R.id.Slide);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notlike.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "You Like the Song", Toast.LENGTH_SHORT).show();
                if (notdislike.getVisibility() == View.VISIBLE) {
                    notdislike.setVisibility(View.GONE);
                }
            }
        });

        notlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notlike.setVisibility(View.GONE);
            }
        });

        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notdislike.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "You DisLike the Song", Toast.LENGTH_SHORT).show();
                if (notlike.getVisibility() == View.VISIBLE) {
                    notlike.setVisibility(View.GONE);
                }
            }
        });

        notdislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notdislike.setVisibility(View.GONE);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play.setVisibility(View.GONE);
                pause.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Song Is now Playing", Toast.LENGTH_SHORT).show();
                if (play_main.getVisibility() == View.VISIBLE) {
                    play_main.setVisibility(View.GONE);
                    pause_main.setVisibility(View.VISIBLE);
                }

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause.setVisibility(View.GONE);
                play.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Song is Pause", Toast.LENGTH_SHORT).show();
                if (pause_main.getVisibility() == View.VISIBLE) {
                    pause_main.setVisibility(View.GONE);
                    play_main.setVisibility(View.VISIBLE);
                }
            }
        });

        play_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play_main.setVisibility(View.GONE);
                pause_main.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Song Is now Playing", Toast.LENGTH_SHORT).show();
                if (play.getVisibility() == View.VISIBLE) {
                    play.setVisibility(View.GONE);
                    pause.setVisibility(View.VISIBLE);
                }
            }
        });

        pause_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause_main.setVisibility(View.GONE);
                play_main.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Song is Pause", Toast.LENGTH_SHORT).show();
                if (pause.getVisibility() == View.VISIBLE) {
                    pause.setVisibility(View.GONE);
                    play.setVisibility(View.VISIBLE);
                }
            }
        });
    }






    @Override
    public void onBackPressed() {
        if (mLayout != null &&
                (mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED || mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.ANCHORED)) {
            mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }

}
