package org.example;

import jakarta.persistence.Embeddable;

@Embeddable    // we can embedded one class fields into another class table without creating another table
public class Certificate {
    private String course;
    private String duration;

    public Certificate(String course, String duration) {
        this.course = course;
        this.duration = duration;
    }

    public Certificate() {
        super();
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "course='" + course + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
