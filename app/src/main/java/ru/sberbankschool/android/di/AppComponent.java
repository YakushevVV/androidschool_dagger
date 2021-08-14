package ru.sberbankschool.android.di;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.BindsInstance;
import dagger.Component;
import ru.sberbankschool.android.data.JsonPlaceholderApi;
import ru.sberbankschool.android.data.RetrofitPostRepository;
import ru.sberbankschool.android.di.activity.ActivityComponent;
import ru.sberbankschool.android.domain.PostRepository;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    ActivityComponent getActivityComponent();

    @Component.Factory
    interface Builder {

        AppComponent create(@BindsInstance String baseUrl);
    }
}
