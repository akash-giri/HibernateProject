package org.map;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;
//    @OneToOne
//    @JoinColumn(name = "ans_id")  // use to change the mapping column name
//    private Answer answer;
    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER)  // by default lazy loading set , we explicitly set Eager
    private List<Answer> answers;

//    public Question(int questionId, String question, Answer answer) {
//        this.questionId = questionId;
//        this.question = question;
//        this.answer = answer;
//    }

    public Question(int questionId, String question, List<Answer> answers) {
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


}
