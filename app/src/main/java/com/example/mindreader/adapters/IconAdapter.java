package com.example.mindreader.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindreader.R;

import java.util.Map;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    private final Map<Integer, Integer> iconModel;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView text;
        private final ImageView image;

        public ViewHolder(View view) {
            super(view);
            text = view.findViewById(R.id.number);
            image = view.findViewById(R.id.icon);
        }
    }

    public IconAdapter(Map<Integer, Integer> iconModel) {
        this.iconModel = iconModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.icon_temp, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(iconModel.get(position));
        holder.text.setText(String.format("%s",position));
    }

    @Override
    public int getItemCount() {
        return iconModel.size();
    }
}