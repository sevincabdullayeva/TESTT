package com.example.todolist.Activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/activities")
public class ActivitiesController {
    private final ActivitiesService activitiesservice;

    @Autowired
    public ActivitiesController(ActivitiesService activitiesservice) {
        this.activitiesservice = activitiesservice;
    }

    @GetMapping
    public List<Activities> getActivities(){
         return activitiesservice.getActivities();
    }
    @GetMapping(value = "/{ActivityID}")
    public Optional<Activities> getActivitybyId(@PathVariable("ActivityID") Long id)
    {
          return activitiesservice.getActivitiesbyID(id);
    }


    @PostMapping("/post")
    public void newActivities(@RequestBody Activities  activities){
        activitiesservice.addActivities(activities);
    }

    @DeleteMapping("/{ID}")
    public void deleteTaskbyID(@PathVariable("ID")Long id){
        activitiesservice.deleteTask(id);
    }

    @PutMapping ("/changeStatus/{ID}")
    public Boolean updateActivites(
            @PathVariable("ID") long ID,
            @RequestParam Boolean status){
        activitiesservice.updateActivities(status, ID);
            return status;
    }

}
