package com.mysite.jpa.domain.post.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
public class Post {
	@Id
	@GeneratedValue(strategy = IDENTITY) // AUTO_INCREMENT
	private Long id;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	@Column(length = 100)
	private String title;
	@Column(columnDefinition = "TEXT")
	private String content;
	private boolean blind;
}