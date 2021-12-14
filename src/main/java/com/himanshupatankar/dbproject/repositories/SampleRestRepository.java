package com.himanshupatankar.dbproject.repositories;

import com.himanshupatankar.dbproject.models.Experiment;
import com.himanshupatankar.dbproject.models.Sample;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SampleRestRepository
    extends CrudRepository<Sample, Integer> {
  @Query(value = "SELECT * FROM samples",
      nativeQuery = true)
  public List<Sample> findAllSamples();
  @Query(value = "SELECT * FROM samples WHERE id=:userId",
      nativeQuery = true)
  public Sample findSampleById(@Param("userId") Integer id);
  @Query(value = "SELECT * FROM samples WHERE experiment_id=:userId",
      nativeQuery = true)
  public List<Sample> findSampleByExperiment(@Param("userId") Integer id);
}
