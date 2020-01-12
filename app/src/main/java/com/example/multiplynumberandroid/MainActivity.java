package com.example.multiplynumberandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.res.Resources;


import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView main;
    private TextView button01;
    private TextView button02;
    private TextView button03;
    private TextView button04;

    private int n1;
    private int n2;

    private Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        nextView();
    }

    private void init(){
        main = findViewById(R.id.main_text);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);
        button03 = findViewById(R.id.button03);
        button04 = findViewById(R.id.button04);

        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);
        button04.setOnClickListener(this);

        random = new Random();
    }

    private void nextView(){
        n1 = random.nextInt(10);
        n2 = random.nextInt(10);



        Resources resource = getResources();
        button01.setBackgroundColor(resource.getColor(R.color.purple));
        button02.setBackgroundColor(resource.getColor(R.color.orange));
        button03.setBackgroundColor(resource.getColor(R.color.yellow));
        button04.setBackgroundColor(resource.getColor(R.color.green));

        TextView[] buttons = {button01 , button02, button03, button04};
        shuffleArray(buttons);

        main.setText(String.format("%s * %s = ?" , n1 , n2));
        buttons[0].setText(String.valueOf(n1 * n2));
        buttons[1].setText(String.valueOf(random.nextInt(100)));
        buttons[2].setText(String.valueOf(random.nextInt(100)));
        buttons[3].setText(String.valueOf(random.nextInt(100)));
    }

    static void shuffleArray(View[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            View a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    @Override
    public void onClick(View v) {
        TextView button = (TextView) v;
        int number = Integer.parseInt(String.valueOf(button.getText()));
        if (number == (n1 * n2)) nextView();
        else button.setBackgroundColor(getResources().getColor(R.color.red));
    }
}
