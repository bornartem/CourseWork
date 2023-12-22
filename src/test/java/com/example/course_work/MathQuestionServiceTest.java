package com.example.course_work;

import com.example.course_work.exception.MathAddedException;
import com.example.course_work.repository.MathQuestionRepository;
import com.example.course_work.serviceImpl.MathQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Mock
    private MathQuestionRepository mathQuestionRepositoryMock;
    @InjectMocks
    private MathQuestionService mathQuestionService;

    private final Set<Question> questions = new HashSet<>(Set.of(
            new Question("What's the motorcycle?", "It's the chopper"),
            new Question("Whose chopper?", "It's Zed")
    ));
    Question question = new Question("5+5", "10");

    @Test
    public void shouldAddQAToSet() {
        when(mathQuestionRepositoryMock.addQuestion(question.getQuestion(), question.getAnswer()))
                .thenReturn(question);
        assertEquals(question, mathQuestionService.addQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldThrowExceptionIfQAContainsInSet() {
        when(mathQuestionRepositoryMock.addQuestion(question.getQuestion(), question.getAnswer()))
                .thenThrow(MathAddedException.class);
        assertThrows(MathAddedException.class,
                () -> mathQuestionService.addQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldFindQAToSet() {
        when(mathQuestionRepositoryMock.findQuestion(question.getQuestion(), question.getAnswer()))
                .thenReturn(question);
        assertEquals(question, mathQuestionService.findQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldThrowExceptionIfQANotFoundInSet() {
        when(mathQuestionRepositoryMock.findQuestion(question.getQuestion(), question.getAnswer()))
                .thenThrow(MathAddedException.class);
        assertThrows(MathAddedException.class,
                () -> mathQuestionService.findQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldRemoveQAToSet() {
        when(mathQuestionRepositoryMock.removeQuestion(question.getQuestion(), question.getAnswer()))
                .thenReturn(question);
        assertEquals(question, mathQuestionService.removeQuestion(question.getQuestion(), question.getAnswer()));
    }
    @Test
    public void shouldThrowExceptionIfQANotRemovedInSet(){
        when(mathQuestionRepositoryMock.removeQuestion(question.getQuestion(), question.getAnswer()))
                .thenThrow(MathAddedException.class);
        assertThrows(MathAddedException.class,
                () -> mathQuestionService.removeQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldReturnSet() {
        when(mathQuestionRepositoryMock.getAll())
                .thenReturn(questions);
        Set<Question> result = mathQuestionService.getAll();
        assertTrue(questions.containsAll(result));
    }
}
