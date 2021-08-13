package ru.sberbankschool.android.data;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import ru.sberbankschool.android.domain.model.Post;

public interface JsonPlaceholderApi {

    @GET("posts")
    Single<List<Post>> listPosts();

    @POST("posts")
    Single<Post> addPost(@Body Post item);
}
