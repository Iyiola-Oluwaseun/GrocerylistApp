package com.example.myfirstapp;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {
    private Context  context;
    private String[] cost;
    private String[] name;
    private String[] description;
    private int[] image;


    MyAdapter(Context context, int[] image, String[] description, String[] cost, String[] name){
        this.context = context;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.image = image;

    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main, parent,false);
        return new ItemViewHolder(view);
    }



    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.name.setText(name[position]);
        holder.description.setText(description[position]);
        holder.pizza.setImageResource(image[position]);
        holder.Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Your list are:" + name[holder.getAdapterPosition()]  + cost[holder.getAdapterPosition()] + description[holder.getAdapterPosition()]);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent,"send to"));

            }

        });

    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView pizza;
        TextView name;
        TextView description;
        Button Share;

        ItemViewHolder(View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.name);
            pizza = itemView.findViewById(R.id.image);
            description = itemView.findViewById(R.id.description);
            Share = itemView.findViewById(R.id.btnshare);
        }
    }
}




