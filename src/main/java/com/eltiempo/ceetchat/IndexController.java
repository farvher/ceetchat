package com.eltiempo.ceetchat;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eltiempo.ceetchat.util.DidYouMean;

@Controller
public class IndexController {

	private static final String INDEX = "index";

	@GetMapping(value = "/dym/{word:.*}")
	@ResponseBody
	public String index(Model model, @PathVariable String word) {

		StringBuilder str = new StringBuilder();
		List<Object> list = DidYouMean.getSuggestions(word, 5);
		for (Object w : list) {
			str.append(w);
			str.append(" - ");
		}
		return "quisiste decir: " + str.toString();
	}
	
	
	
}
