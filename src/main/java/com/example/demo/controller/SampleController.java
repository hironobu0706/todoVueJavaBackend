package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*") // このコントローラーの全メソッドを全許可
//@CrossOrigin("http://localhost:3000") // https://todo-list-plus-front-hironobu0706-hironobu0706s-projects.vercel.app/
public class SampleController {

	@GetMapping("/sample")
	public String sample() {
		System.out.println("aaaaaaaaaaaaaaaaaaaa3");
		return "connection OK";
	}
}
