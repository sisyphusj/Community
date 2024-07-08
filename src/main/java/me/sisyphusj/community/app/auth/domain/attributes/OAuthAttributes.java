package me.sisyphusj.community.app.auth.domain.attributes;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.sisyphusj.community.app.auth.domain.OAuthProvider;

@Getter
@AllArgsConstructor
public abstract class OAuthAttributes {

	private Map<String, Object> attributes;

	private String nameAttributeKey;

	private OAuthProvider oAuthProvider;

	private String name;

	private String userIdentify;

}
