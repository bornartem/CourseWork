package com.example.course_work;

import com.example.course_work.exception.QuestionAddedException;
import com.example.course_work.serviceImpl.JavaQuestionService;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private final JavaQuestionService out = new JavaQuestionService();
    Question question = new Question("What's the motorcycle?", "It's the chopper");
    Question question1 = new Question("Whose chopper?", "It's Zed");

    @Test
    public void shouldAddQAToSet() {
        Question result = out.addQuestion(question.getQuestion(), question.getAnswer());
        assertTrue(out.getAll().contains(result));
        assertEquals(question, result);
    }

    @Test
    public void shouldThrowExceptionWhenAddedSameQuestion() {
        out.addQuestion(question.getQuestion(), question.getAnswer());
        assertThrows(QuestionAddedException.class,
                () -> out.addQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldFindQAToSet() {
        Question result = out.addQuestion(question.getQuestion(), question.getAnswer());
        out.findQuestion(question.getQuestion(), question.getAnswer());
        assertTrue(out.getAll().contains(result));
        assertEquals(question, result);
    }

    @Test
    public void shouldRemoveQAToSet() {
        Question result = out.addQuestion(question.getQuestion(), question.getAnswer());
        out.removeQuestion(question.getQuestion(), question.getAnswer());
        assertFalse(out.getAll().contains(result));
        assertEquals(question, result);
    }

    @Test
    public void shouldReturnQAList() {
        out.addQuestion(question.getQuestion(), question.getAnswer());
        out.addQuestion(question1.getQuestion(), question1.getAnswer());
        Collection<Question> result = out.getAll();
        assertTrue(result.containsAll(List.of(question, question1)));
    }
}
