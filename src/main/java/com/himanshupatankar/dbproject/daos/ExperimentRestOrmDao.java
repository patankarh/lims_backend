package com.himanshupatankar.dbproject.daos;

import com.himanshupatankar.dbproject.models.Experiment;
import com.himanshupatankar.dbproject.repositories.ExperimentRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ExperimentRestOrmDao {
  @Autowired
  ExperimentRestRepository experimentRestRepository;

  @PostMapping("/api/experiments")
  public Experiment createExperiments(@RequestBody Experiment experiment) {
    return experimentRestRepository.save(experiment);
  }

  @GetMapping("/api/experiments")
  public List<Experiment> findAllExperiments() {
    return experimentRestRepository.findAllExperiments();
  }

  @GetMapping("/api/experiments/{userId}")
  public Experiment findExperimentById(
      @PathVariable("userId") Integer id) {
    return experimentRestRepository.findExperimentById(id);
  }

  @GetMapping("/api/experiments/user/{userId}")
  public List<Experiment> findExperimentByUser(
      @PathVariable("userId") Integer id) {
    return experimentRestRepository.findExperimentByUser(id);
  }

  @PutMapping("/api/experiments/{userId}")
  public Experiment updateExperiment(
      @PathVariable("userId") Integer id,
      @RequestBody Experiment experimentUpdates) {
    Experiment experiment = experimentRestRepository.findExperimentById(id);
    experiment.setTitle(experimentUpdates.getTitle());
    experiment.setTreatmentType(experimentUpdates.getTreatmentType());
    experiment.setDatePerformed(experimentUpdates.getDatePerformed());
    experiment.setNotes(experimentUpdates.getNotes());
    experiment.setScientist_id(experimentUpdates.getScientist_id());
    return experimentRestRepository.save(experiment);
  }

  @DeleteMapping("/api/experiments/{userId}")
  public void deleteExperiment(
      @PathVariable("userId") Integer id) {
    experimentRestRepository.deleteById(id);
  }
}
