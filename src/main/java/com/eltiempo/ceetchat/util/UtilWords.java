package com.eltiempo.ceetchat.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.swabunga.spell.engine.Word;

@Component
public class UtilWords {

	private static final String SPACE = " ";
	private static final int COST = 5;
	private static final int MAX_SUGGESTION = 10;
	private static final String NEW_LINE = "<br>";

	private static final Logger logger = LoggerFactory.getLogger(UtilWords.class);

	/**
	 * Procesa la frase retornardo posibles
	 * 
	 * @param String
	 *            word
	 **/
	public String buildSuggestions(String question) {
		StringBuilder str = new StringBuilder();
		List<String> questions = this.proccess(question);
		for (String q : questions) {
			str.append(q);
		}
		return str.toString();
	}

	public List<String> proccess(String question) {
		return proccessQuestion(question);
	}

	private List<String> proccessQuestion(String question) {
		List<String> questionList = new ArrayList<>();
		StringTokenizer stk = new StringTokenizer(question, SPACE);
		while (stk.hasMoreElements()) {
			String w = stk.nextToken();
			List<Object> dym = DidYouMean.getSuggestions(w, COST);
			question = this.replaceWord(question, w, dym);
		}
		questionList.add(question);
		return questionList;
	}

	private String replaceWord(String question, String w, List<Object> dym) {
		if (!dym.isEmpty()) {
			Word word = (Word) dym.get(0);
			return question.replace(w, word.getWord());
		}
		return question;
	}

	public void saveWord(String word) {
		DidYouMean.dictionary.addWord(word);
		File f = new File(DidYouMean.class.getResource("/dict.txt").getFile());
		Path p = Paths.get(f.getAbsolutePath());
		
		try {
			Files.write(p, ("\n"+word).getBytes(),StandardOpenOption.APPEND,StandardOpenOption.WRITE);
			logger.info(word+ " saved");
		} catch (Exception ex) {
			logger.error("error write",ex);
		}
	}

}
