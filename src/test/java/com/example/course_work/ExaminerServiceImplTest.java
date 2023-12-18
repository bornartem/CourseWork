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
    private QuestionService javaQuestionServiceMock;
    @Mock
    private QuestionService mathQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

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
        when(javaQuestionServiceMock.getAll())
                .thenReturn(questions);
        when(mathQuestionServiceMock.getAll())
                .thenReturn(questions1);
        when(javaQuestionServiceMock.getRandomQuestion())
                .thenReturn(new Question("Who","I am"));
        when(mathQuestionServiceMock.getRandomQuestion())
                .thenReturn(new Question("1","222333"));
        Set<Question> result = examinerService.getQuestions(2);
        assertEquals(result.size(), 2);
    }

//    @Test
//    public void shouldReturnThrowQuestionIndexOutOfBoundException() {
//        when(questionServiceMock.getAll())
//                .thenReturn(questions);
//        assertThrows(QuestionIndexOutOfBoundException.class,
//                () -> examinerService.getQuestions(3));
//    }
}
