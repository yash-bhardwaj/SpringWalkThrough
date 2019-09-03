/**
 * 
 */
package com.bmw.wallet.cron.oauth.response.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author avadheshkumar
 *
 */
@JsonInclude
public class OauthRestResponse {
	@JsonProperty("accessToken")
	private String accessToken;
	@JsonProperty("tokenType")
	private String tokenType;
	@JsonProperty("refreshToken")
	private String refreshToken;
	@JsonProperty("expiresIn")
	private String expiresIn;
	@JsonProperty("scope")
	private String scope;
	@JsonProperty("jtl")
	private String jti;

	public OauthRestResponse() {
	}

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the tokenType
	 */
	public String getTokenType() {
		return tokenType;
	}

	/**
	 * @param tokenType the tokenType to set
	 */
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	/**
	 * @return the refreshToken
	 */
	public String getRefreshToken() {
		return refreshToken;
	}

	/**
	 * @param refreshToken the refreshToken to set
	 */
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	/**
	 * @return the expiresIn
	 */
	public String getExpiresIn() {
		return expiresIn;
	}

	/**
	 * @param expiresIn the expiresIn to set
	 */
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	/**
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * @param scope the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * @return the jti
	 */
	public String getJti() {
		return jti;
	}

	/**
	 * @param jti the jti to set
	 */
	public void setJti(String jti) {
		this.jti = jti;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OauthRestResponse [accessToken=" + accessToken + ", tokenType=" + tokenType + ", refreshToken="
				+ refreshToken + ", expiresIn=" + expiresIn + ", scope=" + scope + ", jti=" + jti + "]";
	}

}
