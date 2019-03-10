package com.example.android.notes.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.notes.R;
import com.example.android.notes.beans.Post;

import java.util.List;



public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.CustomViewHolder> {
    private List<Post> posts;

    public PostsAdapter(List<Post> posts) {
        this.posts = posts;
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
        holder.employeeName.setText(post.getName());
        holder.email.setText(post.getEmail());
        holder.designation.setText(post.getDesignation());
        holder.dob.setText(post.getDob());
        holder.contactNumber.setText(post.getContactNumber());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView employeeName, designation, email, salary, dob,contactNumber;

        public CustomViewHolder(View view) {
            super(view);
            employeeName = (TextView) view.findViewById(R.id.fileName);
            email = (TextView) view.findViewById(R.id.fileId);
            designation = (TextView) view.findViewById(R.id.created_at);
            dob = (TextView) view.findViewById(R.id.fileSize);
            contactNumber = (TextView) view.findViewById(R.id.updated_at);
        }
    }
}
