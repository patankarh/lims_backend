package com.himanshupatankar.dbproject.repositories;

import com.himanshupatankar.dbproject.models.Scientist;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<Scientist, Integer> {
  @Query(value = "SELECT * FROM scientists", nativeQuery = true)
  public List<Scientist> findAllUsers();
  @Query(value = "SELECT * FROM scientists WHERE id=:userId", nativeQuery = true)
  public Scientist findUserById(@Param("userId") Integer id);
}

