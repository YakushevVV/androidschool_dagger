package ru.sberbankschool.android.domain;

import androidx.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.sberbankschool.android.domain.model.Post;

public class PostInteractor {

    @NonNull
    private final PostRepository mRepository;

    @Inject
    public PostInteractor(@NonNull PostRepository repository) {
        mRepository = repository;
    }

    @NonNull
    public Single<Post> postsAdd(Post post) {
        return mRepository.postsAdd(post);
    }

    @NonNull
    public Single<List<Post>> postsList() {
        return mRepository.postsList();
    }
}
