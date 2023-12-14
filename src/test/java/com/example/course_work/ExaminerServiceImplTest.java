package com.example.course_work;

import com.example.course_work.exception.QuestionIndexOutOfBoundException;
import com.example.course_work.service.QuestionService;
import com.example.course_work.serviceImpl.ExaminerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final Set<Question> questions = new HashSet<>(Set.of(
            new Question("What's the motorcycle?", "It's the chopper"),
            new Question("Whose chopper?", "It's Zed")
    ));

    @Test
    public void shouldReturnQuestionsList() {
        when(questionServiceMock.getAll())
                .thenReturn(questions);
        when(questionServiceMock.getRandomQuestion())
                .thenReturn(new Question("1","222333"));
        Collection<Question> result = examinerService.getQuestions(1);
        assertEquals(result.size(), 1);
    }

    @Test
    public void shouldReturnThrowQuestionIndexOutOfBoundException() {
        when(questionServiceMock.getAll())
                .thenReturn(questions);
        assertThrows(QuestionIndexOutOfBoundException.class,
                () -> examinerService.getQuestions(3));
    }
}
