package com.example.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter {

    private List<Post> listaPost;


    public PostAdapter(List<Post>listaPost){
        this.listaPost = listaPost;

    }


    @Override
    public int getCount() {

        return this.listaPost.size();
    }

    @Override
    public Post getItem(int position) {


        return listaPost.get(position);
    }

    @Override
    public long getItemId(int position) {


        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout;

        if(convertView==null){
            layout= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_detalle_item,null);
        }else{
            layout=convertView;
        }

        Post item = getItem(position);

        TextView textViewTitulo = layout.findViewById(R.id.textViewTitulo);
        TextView textViewCuerpo = layout.findViewById(R.id.textViewCuerpo);

        textViewTitulo.setText(item.getTitle());

        textViewCuerpo.setText(item.getBody());


        return layout;
    }



}
