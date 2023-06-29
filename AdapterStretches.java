package com.example.workoutapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterStretches extends RecyclerView.Adapter<AdapterStretches.ViewHolder>  {



    List<String> titles;
    List<Integer> images;
    LayoutInflater inflater;

    public AdapterStretches(Context c, List<String> titles, List<Integer> images) {
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_adapter_stretches, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.gridIcon.setImageResource(images.get(position));

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                titles.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                if(titles.isEmpty()){
                    Toast.makeText(v.getContext(),"You completed your Stretches!",Toast.LENGTH_LONG).show();
                    Toast.makeText(v.getContext(),"You are ready to workout!",Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView gridIcon;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            Log.d("Stretches ADAPTER"," ENTERING !!");

            title = itemView.findViewById(R.id.textView2);
            gridIcon = itemView.findViewById(R.id.imageView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Stretches Adapter"," ENTERING !!");
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DisplayStretches.class);
                    intent.putExtra("Testing", title.getText());
                    context.startActivity(intent);

                    Toast.makeText(v.getContext(), "Clicked " + title.getText(), Toast.LENGTH_SHORT).show();
                    Log.d("Stretches Adapter"," FINISHED !!");

                }

            });

            Log.d("Stretches ADAPTER"," finish !!");

        }


    }


}