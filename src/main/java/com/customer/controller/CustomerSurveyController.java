package com.customer.controller;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.dto.QuestionnaireDTO;
import com.customer.service.CustomerSurveyService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/customer/survey/questionnaire")
public class CustomerSurveyController {

	public static final Logger LOGGER = Logger.getLogger(CustomerSurveyController.class.getName());

	@Autowired
	CustomerSurveyService customerSurveyService;

	/**
	 * This method return home page of survey rest api
	 * @return
	 */
	@ApiOperation(value = "/", nickname = "homePage")
	@GetMapping(value = "/")
	public String homePage() {
		return "welcome to Customer Survey rest application api.";
	}

	/**
	 * This service method will fetch questionnaire details for provided category ID
	 * @param categoryId
	 * @return
	 */
	@ApiOperation(value = "/details/{getQuestionnaireByCategoryId}", nickname = "getQuestionnaireByCategoryId")
	@GetMapping(value = "/details/{questionnaireCategoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<QuestionnaireDTO> getQuestionnaireByCategoryId(
			@PathVariable("questionnaireCategoryId") int categoryId) {
		LOGGER.info("inside getQuestionnaireByCategoryId for category -" + categoryId);

		return customerSurveyService.getQuestionnaireByCategoryId(categoryId);

	}

	/**
	 * This service method will fetch questionnaire details for provided category ID, question ID
	 * @param categoryId
	 * @param questionnaireId
	 * @return
	 */
	@ApiOperation(value = "/details/{getQuestionnaireByCategoryId}/{questionnaireId}", nickname = "getQuestionnaireByCategoryAndQuestionnaireId")
	@GetMapping(value = "/details/{questionnaireCategoryId}/{questionnaireId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<QuestionnaireDTO> getQuestionnaireByCategoryAndQuestionnaireId(
			@PathVariable("questionnaireCategoryId") int categoryId,
			@PathVariable("questionnaireId") int questionnaireId) {
		LOGGER.info("inside getQuestionnaireByCategoryAndQuestionnaireId for category -" + categoryId + " questionId -"
				+ questionnaireId);

		return customerSurveyService.getQuestionnaireByCategoryandQuestionId(categoryId, questionnaireId);

	}
	
	/**
	 * This method will save provided questionnaire answers
	 * @param saveQuestionnaireAnswers
	 * @return
	 */
	@ApiOperation(value = "/save", nickname = "save")
	@PostMapping(value = "/save", consumes= MediaType.APPLICATION_JSON_VALUE)
	public String saveQuestionnaireAnswers(@RequestBody QuestionnaireDTO saveQuestionnaireAnswers) {
		LOGGER.info("inside saveQuestionnaireAnswers" );

		
		if(Objects.nonNull(saveQuestionnaireAnswers)){

			customerSurveyService.saveQuestionnaireAnswers(saveQuestionnaireAnswers);

		} else{
			return "No data provided.";
		
		}
		
		return "Answers saved successfully.";

	}
	
	/**
	 * This method will update provided questionnaire answers
	 * @param questionnaireAnswers
	 * @return
	 */
	@ApiOperation(value = "/update", nickname = "update")
	@PutMapping(value = "/update", consumes= MediaType.APPLICATION_JSON_VALUE)
	public String updateQuestionnaireAnswers(@RequestBody QuestionnaireDTO questionnaireAnswers) {
		LOGGER.info("inside updateQuestionnaireAnswers" );

		if(Objects.nonNull(questionnaireAnswers)){

			customerSurveyService.updateQuestionnaireAnswers(questionnaireAnswers);

		} else{
			return "No data provided.";
		
		}
		
		return "Answers updated successfully.";

	}
	
	/**
	 * This method will delete provided questionnaire answers
	 * @param categoryId
	 * @param questionnaireId
	 * @return
	 */
	@ApiOperation(value = "/delete", nickname = "delete")
	@DeleteMapping(value = "/delete/{questionnaireCategoryId}/{questionnaireId}")
	public String deleteQuestionnaireAnswers(
			@PathVariable("questionnaireCategoryId") int categoryId,
			@PathVariable("questionnaireId") int questionnaireId) {
		LOGGER.info("inside updateQuestionnaireAnswers" );

		if(categoryId > 0 && questionnaireId > 0){

			customerSurveyService.deleteAnswers(categoryId, questionnaireId);

		} else{
			return "No data provided.";
		
		}
		
		return "Answers deleted successfully.";

	}

}
