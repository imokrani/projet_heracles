package org.kata.business;

import java.util.List;
import java.util.Map;

import org.kata.model.GameResults;
import org.kata.model.Score;

public interface ScoreService {

	public Map<String, List<Score>>  findAll();
	public GameResults addPoint(int playerId); 
}
