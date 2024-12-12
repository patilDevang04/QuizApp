package com.devang.quiz_service.service;

import com.devang.quiz_service.dao.QuizDao;
import com.devang.quiz_service.feignClient.QuestionClient;
import com.devang.quiz_service.model.QuestionWrapper;
import com.devang.quiz_service.model.Quiz;
import com.devang.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionClient questionClient;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions = questionClient.getQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz =  quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions;
        questions = questionClient.getQuestionsFromId(questionIds);
        return questions;

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score;
        score = questionClient.getScore(responses);
        return score;
    }
}