package com.arms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSampleController {

	@RequestMapping("/tni")
	public String index() {
		return "Hello World";
	}
}
