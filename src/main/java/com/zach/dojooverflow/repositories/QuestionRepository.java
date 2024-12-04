package com.zach.dojooverflow.repositories;

import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zach.dojooverflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{
	List<Question> findAll();
	
//	List<String> findAnswersContainsQuestion();
}
