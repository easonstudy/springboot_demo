package com.gmh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//扫描servlet 文件
@ServletComponentScan
//Mybaits dao扫描
@MapperScan("com.gmh.cjcx.dao")
//启动
@SpringBootApplication
public class GirlApplication  {

	public static void main(String[] args) {

		SpringApplication.run(GirlApplication.class, args);
	}

	// Java EE应用服务器配置，
	// 如果要使用tomcat来加载jsp的话就必须继承SpringBootServletInitializer类并且重写其中configure方法
	/*@Override  extends SpringBootServletInitializer
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}*/


}
