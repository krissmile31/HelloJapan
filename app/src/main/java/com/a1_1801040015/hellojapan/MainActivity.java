package com.a1_1801040015.hellojapan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import www.sanju.motiontoast.MotionToast;

public class MainActivity<i> extends AppCompatActivity {

    GridView gridView;
    Button HiraBtn, KataBtn;
    TextView Hira, Kata;
    Drawable default_background;
    HiraAdapter hiraAdapter;
    KataAdapter kataAdapter;
    Animation anim, zoomout;

    public int[] hiragana = {R.drawable.b11h, R.drawable.b12h, R.drawable.b13h, R.drawable.b14h, R.drawable.b15h, R.drawable.b21h, R.drawable.b22h, R.drawable.b23h, R.drawable.b24h, R.drawable.b25h, R.drawable.b31h, R.drawable.b32h, R.drawable.b33h, R.drawable.b34h, R.drawable.b35h, R.drawable.b41h, R.drawable.b42h, R.drawable.b43h, R.drawable.b44h, R.drawable.b45h, R.drawable.b51h, R.drawable.b52h, R.drawable.b53h, R.drawable.b54h, R.drawable.b55h, R.drawable.b61h, R.drawable.b62h, R.drawable.b63h, R.drawable.b64h, R.drawable.b65h, R.drawable.b71h, R.drawable.b72h, R.drawable.b73h, R.drawable.b74h, R.drawable.b75h, R.drawable.b81h, R.drawable.empty, R.drawable.b83h, R.drawable.empty, R.drawable.b85h, R.drawable.b91h, R.drawable.b92h, R.drawable.b93h, R.drawable.b94h, R.drawable.b95h, R.drawable.b101h, R.drawable.empty, R.drawable.empty, R.drawable.empty, R.drawable.b105h, R.drawable.b111h, R.drawable.empty, R.drawable.empty, R.drawable.empty, R.drawable.empty};
    public int[] katakana = {R.drawable.b11k, R.drawable.b12k, R.drawable.b13k, R.drawable.b14k, R.drawable.b15k, R.drawable.b21k, R.drawable.b22k, R.drawable.b23k, R.drawable.b24k, R.drawable.b25k, R.drawable.b31k, R.drawable.b32k, R.drawable.b33k, R.drawable.b34k, R.drawable.b35k, R.drawable.b41k, R.drawable.b42k, R.drawable.b43k, R.drawable.b44k, R.drawable.b45k, R.drawable.b51k, R.drawable.b52k, R.drawable.b53k, R.drawable.b54k, R.drawable.b55k, R.drawable.b61k, R.drawable.b62k, R.drawable.b63k, R.drawable.b64k, R.drawable.b65k, R.drawable.b71k, R.drawable.b72k, R.drawable.b73k, R.drawable.b74k, R.drawable.b75k, R.drawable.b81k, R.drawable.empty, R.drawable.b83k, R.drawable.empty, R.drawable.b85k, R.drawable.b91k, R.drawable.b92k, R.drawable.b93k, R.drawable.b94k, R.drawable.b95k, R.drawable.b101k, R.drawable.empty, R.drawable.empty, R.drawable.empty, R.drawable.b105k, R.drawable.b111k, R.drawable.empty, R.drawable.empty, R.drawable.empty, R.drawable.empty};

    public int[] audio = {R.raw.a, R.raw.i, R.raw.u, R.raw.e, R.raw.o, R.raw.ka, R.raw.ki, R.raw.ku, R.raw.ke, R.raw.ko, R.raw.sa, R.raw.shi, R.raw.su, R.raw.se, R.raw.so, R.raw.ta, R.raw.chi, R.raw.tsu, R.raw.te, R.raw.to, R.raw.na, R.raw.ni, R.raw.nu, R.raw.ne, R.raw.no, R.raw.ha, R.raw.hi, R.raw.fu, R.raw.he, R.raw.ho, R.raw.ma, R.raw.mi, R.raw.mu, R.raw.me, R.raw.mo, R.raw.ya, 0, R.raw.yu, 0, R.raw.yo, R.raw.ra, R.raw.ri, R.raw.ru, R.raw.re, R.raw.ro, R.raw.wa, -1, -1, -1, R.raw.wo, R.raw.n};

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        Hira = findViewById(R.id.Hira);
        Kata = findViewById(R.id.Kata);
        HiraBtn = findViewById(R.id.HiraBtn);
        KataBtn = findViewById(R.id.KataBtn);
        default_background = KataBtn.getBackground();

