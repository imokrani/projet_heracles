package org.kata.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kata.model.Score;
import org.kata.utils.KataConstantes;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreDaoImpl implements ScoreDao{

	private static Map<String, List<Score>> map = new HashMap<String, List<Score>>();  
	private static final int PLAYER1=1; 
	private static final int PLAYER2=2; 
	private static final int FIRST_POINT =15;
	private static final int POINT =10;
	private static final int SCORE_MAX = 40; 
	private static final int START_GAME_SCORE = 0; 
	private static final String MATCH="Match"; 
	private static final String _MSG = "win the game";
	
	private static boolean isLastPoint = false; 
	/*
	 * Prendre en compte que les données sont volatiles et statiques 
	 * ce qui explique la quantité de code dans la couche DAO 
	 * Dans un vrai projet avec un DataStor une bonne partie de ce code se retrouvera dans 
	 * la couche Business 
	 * 
	 * */
	
	/**
	 * Static bloc for init data 
	 */
	static {
		initData();
	}

	/**
	 * Get all scores 
	 */
	@Override
	public Map<String, List<Score>> findAll() {
		return map;
	}
	
	/**
	 * add point for the winner 
	 */
	@Override
	public Map<String, List<Score>> addPoint(int playerId) {
		if(!isLastPoint) {
			long count = map.get(MATCH).stream().count();
			Score s = map.get(MATCH).stream().skip(count - 1).findFirst().get();
			Score newScore = null;
			KataConstantes.MSG =_MSG; 
			if(PLAYER1== playerId) {
				newScore = new Score(getNewScore(s.getPlayer1(), playerId), s.getPlayer2());
			} else if(PLAYER2== playerId) {
				newScore = new Score(s.getPlayer1(), getNewScore(s.getPlayer2(), playerId));
			}
			if(newScore!=null) {
				if((newScore.getPlayer1() <= SCORE_MAX  && newScore.getPlayer2()  <= SCORE_MAX )) {
				       map.get(MATCH).add(newScore);
				} else {
					map.get(MATCH).add(new Score(START_GAME_SCORE, START_GAME_SCORE));
					isLastPoint=false;
				}
			}
		} else {
			map.get(MATCH).add(new Score(START_GAME_SCORE, START_GAME_SCORE));
			isLastPoint=false;
		}
		return map;
	}

	/**
	 * Get new score 
	 * @param oldScore
	 * @param playerId
	 * @return
	 */
	private int getNewScore(int oldScore, int playerId) {
		if(START_GAME_SCORE == oldScore) {
			return FIRST_POINT; 
		} else if(FIRST_POINT == oldScore) {
			return oldScore+FIRST_POINT;
		}
		int currentScore = oldScore+POINT; 
		if(currentScore > SCORE_MAX) {
			isLastPoint = true; 
			if(playerId==PLAYER1) {
				KataConstantes.MSG = KataConstantes.PLAYER1+KataConstantes.MSG; 
			} else if(playerId==PLAYER2) {
				KataConstantes.MSG = KataConstantes.PLAYER2+KataConstantes.MSG;
			}
		}
		return currentScore;
	}
	
	/**
	 * Init data
	 */
	private static void initData() {
		List<Score> scores = new ArrayList<Score>(); 
		scores.add(new Score(START_GAME_SCORE, START_GAME_SCORE)); 
		map.put(MATCH, scores);
	}
}
