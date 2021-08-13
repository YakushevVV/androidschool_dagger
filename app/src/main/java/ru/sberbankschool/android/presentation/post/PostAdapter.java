package ru.sberbankschool.android.presentation.post;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;

import java.util.List;

import ru.sberbankschool.android.domain.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private final List<Post> mPosts;

    public PostAdapter(List<Post> posts) {
        mPosts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item_post, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int position) {
        if (position < 0 || position >= getItemCount()) {
            postViewHolder.bindView(null);
        } else {
            postViewHolder.bindView(mPosts.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        private final TextView mIdView;
        private final TextView mTitleView;
        private final TextView mBodyView;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            mIdView = itemView.findViewById(R.id.userId);
            mTitleView = itemView.findViewById(R.id.title);
            mBodyView = itemView.findViewById(R.id.body);
        }

        private void bindView(@Nullable Post item) {
            mIdView.setText(item == null ? "" : String.valueOf(item.userId));
            mTitleView.setText(item == null ? "Item not found" : String.valueOf(item.title));
            mBodyView.setText(item == null ? "" : String.valueOf(item.body));
        }
    }
}
