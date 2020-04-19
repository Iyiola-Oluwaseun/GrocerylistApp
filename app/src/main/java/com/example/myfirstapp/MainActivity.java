package com.example.myfirstapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewe;
    String[] name;
    String[] description;
    String[] cost;
    int[] image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerViewe = findViewById(R.id.recyclerViewe);

        image = new  int[]{R.drawable.pizza1,R.drawable.pizza2,R.drawable.pizza3,R.drawable.pizza4,R.drawable.pizza5,R.drawable.pizza6,R.drawable.pizza7,R.drawable.pizza8};


        name = new String[]{ "Pepperoni Pizza", "Multigrain  Pizza", "Chicken Pizza", "Margherita Pizza", "Vegetarian Pizz","Mini Mushroom Pizza","Wholegrain Pizza","Scone Pizz"};
        description = new String[]{"cheesy, spicy",
                "healthy makeover ",
                "cheese, chill",
                " fresh veggies ",
                " bread base",
                "box-cookings.",
                "high on flavo",
                " Mini pizzas",
        };
        cost = new String[]{"$500", "$400", "$600", "$800", "$1500","$900", "$100","$200"
        };


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerViewe.setLayoutManager(linearLayoutManager);

        MyAdapter myAdapter = new MyAdapter(MainActivity.this,image, name, cost, description);
        recyclerViewe.setAdapter(myAdapter);

    }




}





