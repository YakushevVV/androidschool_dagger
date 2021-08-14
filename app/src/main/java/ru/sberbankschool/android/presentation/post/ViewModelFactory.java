package ru.sberbankschool.android.presentation.post;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import ru.sberbankschool.android.domain.PostInteractor;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final PostInteractor mInteractor;

    @Inject
    public ViewModelFactory(PostInteractor interactor) {
        mInteractor = interactor;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new MainViewModel(mInteractor);
    }
}
