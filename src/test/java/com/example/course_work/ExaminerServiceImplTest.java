package com.example.course_work;

import com.example.course_work.exception.QuestionIndexOutOfBoundException;
import com.example.course_work.service.QuestionService;
import com.example.course_work.serviceImpl.ExaminerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    private QuestionService javaQuestionServiceMock;
    private QuestionService mathQuestionServiceMock;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void setup() {
        javaQuestionServiceMock = mock(QuestionService.class);
        mathQuestionServiceMock = mock(QuestionService.class);
        examinerService = new ExaminerServiceImpl(javaQuestionServiceMock, mathQuestionServiceMock);

    }

    private final Set<Question> questions = new HashSet<>(Set.of(
            new Question("What's the motorcycle?", "It's the chopper"),
            new Question("Whose chopper?", "It's Zed")
    ));
    private final Set<Question> questions1 = new HashSet<>(Set.of(
            new Question("5+5", "10"),
            new Question("1-1", "0")
    ));

    @Test
    public void shouldReturnQuestionsList() {
        Set<Question> javaQuestionServiceAll = javaQuestionServiceMock.getAll();
        when(javaQuestionServiceAll).thenReturn(questions);
        when(mathQuestionServiceMock.getAll()).thenReturn(questions1);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(new Question("1", "222333")).thenReturn(new Question("2", "21333"));
        when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(new Question("234", "2223546578333")).thenReturn(new Question("12", "1214445"));
        Collection<Question> result = examinerService.getQuestions(4);
        assertEquals(result.size(), 4);
    }

    @Test
    public void shouldReturnThrowQuestionIndexOutOfBoundException() {
        assertThrows(QuestionIndexOutOfBoundException.class,
                () -> examinerService.getQuestions(5));
        assertThrows(QuestionIndexOutOfBoundException.class,
                () -> examinerService.getQuestions(5));
    }
}
