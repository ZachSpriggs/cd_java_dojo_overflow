package com.zach.dojooverflow.services;

import java.util.*;
import org.springframework.stereotype.Service;
import com.zach.dojooverflow.models.*;
import com.zach.dojooverflow.repositories.AnswerRepository;
import com.zach.dojooverflow.repositories.QTRepository;
import com.zach.dojooverflow.repositories.QuestionRepository;
import com.zach.dojooverflow.repositories.TagRepository;



@Service
public class OverflowService {

	private final QuestionRepository questionRepo;
	private final AnswerRepository answerRepo;
	private final TagRepository tagRepo;
	private final QTRepository qtRepo;
	
	public OverflowService(QuestionRepository questionRepo, AnswerRepository answerRepo, TagRepository tagRepo, QTRepository qtRepo) {
		this.questionRepo = questionRepo;
		this.answerRepo = answerRepo;
		this.tagRepo = tagRepo;
		this.qtRepo = qtRepo;
	}
	
	public List<Question> allQuestions(){
		return questionRepo.findAll();
	}
	
	public List<Answer> allAnswers(){
		return answerRepo.findAll();
	}
	
	public List<Tag> allTags(){
		return tagRepo.findAll();
	}
	
	public Question createQuestion(Question question) {
		return questionRepo.save(question);
	}
	
	public Answer createAnswer(Answer answer) {
		return answerRepo.save(answer);
	}
	
	public Tag createTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public QuestionTag createQT(QuestionTag qt) {
		return qtRepo.save(qt);
	}
	
	public String findThisTag(String body) {
		return tagRepo.findByContentIgnoreCase(body);
	}
	
	
	public Question findQuestion(Long id) {
		Optional<Question> optionalQuestion = questionRepo.findById(id);
		if(optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}
	
	
	
	public Question checkTag(List<String> tags, String question) {
		Question thisQuestion = new Question();
		thisQuestion.setBody(question);
		createQuestion(thisQuestion);
		for(String tagCheck: tags) {
			if(findThisTag(tagCheck) != null) {
				QuestionTag newTag = new QuestionTag();
				newTag.setTags(findThisTag(tagCheck));
				newTag.setQuestion(question);
				createQT(newTag);
			} else {
				Tag newTag = new Tag();
				newTag.setContent(tagCheck);
				createTag(newTag);
				List<Tag> newList = new ArrayList<>();
				newList.add(createTag(newTag));
				thisQuestion.setTag(newList);
			}
		}
		return thisQuestion;
	}
	
	public void deleteTag(Long id) {
		tagRepo.deleteById(id);
	}
	
	
	
	
}
