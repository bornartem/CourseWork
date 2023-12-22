//package com.example.course_work.repository;
//
//import com.example.course_work.Question;
//import com.example.course_work.exception.MathAddedException;
//import com.example.course_work.exception.MathNotFound;
//import com.example.course_work.service.QuestionRepository;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository
//public class MathQuestionRepository implements QuestionRepository {
//    private Set<Question> questions;
//
//    @PostConstruct
//    public void init() {
//        questions = new HashSet<>(Set.of(
//                new Question("2+2", "4"),
//                new Question("10-5", "5"),
//                new Question("4*4", "16"),
//                new Question("100/5", "20"),
//                new Question("7+3-5", "5"),
//                new Question("10-10", "0")
//        ));
//    }
//
//    @Override
//    public Question addQuestion(String question, String answer) {
//        Question math = new Question(question, answer);
//        if (!questions.add(math)) {
//            throw new MathAddedException();
//        }
//        return math;
//    }
//
//    @Override
//    public Question findQuestion(String question, String answer) {
//        Question math = new Question(question, answer);
//        if (questions.contains(math)) {
//            return math;
//        }
//        throw new MathNotFound();
//    }
//
//    @Override
//    public Question removeQuestion(String question, String answer) {
//        Question math = new Question(question, answer);
//        if (questions.contains(math)) {
//            questions.remove(math);
//            return math;
//        }
//        throw new MathNotFound();
//    }
//
//    @Override
//    public Set<Question> getAll() {
//        return questions;
//    }
//}
