package org.kata.dao;

import java.util.List;
import java.util.Map;

import org.kata.model.Score;


public interface ScoreDao {

	public Map<String, List<Score>> findAll(); 
	public Map<String, List<Score>> addPoint(int playerId);
}
