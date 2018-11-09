package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableSidecar
@EnableEurekaClient
public class RunAppSidecar {
	public static void main(String[] args) {
		SpringApplication.run(RunAppSidecar.class, args);
	}
}
