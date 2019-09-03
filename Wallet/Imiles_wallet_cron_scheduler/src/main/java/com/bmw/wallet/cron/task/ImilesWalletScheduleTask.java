/**
 * 
 */
package com.bmw.wallet.cron.task;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bmw.wallet.cron.oauth.response.dto.OauthRestResponse;

/**
 * @author avadheshkumar
 *
 */
@Component
public class ImilesWalletScheduleTask {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${spring.imiles.service.domain}")
	private String restUrl;
	
	@Scheduled(cron = "${spring.imiles.wallet.cron.expression}")
	public void changesImilesStatus() {
		
	}
	
	@Scheduled(cron = "${spring.imiles.wallet.cron.expression}")
	public void postImilesData() throws URISyntaxException {
		String url = restUrl+"/external/postImiles";
		URI uri = new URI(url);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(uri, httpEntity, String.class);
		System.out.println("response-->"+response);
	}
	
	
	
	public OauthRestResponse getOauthToken() {
		return null;
	} 
}
