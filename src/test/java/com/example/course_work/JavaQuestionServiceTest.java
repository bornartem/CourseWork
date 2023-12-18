package com.example.course_work;

import com.example.course_work.exception.MathAddedException;
import com.example.course_work.exception.QuestionAddedException;
import com.example.course_work.exception.QuestionNotFound;
import com.example.course_work.repository.JavaQuestionRepository;
import com.example.course_work.serviceImpl.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepositoryMock;
    @InjectMocks
    private JavaQuestionService javaQuestionService;
    private final Set<Question> questions = new HashSet<>(Set.of(
            new Question("What's the motorcycle?", "It's the chopper"),
            new Question("Whose chopper?", "It's Zed")
    ));
    Question question = new Question("What's the motorcycle?", "It's the chopper");

    @Test
    public void shouldAddQAToSet() {
        when(javaQuestionRepositoryMock.addQuestion(question.getQuestion(), question.getAnswer()))
                .thenReturn(question);
        assertEquals(question, javaQuestionService.addQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldThrowExceptionIfQAContainsInSet() {
        when(javaQuestionRepositoryMock.addQuestion(question.getQuestion(), question.getAnswer()))
                .thenThrow(QuestionAddedException.class);
        assertThrows(QuestionAddedException.class,
                () -> javaQuestionService.addQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldFindQAToSet() {
        when(javaQuestionRepositoryMock.findQuestion(question.getQuestion(), question.getAnswer()))
                .thenReturn(question);
        assertEquals(question, javaQuestionService.findQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldThrowExceptionIfQANotFoundInSet() {
        when(javaQuestionRepositoryMock.findQuestion(question.getQuestion(), question.getAnswer()))
                .thenThrow(QuestionNotFound.class);
        assertThrows(QuestionNotFound.class,
                () -> javaQuestionService.findQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldRemoveQAToSet() {
        when(javaQuestionRepositoryMock.removeQuestion(question.getQuestion(), question.getAnswer()))
                .thenReturn(question);
        assertEquals(question, javaQuestionService.removeQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldThrowExceptionIfQANotRemovedInSet() {
        when(javaQuestionRepositoryMock.removeQuestion(question.getQuestion(), question.getAnswer()))
                .thenThrow(QuestionNotFound.class);
        assertThrows(QuestionNotFound.class,
                () -> javaQuestionService.removeQuestion(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void shouldReturnSet() {
        when(javaQuestionRepositoryMock.getAll())
                .thenReturn(questions);
        Set<Question> result = javaQuestionService.getAll();
        assertTrue(questions.containsAll(result));
    }
}
