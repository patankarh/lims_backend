package com.himanshupatankar.dbproject.daos;

import com.himanshupatankar.dbproject.models.Experiment;

import com.himanshupatankar.dbproject.repositories.ExperimentRestRepository;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperimentOrmDao {

  @Autowired
  ExperimentRestRepository experimentRepository;

  @GetMapping("/orm/experiments/create/{ti}/{ty}/{dp}/{nt}/{sc}")
  public Experiment createExperiment(
      @PathVariable("ti")String title,
      @PathVariable("ty")String treatmentType,
      @PathVariable("dp")Date datePerformed,
      @PathVariable("nt")String notes,
      @PathVariable("sc")Integer scientist_id ){
    Experiment experiment = new Experiment(title,treatmentType,datePerformed,notes,scientist_id );
    return experimentRepository.save(experiment);
  }

  @GetMapping("/orm/experiments/find")
  public List<Experiment> findAllExperiment() {
    return experimentRepository.findAllExperiments();
  }

  @GetMapping("/orm/experiments/find/id/{userId}")
  public Experiment findExperimentById(
      @PathVariable("userId") Integer id) {
    return experimentRepository.findExperimentById(id);
  }


  @GetMapping("/orm/experiments/delete/{userId}")
  public void deleteExperiment(
      @PathVariable("userId") Integer id) {
    experimentRepository.deleteById(id);
  }


  @GetMapping("/orm/experiments/update/{userId}/{title}")
  public Experiment updateExperiment(
      @PathVariable("userId") Integer id,
      @PathVariable("title") String newPass) {
    Experiment experiment = experimentRepository.findExperimentById(id);
    experiment.setTitle(newPass);
    return experimentRepository.save(experiment);
  }




}
