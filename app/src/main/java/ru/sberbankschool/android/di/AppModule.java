package ru.sberbankschool.android.di;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import ru.sberbankschool.android.data.JsonPlaceholderApi;
import ru.sberbankschool.android.data.RetrofitPostRepository;
import ru.sberbankschool.android.domain.PostRepository;

@Module
public interface AppModule {

    @Provides
    static JsonPlaceholderApi providePlaceholderApi(String baseUrl) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(JsonPlaceholderApi.class);
    }

    @Binds
    PostRepository bindRepository(RetrofitPostRepository impl);
}
