package com.himanshupatankar.dbproject.daos;

import com.himanshupatankar.dbproject.models.Scientist;

import com.himanshupatankar.dbproject.repositories.UserRestRepository;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOrmDao {

  @Autowired
  UserRestRepository userRepository;

  @GetMapping("/orm/users/create/{fn}/{ln}/{un}/{pw}/{em}/{dob}/{rl}")
  public Scientist createUser(
      @PathVariable("fn")String first,
      @PathVariable("ln")String last,
      @PathVariable("un")String uname,
      @PathVariable("pw")String pass,
      @PathVariable("em")String email,
      @PathVariable("dob") String dob,
      @PathVariable("rl")String role){
    Scientist scientist = new Scientist(first, last, uname, pass, email, Date.valueOf(dob), role);
    return userRepository.save(scientist);
  }

  @GetMapping("/orm/users/find")
  public List<Scientist> findAllUser() {
    return userRepository.findAllUsers();
  }



  @GetMapping("/orm/users/find/id/{userId}")
  public Scientist findUserById(
      @PathVariable("userId") Integer id) {
    return userRepository.findUserById(id);
  }


  @GetMapping("/orm/users/delete/{userId}")
  public void deleteUser(
      @PathVariable("userId") Integer id) {
    userRepository.deleteById(id);
  }


  @GetMapping("/orm/users/update/{userId}/{password}")
  public Scientist updateUser(
      @PathVariable("userId") Integer id,
      @PathVariable("password") String newPass) {
    Scientist scientist = userRepository.findUserById(id);
    scientist.setPassword(newPass);
    return userRepository.save(scientist);
  }


}
