package com.mysite.jpa.domain.post.comment.service;

import com.mysite.jpa.domain.post.comment.entity.PostComment;
import com.mysite.jpa.domain.post.comment.repository.PostCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostCommentService {

	private final PostCommentRepository postCommentRepository;

	public PostComment write(long postId, String content) {
		PostComment postComment = PostComment.builder()
				.postId(postId)
				.content(content)
				.build();
		return postCommentRepository.save(postComment);
	}
}
