package com.himanshupatankar.dbproject.daos;


import com.himanshupatankar.dbproject.models.Sample;
import com.himanshupatankar.dbproject.repositories.SampleRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SampleRestOrmDao {
  @Autowired
  SampleRestRepository sampleRestRepository;

  @PostMapping("/api/samples")
  public Sample createSamples(@RequestBody Sample sample) {
    return sampleRestRepository.save(sample);
  }

  @GetMapping("/api/samples")
  public List<Sample> findAllSamples() {
    return sampleRestRepository.findAllSamples();
  }

  @GetMapping("/api/samples/{userId}")
  public Sample findSampleById(
      @PathVariable("userId") Integer id) {
    return sampleRestRepository.findSampleById(id);
  }

  @GetMapping("/api/samples/experiment/{userId}")
  public List<Sample> findSampleByExperiment(
      @PathVariable("userId") Integer id) {
    return sampleRestRepository.findSampleByExperiment(id);
  }

  @PutMapping("/api/samples/{userId}")
  public Sample updateSample(
      @PathVariable("userId") Integer id,
      @RequestBody Sample sampleUpdates) {
    Sample sample = sampleRestRepository.findSampleById(id);
    sample.setName(sampleUpdates.getName());
    sample.setOrganism(sampleUpdates.getOrganism());
    sample.setTissueOrigin(sampleUpdates.getTissueOrigin());
    sample.setDnaSequence(sampleUpdates.getDnaSequence());
    sample.setDisease(sampleUpdates.getDisease());
    sample.setVendor(sampleUpdates.getVendor());
    sample.setNotes(sampleUpdates.getNotes());
    sample.setExperiment_id(sampleUpdates.getExperiment_id());

    return sampleRestRepository.save(sample);
  }

  @DeleteMapping("/api/samples/{userId}")
  public void deleteSample(
      @PathVariable("userId") Integer id) {
    sampleRestRepository.deleteById(id);
  }
}