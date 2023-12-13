package com.example.courseWork;

import com.example.courseWork.exception.QuestionIndexOutOfBoundException;
import com.example.courseWork.service.ExaminerService;
import com.example.courseWork.service.QuestionService;
import com.example.courseWork.serviceImpl.ExaminerServiceImpl;
import org.junit.jupiter.api.Assertions;
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
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl out;

    private final Set<Question> questions = new HashSet<>(List.of(
            new Question("What's the motorcycle?", "It's the chopper"),
            new Question("Whose chopper?", "It's Zed")
    ));

//    @Test
//    public void shouldReturnQuestionsList() {
//        when(questionServiceMock.getAll())
//                .thenReturn(questions);
//        Collection<Question> result = out.getQuestions(2);
//        assertNotEquals(questions, result);
//    }
    @Test
    public void shouldReturnThrowQuestionIndexOutOfBoundException(){
        when(questionServiceMock.getAll())
                .thenReturn(questions);
        assertThrows(QuestionIndexOutOfBoundException.class,
                () -> out.getQuestions(5));
    }
}
