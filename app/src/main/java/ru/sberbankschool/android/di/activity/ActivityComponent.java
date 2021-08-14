package ru.sberbankschool.android.di.activity;

import dagger.Subcomponent;
import ru.sberbankschool.android.presentation.post.MainActivity;

@ActivityScope
@Subcomponent
public interface ActivityComponent {

    void inject(MainActivity activity);
}
