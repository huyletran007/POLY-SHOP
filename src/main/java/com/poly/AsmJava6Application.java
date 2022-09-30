package com.poly;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class AsmJava6Application {

	public static void main(String[] args) {
		SpringApplication.run(AsmJava6Application.class, args);
//		Runtime rt = Runtime.getRuntime();
//	      try {
//	    	  rt.exec("cmd /c start chrome.exe http://localhost:8080/home");
//	      } catch (IOException e) {
//	          e.printStackTrace();
//	      }
	}

}
