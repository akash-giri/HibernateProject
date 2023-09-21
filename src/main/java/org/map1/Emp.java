package org.map1;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Emp {
    @Id
    private int eid;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "emp_learn",
            joinColumns = {@JoinColumn(name = "eid")},
            inverseJoinColumns = {@JoinColumn(name = "pid")}
    )
    private List<Project> projects;

    public Emp(int eid, String name, List<Project> projects) {
        this.eid = eid;
        this.name = name;
        this.projects = projects;
    }

    public Emp() {
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
