package com.scheduleTest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheduleTest.entity.Movie;
import com.scheduleTest.repository.MovieRepository;
import com.scheduleTest.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	public Movie findMovieById(Integer id) {
		return movieRepo.findById(id).orElse(null);
	}

}
