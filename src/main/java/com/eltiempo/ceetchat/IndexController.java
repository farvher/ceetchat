package com.eltiempo.ceetchat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	private static final String INDEX = "index";

	@GetMapping(value = "/")
	public String index(Model model) {

		return INDEX;
	}
}
