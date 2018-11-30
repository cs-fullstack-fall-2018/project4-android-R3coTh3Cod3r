package com.example.student.andriod_project_4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private static final String TAG = "RecyclerAdapter";

    private ArrayList<String>mimageNames = new ArrayList<>();
    private ArrayList<String>mImages = new ArrayList<>();
    private Context mContext;

    public RecyclerAdapter(Context context, ArrayList<String>imageNames, ArrayList<String>images){
        mimageNames = imageNames;
        mImages = images;
        mContext = context;


    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main,parent, false);
        ViewHolder holder = new ViewHolder(view);




        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called,");
        Log.d("RecoLog", mImages.toString());
        Log.d("RecoLog", Integer.toString(position));
        Log.d("RecoLog", "I think this will show");
        Log.d("RecoLog", holder.image.toString());
        Log.d("RecoLog", "If this doesn't show it's the line above me");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.imageName.setText(mimageNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: click on:"+ mimageNames.get(position));


                Toast.makeText(mContext, mimageNames.get(position), Toast.LENGTH_SHORT).show();

            }
        });


        }


    @Override

    public int getItemCount() {
        return mimageNames.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout= itemView.findViewById(R.id.parent_layout);
        }


    }
    }


