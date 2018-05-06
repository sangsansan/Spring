package com.jackie.springmvc.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/helloworld")
public class HelloWorld {
	
	@RequestMapping("/helloworld")
	public String helloworld() {
		System.out.println("here");
		String jsp = "city";
		System.out.println("here");
		return jsp;
		
	}

   

}
