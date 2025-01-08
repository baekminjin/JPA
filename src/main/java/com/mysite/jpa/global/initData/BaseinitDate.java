package com.mysite.jpa.global.initData;

import com.mysite.jpa.domain.post.post.entity.Post;
import com.mysite.jpa.domain.post.post.service.PostService;

import com.mysite.jpa.standard.util.Ut;
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

	@Bean
	@Order(1)
	public ApplicationRunner baseInitData1ApplicationRunner() {
		return args -> {
			//0보다 크면 리턴
			if ( postService.count() > 0 ) return;

			//한 번만 생성되도록
			Post post1 = postService.write("title1", "content1");
			Post post2 = postService.write("title2", "content2");
			Post post3 = postService.write("title3", "content3");
		};
	}

	//더 늦게 만들어지는 빈 / findById -> 인자 없는 생성자 필요 (ID가 null이기 때문에)
	@Bean
	@Order(2)
	public ApplicationRunner baseInitData2ApplicationRunner() {
		return args -> {
			Ut.thread.sleep(1000); //1초 뒤

			Post post1 = postService.findById(1).get();
			postService.modify(post1, "title1-1", "content1-1");
		};
	}
}
