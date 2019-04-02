package com.vogella.projetfinal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vogella.projetfinal.model.Pokemon;

import java.util.List;


public class MyAdapterPokemon extends RecyclerView.Adapter<MyAdapterPokemon.ViewHolder> {
    private List<Pokemon> values;
    private OnItemClickListener listener;



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public ImageView img;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            img = v.findViewById(R.id.icon);
        }
    }


    public MyAdapterPokemon(List<Pokemon> values) {
        this.values = values;
    }
    @Override
    public MyAdapterPokemon.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final Pokemon pokemon = values.get(position);
        holder.txtHeader.setText(pokemon.getName());
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("nom", values.get(position).getName());
                intent.putExtra("URL", values.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        }

    @Override
    public int getItemCount() {
        return values.size();
    }

}