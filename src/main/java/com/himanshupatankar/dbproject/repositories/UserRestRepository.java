package com.himanshupatankar.dbproject.repositories;

import com.himanshupatankar.dbproject.models.Experiment;
import com.himanshupatankar.dbproject.models.Scientist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRestRepository
        extends CrudRepository<Scientist, Integer> {
    @Query(value = "SELECT * FROM scientists",
            nativeQuery = true)
    public List<Scientist> findAllUsers();
    @Query(value = "SELECT * FROM scientists WHERE id=:userId",
            nativeQuery = true)
    public Scientist findUserById(@Param("userId") Integer id);
    /*
    @Query(value = "SELECT * FROM experiments WHERE scientist_id=:userId",
    nativeQuery = true)
    public List<Experiment> findUsersExperiments(@Param("userId") Integer id);

     */
}
