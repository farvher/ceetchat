package com.eltiempo.ceetchat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eltiempo.ceetchat.entities.Consecutive;
import com.eltiempo.ceetchat.enumeration.ConsecutiveEnum;
import com.eltiempo.ceetchat.repository.ConsecutiveRepository;

@Service
public class ConsecutiveServiceImpl implements ConsecutiveService {

	@Autowired
	private ConsecutiveRepository consecutiveRepository;

	@Override
	public Long getConsecutive(ConsecutiveEnum consecutiveEnum) {
		Optional<Consecutive> optionalConsecutive = consecutiveRepository.findFirtsByEntity(consecutiveEnum);

		if (!optionalConsecutive.isPresent()) {
			this.saveCosecutivive(consecutiveEnum);
			saveCosecutivive(consecutiveEnum);
			return 1L;
		}
		saveCosecutivive(consecutiveEnum);
		return optionalConsecutive.get().getCount();
	}

	@Override
	public void saveCosecutivive(ConsecutiveEnum consecutiveEnum) {
		Optional<Consecutive> optionalConsecutive = consecutiveRepository.findFirtsByEntity(consecutiveEnum);
		Long pos = consecutiveRepository.count() + 1;
		if (!optionalConsecutive.isPresent()) {
			consecutiveRepository.save(new Consecutive(pos, consecutiveEnum, 1l));
		}else {
			Consecutive consecutive = optionalConsecutive.get();
			consecutive.setCount(consecutive.getCount()+1);
			consecutiveRepository.save(consecutive);
		}
	}

}
