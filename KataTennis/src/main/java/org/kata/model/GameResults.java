package org.kata.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class GameResults implements Serializable {

	private static final long serialVersionUID = -757996918746446814L;
	
	private Map<String, List<Score>> scores; 
	private String message;
	
	public GameResults(Map<String, List<Score>> scores, String message) {
		super();
		this.scores = scores;
		this.message = message;
	}

	public Map<String, List<Score>> getScores() {
		return scores;
	}

	public void setScores(Map<String, List<Score>> scores) {
		this.scores = scores;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GameResults [scores=" + scores + ", message=" + message + "]";
	} 
}
