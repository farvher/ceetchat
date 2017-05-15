package com.eltiempo.ceetchat.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.event.SpellChecker;

@Component
public class DidYouMean {

	protected static SpellDictionaryHashMap dictionary = null;
	protected static SpellChecker spellChecker = null;

	static {
		try {
			dictionary = new SpellDictionaryHashMap(new File(DidYouMean.class.getResource("/dict.txt").getFile()));
		} catch (IOException e) {

			e.printStackTrace();
		}
		spellChecker = new SpellChecker(dictionary);
	}

	public static List getSuggestions(String word, int threshold) {
		return spellChecker.getSuggestions(word, threshold);
	}

}
