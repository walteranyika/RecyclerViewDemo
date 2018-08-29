package com.walter.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<User> userList;
private RecyclerView recyclerView;
private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.list_users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userList=new ArrayList<>();

        adapter=new CustomAdapter(userList,this);

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(User user) {
                Toast.makeText(MainActivity.this, ""+user.getNames(), Toast.LENGTH_SHORT).show();
            }
        });
        //Fetch from remote URL

        userList.add(new User("John Mark","john@yahoo.com"));
        userList.add(new User("Mary Jane","mary@yahoo.com"));
        userList.add(new User("Miry Mwikali","miry@yahoo.com"));
        userList.add(new User("Tom Juma","tom@yahoo.com"));
        userList.add(new User("Abu Hamud","abu@yahoo.com"));
        userList.add(new User("Lee Yong","lee@yahoo.com"));
        userList.add(new User("Yamoto Terahashi","yamoto@yahoo.com"));

        adapter.notifyDataSetChanged();
    }
}
