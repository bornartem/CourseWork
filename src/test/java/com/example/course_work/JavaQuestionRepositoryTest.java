package com.example.course_work;

import com.example.course_work.exception.QuestionAddedException;
import com.example.course_work.exception.QuestionNotFound;
import com.example.course_work.repository.JavaQuestionRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionRepositoryTest {
    private final JavaQuestionRepository tested = new JavaQuestionRepository();
    Question question = new Question("What's the motorcycle?", "It's the chopper");

    @Test
    public void shouldAddedQAToSet() {
        Question result = tested.addQuestion(question.getQuestion(), question.getAnswer());
        assertTrue(tested.getAll().contains(result));
        assertEquals(result, question);
    }

    @Test
    public void shouldThrowExceptionIfSetContainsSameAddedQA() {
        tested.addQuestion(question.getQuestion(), question.getAnswer());
        assertThrows(QuestionAddedException.class,
                () -> tested.addQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldFoundQAToSet() {
        Question result = tested.addQuestion(question.getQuestion(), question.getAnswer());
        tested.findQuestion(question.getQuestion(), question.getAnswer());
        assertTrue(tested.getAll().contains(result));
        assertEquals(result, question);
    }
    @Test
    public void shouldThrowExceptionIfQAIsAbsentInSet() {
        tested.addQuestion(question.getQuestion(), question.getAnswer());
        tested.removeQuestion(question.getQuestion(), question.getAnswer());
        assertThrows(QuestionNotFound.class,
                () -> tested.findQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldRemoveQAToSet() {
        Question result = tested.addQuestion(question.getQuestion(), question.getAnswer());
        tested.removeQuestion(question.getQuestion(), question.getAnswer());
        assertFalse(tested.getAll().contains(result));
        assertEquals(result, question);
    }
    @Test
    public void shouldThrowExceptionIfQANotRemoveInSet() {
        tested.addQuestion(question.getQuestion(), question.getAnswer());
        tested.removeQuestion(question.getQuestion(), question.getAnswer());
        assertThrows(QuestionNotFound.class,
                () -> tested.removeQuestion(question.getQuestion(), question.getAnswer()));
    }
}
