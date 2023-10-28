package com.scheduleTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduleTest.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
