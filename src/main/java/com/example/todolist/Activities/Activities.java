package com.example.todolist.Activities;

import javax.persistence.*;

@Entity
public class Activities {
    @Id
    @SequenceGenerator(
            name="sequence_activity",
             sequenceName = "sequence_activity",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_activity"
    )
    private long id;
    @Column(
            name="task",
            nullable = false,
            columnDefinition = "TEXT"
        ///    unique = true
    )
  private String task;

    @Column(
            name="status",
            nullable = false
    )
  private boolean status=false;

    public Activities() {

    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public Activities( String task, Boolean status) {
        this.task = task;
        this.status = status;
    }

//    @Override
//    public String toString() {
//        return "Activities{" +
//                "id=" + id +
//                ", healthdiet='" + healthdiet + '\'' +
//                ", selfimprovament='" + selfimprovament + '\'' +
//
//                '}';
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Activities{" +
                ", task='" + task + '\'' +
                ", selfimprovament='" + status + '\'' +
                '}';
    }

}
