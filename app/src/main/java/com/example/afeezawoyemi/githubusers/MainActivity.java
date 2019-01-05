package com.example.afeezawoyemi.githubusers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RecyclerView users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = findViewById(R.id.rv_users);
    }

    public void launchDetailActivity(View view) {
        Log.d("QWER", "HELLO HERE");
        Intent showDetailActivity = new Intent(this, DetailActivity.class);
        Log.d("QWER", "HELLO HERE");
        startActivity(showDetailActivity);
        Log.d("QWER", "HELLO HERE");
    }
}
