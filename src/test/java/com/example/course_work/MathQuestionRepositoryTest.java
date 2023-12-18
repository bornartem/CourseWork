package com.example.course_work;

import com.example.course_work.exception.MathAddedException;
import com.example.course_work.exception.MathNotFound;
import com.example.course_work.repository.MathQuestionRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathQuestionRepositoryTest {
    private final MathQuestionRepository tested = new MathQuestionRepository();
    Question question = new Question("Whose chopper?", "It's Zed");
    @Test
    public void shouldAddedQAToSet() {
        Question result = tested.addQuestion(question.getQuestion(), question.getAnswer());
        assertTrue(tested.getAll().contains(result));
        assertEquals(result, question);
    }

    @Test
    public void shouldThrowExceptionIfSetContainsSameAddedQA() {
        tested.addQuestion(question.getQuestion(), question.getAnswer());
        assertThrows(MathAddedException.class,
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
        assertThrows(MathNotFound.class,
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
        assertThrows(MathNotFound.class,
                () -> tested.removeQuestion(question.getQuestion(), question.getAnswer()));
    }
}
