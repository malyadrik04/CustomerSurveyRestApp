package com.customer.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.customer.dto.QuestionnaireDTO;

public class SurveyQuestionnaireFactory {
	
	public static final List<QuestionnaireDTO> qusetionnarieList = new ArrayList<QuestionnaireDTO>(){
		{
			add(new QuestionnaireDTO(1, 1, "RADIO",  Arrays.asList("Yes","No"),Arrays.asList("Y"), null,"customer care","Have you ever contacted customer service?"));
			add(new QuestionnaireDTO(1, 2, "options",  Arrays.asList("Excellent","Good","Moderate","Poor"),Arrays.asList("Good","Moderate"), null,"customer care","How you rate this product?"));
			add(new QuestionnaireDTO(1, 3, "text", null, Arrays.asList("will suggest"), null,"customer care","would you recommend this product to a friend?"));
		}
	};
	
	public static final Map<Integer, List<QuestionnaireDTO>> questionnarieByCategoryMap = new HashMap<Integer, List<QuestionnaireDTO> >(){

		{
			
			put(1, qusetionnarieList);
		}
	};
	

	public static List<QuestionnaireDTO> getQuestionnaireByCategoryId(int categoryId) {

		return questionnarieByCategoryMap.get(categoryId);
	}

	
}
