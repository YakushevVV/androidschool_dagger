package ru.sberbankschool.android.domain.model;

import androidx.annotation.NonNull;

import java.util.Objects;
import java.util.StringJoiner;

public class Post {

    public long userId;
    public String title;
    public String body;

    public Post(long userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return userId == post.userId && Objects.equals(title, post.title) && Objects.equals(body, post.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, title, body);
    }

    @NonNull
    @Override
    public String toString() {
        return new StringJoiner(", ", Post.class.getSimpleName() + "[", "]")
                .add("userId=" + userId)
                .add("title='" + title + "'")
                .add("body='" + body + "'")
                .toString();
    }
}
