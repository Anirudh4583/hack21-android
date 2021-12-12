package com.bitaam.codeshop.adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bitaam.codeshop.CodeBlogActivity;
import com.bitaam.codeshop.R;
import com.bitaam.codeshop.modals.CodeItemModal;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class HomeCodeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    RecyclerView recyclerView;
    ArrayList<CodeItemModal> codeItemModals;
    String userRole="";
    Context context;


    public HomeCodeAdapter(RecyclerView recyclerView, Context context,ArrayList<CodeItemModal> codeItemModals) {
        this.recyclerView = recyclerView;
        this.codeItemModals = codeItemModals;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.code_home_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        ViewHolder viewHolder = (ViewHolder)holder;
        viewHolder.titleTv.setText(codeItemModals.get(position).getTitleText());
        String writer = "Author : "+codeItemModals.get(position).getAuthor();
        viewHolder.authorTv.setText(writer);
        String dateTime = "Posted :"+codeItemModals.get(position).getDate();
        viewHolder.dateTv.setText(dateTime);

        Picasso.get().load(Uri.parse(codeItemModals.get(position).getImgUrl())).into(viewHolder.codeItemImgView);


    }

    @Override
    public int getItemViewType(int position) {

        return 1;
    }

    @Override
    public int getItemCount() {
        return codeItemModals.size();
    }

    public void update(CodeItemModal codeItemModal,String role){

        codeItemModals.add(codeItemModal);
        userRole = role;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView authorTv,dateTv,titleTv;
        ImageView codeItemImgView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            authorTv = itemView.findViewById(R.id.codeAuthorTv);
            dateTv = itemView.findViewById(R.id.dateTimeTv);
            titleTv = itemView.findViewById(R.id.codeItemtitle);
            codeItemImgView = itemView.findViewById(R.id.codeItemImageView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = recyclerView.getChildLayoutPosition(view);
                    Intent intent = new Intent(context, CodeBlogActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("codeItemInfo", (Serializable) codeItemModals.get(position));
                    context.startActivity(intent);

                }
            });
        }


    }


}


