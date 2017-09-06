package com.customer.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class QuestionnaireDTO {
	
	private int categoryId;
	
	private int questionnaireId;
	
	private String questionnarieTypeCode;
	
	private List<String> answersList;
	
	private List<QuestionnaireDTO> subQuestionnaireList;
	
	private List<String> questionnarieOptionsList;
	
	private String questionDesc;
	
	private String categoryDesc;
	
	public QuestionnaireDTO(){
		
	}

	public QuestionnaireDTO(int categoryId, int questionnaireId, String questionnarieTypeCode,List<String> questionnarieOptionsList,  List<String> answersList,
			List<QuestionnaireDTO> subQuestionnaireList,String categoryDesc,String questionDesc) {
		super();
		this.categoryId = categoryId;
		this.questionnaireId = questionnaireId;
		this.questionnarieTypeCode = questionnarieTypeCode;
		this.questionnarieOptionsList = questionnarieOptionsList;
		this.answersList = answersList;
		this.subQuestionnaireList = subQuestionnaireList;
		this.categoryDesc=categoryDesc;
		this.questionDesc = questionDesc;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getQuestionnarieTypeCode() {
		return questionnarieTypeCode;
	}

	public void setQuestionnarieTypeCode(String questionnarieTypeCode) {
		this.questionnarieTypeCode = questionnarieTypeCode;
	}

	public List<String> getAnswersList() {
		return answersList;
	}

	public void setAnswersList(List<String> answersList) {
		this.answersList = answersList;
	}

	public List<QuestionnaireDTO> getSubQuestionnaireList() {
		return subQuestionnaireList;
	}

	public void setSubQuestionnaireList(List<QuestionnaireDTO> subQuestionnaireList) {
		this.subQuestionnaireList = subQuestionnaireList;
	}

	public List<String> getQuestionnarieOptionsList() {
		return questionnarieOptionsList;
	}

	public void setQuestionnarieOptionsList(List<String> questionnarieOptionsList) {
		this.questionnarieOptionsList = questionnarieOptionsList;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	@Override
	public String toString() {
		return "QuestionnaireDTO [categoryId=" + categoryId + ", questionnaireId=" + questionnaireId
				+ ", questionnarieTypeCode=" + questionnarieTypeCode + ", answersList=" + answersList
				+ ", subQuestionnaireList=" + subQuestionnaireList + ", questionnarieOptionsList="
				+ questionnarieOptionsList + ", questionDesc=" + questionDesc + ", categoryDesc=" + categoryDesc + "]";
	}
	
	

}
