package com.mysite.jpa.global.initData;

import com.mysite.jpa.domain.post.post.entity.Post;
import com.mysite.jpa.domain.post.post.service.PostService;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//초기 설정
@Configuration
@RequiredArgsConstructor
public class BaseinitDate {
	private final PostService postService;

	@Bean
	public ApplicationRunner baseInitDataApplicationRunner() {
		return args -> {
			//0보다 크면 리턴
			if ( postService.count() > 0 ) return;

			//한 번만 생성되도록
			Post post1 = postService.write("title1", "content1");
			Post post2 = postService.write("title2", "content2");
			Post post3 = postService.write("title3", "content3");
		};
	}
}
