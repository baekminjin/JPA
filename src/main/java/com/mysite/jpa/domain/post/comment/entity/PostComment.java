package com.mysite.jpa.domain.post.comment.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class PostComment {
	@Id
	@GeneratedValue(strategy = IDENTITY) // AUTO_INCREMENT
	@Setter(AccessLevel.PRIVATE) //JPA에서 해주기 때문에 외부에서 사용하지말라는 뜻
	private Long id;

	@CreatedDate
	@Setter(AccessLevel.PRIVATE)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Setter(AccessLevel.PRIVATE)
	private LocalDateTime modifiedAt;

	@Column(columnDefinition = "TEXT")
	private String content;

	private boolean blind;

	private long postId;
}
