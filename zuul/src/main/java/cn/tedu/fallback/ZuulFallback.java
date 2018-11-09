package cn.tedu.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ZuulFallback implements ZuulFallbackProvider{
	//获取路由，application.name
	@Override
	public String getRoute() {
		return "consumer-hystrix";
	}
	//设置返回值，通常用json体现，utf-8防止中文乱码
	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				//请求响应头信息，contentType和字符类型
				HttpHeaders headers=new HttpHeaders();
				//返回类型为json,字符集为u8
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				//响应体，具体返回内容
				return new ByteArrayInputStream("意不意外".getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
}
