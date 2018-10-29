package com.example.kuanglin.podcastplayer.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kuanglin.podcastplayer.R;
import com.example.kuanglin.podcastplayer.data.PodcastItem;

import java.util.ArrayList;

public class PodcastListAdapter extends RecyclerView.Adapter<PodcastListAdapter.PodcastViewHolder> {
    private Context mContext;
    private ArrayList<PodcastItem> podcastList;
    private final OnItemClickListener clickListener;

    public interface OnItemClickListener {
        void onClick(String path);
    }

    public PodcastListAdapter(Context context, ArrayList<PodcastItem> songArrayList, OnItemClickListener clickListener) {
        this.mContext = context;
        this.podcastList = songArrayList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public PodcastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new PodcastViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull PodcastViewHolder holder, int position) {
        final PodcastItem item = podcastList.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(item.getFileName());
            }
        });
        holder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return podcastList.size();
    }

    class PodcastViewHolder extends RecyclerView.ViewHolder {


        public TextView title;

        public PodcastViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}
