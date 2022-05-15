package com.example.todolist.Activities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ActivityRepository  extends JpaRepository<Activities,Long> {
//@Query("Select Activities  from Activities where id=?1")
  Optional<Activities>findActivitiesByTask(String task);
  Optional<Activities>findActivitiesById(Long id);

}
