package ru.sberbankschool.android.presentation.post;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.sberbankschool.android.di.DaggerAppComponent;
import ru.sberbankschool.android.domain.PostInteractor;
import ru.sberbankschool.android.domain.model.Post;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class MainViewModel extends ViewModel {

    @NonNull
    private final CompositeDisposable mDisposable = new CompositeDisposable();
    @NonNull
    private final PostInteractor mInteractor;
    @NonNull
    private final MutableLiveData<List<Post>> mPostsData = new MutableLiveData<>(emptyList());
    @NonNull
    private final MutableLiveData<String> mErrorData = new MutableLiveData<>();

    public MainViewModel(@NonNull PostInteractor interactor) {
        mInteractor = interactor;
    }

    @NonNull
    public LiveData<List<Post>> getPostsData() {
        return mPostsData;
    }

    @NonNull
    public LiveData<String> getErrorData() {
        return mErrorData;
    }

    public void onClickAddPost() {
        mDisposable.add(mInteractor.postsAdd(new Post(
                12, "Post title", "If the activity is re-created, it receives the same MyViewModel" +
                " instance that was created by the first activity. When the owner activity is finished," +
                " the framework calls the ViewModel objects onCleared() method so that it can clean up resources."))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        post -> mPostsData.postValue(singletonList(post)),
                        throwable -> mErrorData.postValue(throwable.getMessage())
                ));
    }

    public void onClickListPosts() {
        mDisposable.add(mInteractor.postsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        mPostsData::postValue,
                        throwable -> mErrorData.postValue(throwable.getMessage())
                ));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mDisposable.dispose();
    }
}
