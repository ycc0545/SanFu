package com.example.dllo.sanfu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView viewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewById = (TextView) findViewById(R.id.tv1);
        viewById.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        viewById.setText("qqq");
        viewById.setTextColor(getColor(R.color.colorAccent));
    }
}
