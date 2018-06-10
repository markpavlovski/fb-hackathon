package com.example.demo.github;

import com.example.demo.GithubProperties;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Component
public class GithubClient {

  private final RestTemplate restTemplate;

  //  private static final String EVENT_ISSUES_URL = "https://api.github.com/repos/{owner}/{repo}/issues/events";

  private static final String EVENT_ISSUES_URL = "https://api.github.com/repos/vmg/redcarpet/issues/events";

  public GithubClient(RestTemplateBuilder builder, GithubProperties properties) {
    this.restTemplate = builder
//        .additionalInterceptors(new GithubAppTokenInterceptor(properties.getToken()))
        .build();
  }

  public ResponseEntity<RepositoryEvent[]> fetchEvents(String orgName, String repoName) {
    try {
      return this.restTemplate.getForEntity(EVENT_ISSUES_URL, RepositoryEvent[].class, orgName, repoName);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }

  public List<RepositoryEvent> fetchEventsList(String orgName, String repoName) {
    return Arrays.asList(fetchEvents(orgName, repoName).getBody());
  }

  private static class GithubAppTokenInterceptor implements ClientHttpRequestInterceptor {

    private final String token;

    GithubAppTokenInterceptor(String token) {
      this.token = token;
    }

    @Override public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution)
        throws IOException {
      if (StringUtils.hasText(this.token)) {
        byte[] basicAuthValue = this.token.getBytes(StandardCharsets.UTF_8);
        httpRequest.getHeaders().set(HttpHeaders.AUTHORIZATION,
            "Basic " + Base64Utils.encodeToString(basicAuthValue));
      }

      return clientHttpRequestExecution.execute(httpRequest, body);

    }

  }
}
