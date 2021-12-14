package com.himanshupatankar.dbproject.repositories;

import com.himanshupatankar.dbproject.models.Experiment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExperimentRestRepository
    extends CrudRepository<Experiment, Integer> {
  @Query(value = "SELECT * FROM experiments",
      nativeQuery = true)
  public List<Experiment> findAllExperiments();
  @Query(value = "SELECT * FROM experiments WHERE id=:userId",
      nativeQuery = true)
  public Experiment findExperimentById(@Param("userId") Integer id);
  @Query(value = "SELECT * FROM experiments WHERE scientist_id=:userId",
      nativeQuery = true)
  public List<Experiment> findExperimentByUser(@Param("userId") Integer id);
}

