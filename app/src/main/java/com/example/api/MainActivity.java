package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.api.R;
import com.example.api.Post;
import com.example.api.PostService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private List<Post> listaPost;
    private PostAdapter adapter;
    private ListView listViewPosts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPosts = findViewById(R.id.listViewPosts);

        listaPost = new ArrayList<Post>();
        getPosts();
        //cargaManual();

        PostAdapter adapter = new PostAdapter(listaPost);

        listViewPosts.setAdapter(adapter);
        //cargarLista();
    }


    private void cargaManual(){

        listaPost.add(new Post(0,1,"titulo","anabella"));
        listaPost.add(new Post(0,2,"titulo","anabella"));
        listaPost.add(new Post(0,3,"titulo","anabella"));
    }
    private void getPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService postService = retrofit.create(PostService.class);
        Call<List<Post>> call = postService.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                for(Post post :  response.body()) {
                    listaPost.add(post);
                    Log.e("TAG", "onResponse: "+post );
                }
              //  adapter.notifyDataSetChanged();
                Log.e("TAG", "onResponse: "+listaPost );
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("tag_error", "onFailure: "+t.getMessage());
            }
        });
    }

}
