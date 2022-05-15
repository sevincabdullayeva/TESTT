package com.example.todolist.Activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ActivitiesService {
    @Autowired
    private final ActivityRepository  activityRepository;

    @Autowired
    public ActivitiesService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public void addActivities(Activities activities) {
            Optional<Activities>  activities1=activityRepository.
                    findActivitiesByTask(activities.getTask());
            if(activities1.isPresent()){
                throw new IllegalStateException(activities.getTask()+"has been taken today");
            }
            activityRepository.save(activities);
    }

    public List<Activities> getActivities() {
        return activityRepository.findAll();
    }


    public Optional<Activities> getActivitiesbyID(long id) {
     boolean excist=activityRepository.existsById(id);
     if(!excist){
         throw new IllegalStateException(id+"  ID  DOES NOT EXCIST!``");
     }
     return activityRepository.findActivitiesById(id);
    }

    public void deleteTask(Long id) {
        Boolean exist=activityRepository.existsById(id);
        if(!exist){
            throw  new IllegalStateException(id+" ID is not exist");
        }
        activityRepository.deleteById(id);
    }
    @Transactional
    public Boolean updateActivities(Boolean status, long id) {
        Boolean condition = activityRepository.getById(id).getStatus();
        activityRepository.getById(id).setStatus(status);
        return condition;
    }
}

