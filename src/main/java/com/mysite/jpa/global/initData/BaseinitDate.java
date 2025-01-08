package com.mysite.jpa.global.initData;

import com.mysite.jpa.domain.post.comment.entity.PostComment;
import com.mysite.jpa.domain.post.comment.service.PostCommentService;
import com.mysite.jpa.domain.post.post.entity.Post;
import com.mysite.jpa.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

//초기 설정
@Configuration
@RequiredArgsConstructor
public class BaseinitDate {
	private final PostService postService;
	private final PostCommentService postCommentService;

	@Bean
	@Order(1)
	public ApplicationRunner baseInitData1ApplicationRunner() {
		return args -> {
			//0보다 크면 리턴
			if (postService.count() > 0) return;

			//한 번만 생성되도록
			Post post1 = postService.write("title1", "content1");
			Post post2 = postService.write("title2", "content2");
			Post post3 = postService.write("title3", "content3");

			// 1번글에 대한 댓글 1 생성
			PostComment postComment1 = postCommentService.write(post1, "comment1");
			// 1번글에 대한 댓글 2 생성
			PostComment postComment2 = postCommentService.write(post1, "comment2");
			// 2번글에 대한 댓글 3 생성
			PostComment postComment3 = postCommentService.write(post2, "comment3");

			Post postOfComment3 = postComment3.getPost();

		};
	}
		@Bean
		@Order(2)
		public ApplicationRunner baseInitData2ApplicationRunner() {
			return args -> {
				PostComment postComment3 = postCommentService.findById(3).get();
            /*
            SELECT PC.id,
            PC.blind,
            PC.content,
            PC.created_at,
            PC.modified_at,
            P.id,
            P.blind,
            P.content,
            P.created_at,
            P.modified_at,
            P.title
            FROM post_comment AS PC
            LEFT JOIN
            post AS P
            ON P.id = PC.post_id
            WHERE PC.id = 3
            */
				Post postOfComment3 = postComment3.getPost();
			};
		}
	}