        hiraAdapter = new HiraAdapter(this);
        kataAdapter = new KataAdapter(this);

        gridView.setAdapter(hiraAdapter);// default
        HiraBtn.setBackgroundResource(R.color.purple_200);
        KataBtn.setBackground(default_background);

        anim = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
        HiraBtn.startAnimation(anim);
        zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomout);
        KataBtn.startAnimation(zoomout);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, audio[position]);
                mediaPlayer.start();

            }
        });
    }

    @SuppressLint("ResourceAsColor")
    public void onClick(View view) {
        if (view == HiraBtn) {
            HiraBtn.startAnimation(anim);
            KataBtn.startAnimation(zoomout);

            HiraBtn.setBackgroundResource(R.color.purple_200);
            KataBtn.setBackground(default_background);

            MotionToast.Companion.createToast(MainActivity.this,
                    "Hiragana Alphabet!!!",
                    MotionToast.Companion.getTOAST_SUCCESS(),
                    MotionToast.Companion.getGRAVITY_CENTER(),
                    MotionToast.Companion.getLONG_DURATION(),
                    ResourcesCompat.getFont(MainActivity.this,R.font.helvetica_regular));

            MediaPlayer hiraPlayer = MediaPlayer.create(MainActivity.this, R.raw.hiragana);
            hiraPlayer.start();

            Hira.animate().translationYBy(-25).setDuration(5000).withEndAction(new Runnable() {
                @Override
                public void run() {
                    Hira.animate().rotationYBy(180*2).setDuration(10);
                    Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
                    animation.setDuration(3000);
                    Hira.startAnimation(animation);
                    Hira.animate().translationYBy(25).setDuration(5000);
                }
            });

            Hira.animate().alpha(1f).setDuration(100);
            Kata.animate().alpha(0f).setDuration(100);
            gridView.setAdapter(hiraAdapter);
        }

        else  if (view == KataBtn) {
            KataBtn.startAnimation(anim);
            HiraBtn.startAnimation(zoomout);

            KataBtn.setBackgroundResource(R.color.purple_200);
            HiraBtn.setBackground(default_background);

            MotionToast.Companion.createToast(MainActivity.this,
                    "Katakana Alphabet!!!",
                    MotionToast.Companion.getTOAST_SUCCESS(),
                    MotionToast.Companion.getGRAVITY_CENTER(),
                    MotionToast.Companion.getLONG_DURATION(),
                    ResourcesCompat.getFont(MainActivity.this,R.font.helvetica_regular));

            MediaPlayer kataPlayer = MediaPlayer.create(MainActivity.this, R.raw.katakana);
            kataPlayer.start();

            Kata.animate().translationYBy(-25).setDuration(5000).withEndAction(new Runnable() {
                @Override
                public void run() {
                    Kata.animate().rotationYBy(180*2).setDuration(10);
                    Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
                    animation.setDuration(3000);
                    Kata.startAnimation(animation);
                    Kata.animate().translationYBy(25).setDuration(5000);
                }
            });

            gridView.setAdapter(kataAdapter);
            Hira.animate().alpha(0f).setDuration(100);
            Kata.animate().alpha(1f).setDuration(100);
        }
    }

    private class HiraAdapter extends BaseAdapter {
        private Context context;

        public HiraAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return hiragana.length;
        }

        @Override
        public Object getItem(int position) {
            return hiragana[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(hiragana[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            return imageView;
        }
    }

    private class KataAdapter extends BaseAdapter {
        private Context context;

        public KataAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return katakana.length;
        }

        @Override
        public Object getItem(int position) {
            return katakana[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(katakana[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            return imageView;
        }
    }

}