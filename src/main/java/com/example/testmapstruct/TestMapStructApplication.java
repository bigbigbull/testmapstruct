package com.example.testmapstruct;

import com.example.testmapstruct.convert.EmployeeWorkConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;


/**
 * <p>
 * 员工工作经历信息表
 * </p>
 *
 * @author lichangkai
 * @since 2020-09-06
 */
@SpringBootApplication
public class TestMapStructApplication {


	public static void main(String[] args) {
		SpringApplication.run(TestMapStructApplication.class, args);
	}

}
