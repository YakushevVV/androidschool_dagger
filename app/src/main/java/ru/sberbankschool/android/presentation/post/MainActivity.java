package ru.sberbankschool.android.presentation.post;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView postListView = findViewById(R.id.postList);
        final TextView placeholderView = findViewById(R.id.placeholder);

        final MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getErrorData().observe(this, errorText -> {
            postListView.setVisibility(View.GONE);
            placeholderView.setVisibility(View.VISIBLE);
            placeholderView.setText(errorText);
        });
        viewModel.getPostsData().observe(this, posts -> {
            if (posts.isEmpty()) {
                postListView.setVisibility(View.GONE);
                placeholderView.setVisibility(View.VISIBLE);
                placeholderView.setText(R.string.empty_data);
            } else {
                postListView.setVisibility(View.VISIBLE);
                placeholderView.setVisibility(View.GONE);
                postListView.setAdapter(new PostAdapter(posts));
            }
        });

        Button btnPostsList = findViewById(R.id.btnPostsList);
        btnPostsList.setOnClickListener(v -> viewModel.onClickListPosts());

        Button btnPostsAdd = findViewById(R.id.btnPostsAdd);
        btnPostsAdd.setOnClickListener(v -> viewModel.onClickAddPost());
    }
}