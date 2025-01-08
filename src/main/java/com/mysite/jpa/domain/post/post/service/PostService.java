package com.mysite.jpa.domain.post.post.service;

import com.mysite.jpa.domain.post.post.entity.Post;
import com.mysite.jpa.domain.post.post.repository.PostRepository;
import com.mysite.jpa.standard.util.Ut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	public Post write(String title, String content) {
		Post post = Post
				.builder()
				.createdAt(LocalDateTime.now()) //명시적
				.modifiedAt(LocalDateTime.now())
				.title(title)
				.content(content)
				.build();

		postRepository.save(post);
		return post;
	}


	public long count() {
		return postRepository.count();
	}

	public Optional<Post> findById(long id) {
		return postRepository.findById(id);

	}

	public void modify(Post post, String title, String content) {
		post.setTitle(title);
		post.setContent(content);
		postRepository.save(post);
	}
}