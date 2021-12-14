package com.himanshupatankar.dbproject.daos;

import com.himanshupatankar.dbproject.models.Sample;

import com.himanshupatankar.dbproject.repositories.SampleRestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleOrmDao {

  @Autowired
  SampleRestRepository sampleRestRepository;

  @GetMapping("/orm/samples/create/{nm}/{org}/{to}/{dna}/{dis}/{ven}/{nt}/{ei}")
  public Sample createSample(
      @PathVariable("nm")String name,
      @PathVariable("org")String organsim,
      @PathVariable("to")String tissue,
      @PathVariable("dna")String dna,
      @PathVariable("dis")String disease,
      @PathVariable("ven") String vendor,
      @PathVariable("nt")String notes,
      @PathVariable("ei")Integer experiment_id){
    Sample sample = new Sample(name, organsim, tissue, dna, disease, vendor, notes, experiment_id);
    return sampleRestRepository.save(sample);
  }

  @GetMapping("/orm/samples/find")
  public List<Sample> findAllSample() {
    return sampleRestRepository.findAllSamples();
  }

  @GetMapping("/orm/samples/find/id/{userId}")
  public Sample findSampleById(
      @PathVariable("userId") Integer id) {
    return sampleRestRepository.findSampleById(id);
  }


  @GetMapping("/orm/samples/delete/{userId}")
  public void deleteSample(
      @PathVariable("userId") Integer id) {
    sampleRestRepository.deleteById(id);
  }


  @GetMapping("/orm/samples/update/{userId}/{name}")
  public Sample updateSample(
      @PathVariable("userId") Integer id,
      @PathVariable("name") String name) {
    Sample sample = sampleRestRepository.findSampleById(id);
    sample.setName(name);
    return sampleRestRepository.save(sample);
  }


}
