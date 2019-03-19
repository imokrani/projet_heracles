package org.kata.business;

import java.util.List;
import java.util.Map;

import org.kata.dao.ScoreDao;
import org.kata.model.GameResults;
import org.kata.model.Score;
import org.kata.utils.KataConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	ScoreDao scoreDao;
	
	@Override
	public GameResults addPoint(int playerId) {
		
		GameResults results = new GameResults(scoreDao.addPoint(playerId), KataConstantes.MSG);
		return results;
	}

	@Override
	public Map<String, List<Score>> findAll() {
		return scoreDao.findAll();
	}

}
