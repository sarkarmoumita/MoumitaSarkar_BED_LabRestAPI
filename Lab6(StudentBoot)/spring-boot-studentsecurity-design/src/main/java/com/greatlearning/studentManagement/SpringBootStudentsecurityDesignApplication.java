package com.greatlearning.studentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
(basePackages={"com.greatlearning.studentManagement.controller","com.greatlearning.studentManagement.service",
		"com.greatlearning.studentManagement.repository",
		"com.greatlearning.studentManagement.security","com.greatlearning.studentManagement.entity"})
@SpringBootApplication(scanBasePackages = {"com.greatlearning.studentManagement.list-Students.jsp",
		"com.greatlearning.studentManagement.403.jsp","com.greatlearning.studentManagement.Student-form.jsp"})
public class SpringBootStudentsecurityDesignApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootStudentsecurityDesignApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudentsecurityDesignApplication.class);
    }
}