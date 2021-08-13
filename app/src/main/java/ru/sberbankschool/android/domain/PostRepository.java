package ru.sberbankschool.android.domain;

import androidx.annotation.NonNull;

import java.util.List;

import io.reactivex.Single;
import ru.sberbankschool.android.domain.model.Post;

public interface PostRepository {

    @NonNull
    Single<Post> postsAdd(Post post);

    @NonNull
    Single<List<Post>> postsList();
}
