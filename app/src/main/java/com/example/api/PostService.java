package com.example.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PostService {
    @GET("/posts")
    Call <List<Post>> getPost(); //pido todos los post

    //@GET("/posts")
   // Call <Post>getPostById(@Query("id")int id); //como es uno solo no armar una lista LIST

    //@GET("/posts")
   // Call <Post>getPostById(@Path("id") int id); //como es uno solo no armar una lista LIST, sin usar Query
}
