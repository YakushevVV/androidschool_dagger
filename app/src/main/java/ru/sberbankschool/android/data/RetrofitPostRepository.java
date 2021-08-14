package ru.sberbankschool.android.data;

import androidx.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import ru.sberbankschool.android.domain.PostRepository;
import ru.sberbankschool.android.domain.model.Post;

@Singleton
public class RetrofitPostRepository implements PostRepository {

    @NonNull
    private final JsonPlaceholderApi mPlaceholderApi;

    @Inject
    public RetrofitPostRepository(@NonNull JsonPlaceholderApi placeholderApi) {
        mPlaceholderApi = placeholderApi;
    }

    @NonNull
    @Override
    public Single<Post> postsAdd(Post post) {
        return mPlaceholderApi.addPost(post);
    }

    @NonNull
    @Override
    public Single<List<Post>> postsList() {
        return mPlaceholderApi.listPosts();
    }
}
