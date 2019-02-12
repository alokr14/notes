package com.example.android.notes.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.notes.R;
import com.example.android.notes.beans.Post;

import java.util.List;



public class PostAdapter extends RecyclerView.Adapter<PostAdapter.CustomViewHolder> {
    private List<Post> posts;

    public PostAdapter(List<Post> post) {
        this.posts = post;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.id.setText(post.getId());
        holder.name.setText(post.getName());
        holder.size.setText(post.getSize());
        holder.created_at.setText(post.getCreated_at());
        holder.updated_at.setText(post.getUpdated_at());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView id, name, size,created_at,updated_at;

        public CustomViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.fileId);
            name = (TextView) view.findViewById(R.id.fileName);
            size = (TextView) view.findViewById(R.id.fileSize);
            created_at = (TextView) view.findViewById(R.id.created_at);
            updated_at = (TextView) view.findViewById(R.id.updated_at);
        }
    }
}
