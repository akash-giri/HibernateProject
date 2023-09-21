package org.map1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Project {
    @Id
    private int pid;
    @Column(name = "project_name")
    private String projectName;
    @ManyToMany(mappedBy = "projects")
    private List<Emp> emps;

    public Project(int pid, String projectName) {
        this.pid = pid;
        this.projectName = projectName;
    }

    public Project() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}
