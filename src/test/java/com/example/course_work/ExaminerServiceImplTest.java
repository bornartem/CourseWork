package com.example.course_work;

import com.example.course_work.exception.QuestionIndexOutOfBoundException;
import com.example.course_work.service.QuestionService;
import com.example.course_work.serviceImpl.ExaminerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
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
        examinerService = new ExaminerServiceImpl(List.of(javaQuestionServiceMock, mathQuestionServiceMock));
    }

    @Test
    public void shouldReturnQuestionsList() {
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(new Question("1", "222333")).thenReturn(new Question("2", "21333"));
        when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(new Question("234", "2223546578333")).thenReturn(new Question("12", "1214445"));
        Set<Question> result = examinerService.getQuestions(4);
        assertEquals(result.size(), 4);
    }
}
