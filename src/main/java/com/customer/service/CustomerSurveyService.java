package com.customer.service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.customer.dto.QuestionnaireDTO;
import com.customer.factory.SurveyQuestionnaireFactory;

@Service
public class CustomerSurveyService {

	public static final Logger LOGGER = Logger.getLogger(CustomerSurveyService.class.getName());

	public List<QuestionnaireDTO> getQuestionnaireByCategoryId(int categoryId) {
		//we can read from DAO/YML/factory class
		//currently reading from factory class
		
		return SurveyQuestionnaireFactory.getQuestionnaireByCategoryId(categoryId);
	}

	public List<QuestionnaireDTO> getQuestionnaireByCategoryandQuestionId(int categoryId, int questionnaireId) {

		List<QuestionnaireDTO>  categoryQuestionnaireList = SurveyQuestionnaireFactory.getQuestionnaireByCategoryId(categoryId);
		categoryQuestionnaireList = categoryQuestionnaireList.stream().filter(obj -> (obj.getQuestionnaireId() == questionnaireId)).collect(Collectors.toList());
		return categoryQuestionnaireList;
	}

	public int saveQuestionnaireAnswers(QuestionnaireDTO saveQuestionnaireAnswers) {
		LOGGER.info("inside saveQuestionnaireAnswers for data "+saveQuestionnaireAnswers.toString());
		// validate and save logic 
		
	
		return 1;
	}

	public int updateQuestionnaireAnswers(QuestionnaireDTO questionnaireAnswers) {
        
		// validate and update answers 
		
	
		return 1;
	}

	public void deleteAnswers(int categoryId, int questionnaireId) {

		//delete answers for provided category, question id
	}

}
