package org.kata.web.controller;

import java.util.List;
import java.util.Map;

import org.kata.business.ScoreService;
import org.kata.model.GameResults;
import org.kata.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {
	
	@Autowired
	ScoreService scoreService; 
	
	
	@RequestMapping(value="/scores", method=RequestMethod.GET)
	public Map<String, List<Score>>  listeScores() {
		return scoreService.findAll();
	}
	
	@RequestMapping(value="/addpoint/{palyerId}", method=RequestMethod.GET)
	public  GameResults addPoint(@PathVariable int palyerId) {
		return scoreService.addPoint(palyerId);
	}
	

}
