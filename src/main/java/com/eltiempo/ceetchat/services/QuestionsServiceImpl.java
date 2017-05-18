package com.eltiempo.ceetchat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eltiempo.ceetchat.entities.Questions;
import com.eltiempo.ceetchat.enumeration.ConsecutiveEnum;
import com.eltiempo.ceetchat.repository.QuestionsRepository;

@Service
public class QuestionsServiceImpl implements QuestionsServices {

	@Autowired
	private QuestionsRepository questionsRepository;

	@Autowired
	private ConsecutiveService consecutiveService;

	@Override
	public void saveQuestion(String question) {
		Questions quest = this.getQuestion(question);
		if (quest == null) {
			Long pos = consecutiveService.getConsecutive(ConsecutiveEnum.QUESTIONS);
			quest = new Questions(pos, question, 1L);
			questionsRepository.save(quest);
		} else {
			quest.setCount(quest.getCount() + 1);
			questionsRepository.save(quest);
		}
	}

	@Override
	public Questions getQuestion(String question) {
		Optional<Questions> questionOptional = questionsRepository.findFirstByQuestion(question);
		if (questionOptional.isPresent()) {

			return questionOptional.get();
		}
		return null;
	}

}
