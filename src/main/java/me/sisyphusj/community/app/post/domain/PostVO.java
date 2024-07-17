package me.sisyphusj.community.app.post.domain;

import lombok.Builder;
import lombok.Getter;
import me.sisyphusj.community.app.utils.SecurityUtil;

@Builder
@Getter
public class PostVO {

	private Long postId;

	private Long userId;

	private String title;

	private String content;

	private HasImage hasImage;

	public static PostVO of(PostCreateReqDTO postCreateReqDTO) {
		return PostVO.builder()
			.userId(SecurityUtil.getLoginUserId())
			.title(postCreateReqDTO.getTitle())
			.content(postCreateReqDTO.getContent())
			.hasImage(postCreateReqDTO.getHasImage())
			.build();
	}

	public static PostVO of(PostEditReqDTO postEditReqDTO) {
		return PostVO.builder()
			.postId(postEditReqDTO.getPostId())
			.userId(SecurityUtil.getLoginUserId())
			.title(postEditReqDTO.getTitle())
			.content(postEditReqDTO.getContent())
			.hasImage(postEditReqDTO.getHasImage())
			.build();

	}
}
