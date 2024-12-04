package com.zach.dojooverflow.controllers;

import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zach.dojooverflow.models.Answer;
import com.zach.dojooverflow.models.Question;
import com.zach.dojooverflow.models.Tag;
import com.zach.dojooverflow.services.OverflowService;

@Controller
public class OverflowController {
	
	private final OverflowService overflowService;
	
	public OverflowController(OverflowService overflowService) {
		this.overflowService = overflowService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Question> questions = overflowService.allQuestions();
		List<Tag> tags = overflowService.allTags();
		model.addAttribute("tags", tags);
		model.addAttribute("questions", questions);
		return "index.jsp";
	}
	
	@RequestMapping("/newQuestion")
	public String questionPage(Model model, @Valid @ModelAttribute("question") Question question, @Valid @ModelAttribute("tag") Tag tag) {
		model.addAttribute("question", question);
		model.addAttribute("tag", tag);
		return "newQuestion.jsp";
	}
	
	@RequestMapping(value = "/createQuestion", method = RequestMethod.POST)
	public String createQuestion(Model model, @RequestParam("body") String question, @RequestParam("tags") String tags,
			RedirectAttributes redirectAttributes) {
			List<String> qTags = Arrays.asList(tags.split(","));
			Question thisQuestion = overflowService.checkTag(qTags, question);
			return "redirect:/showQuestion/" + thisQuestion.getId();

	}
	
	@RequestMapping("/showQuestion/{id}")
	public String showQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer) {
		Question question = overflowService.findQuestion(id);
		List<Tag> tags = question.getTags();
		model.addAttribute("question", question);
		model.addAttribute("tags", tags);
		List<Answer> answers = question.getAnswers();
		model.addAttribute("answers", answers);
		return "showQuestion.jsp";
	}

	@RequestMapping(value = "/showQuestion/{id}", method = RequestMethod.POST)
	public String createAnswer(@PathVariable("id") Long id, @Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
		if(result.hasErrors()) {
			return "showQuestion.jsp";
		} else {
			Question question = overflowService.findQuestion(id);
			answer.setQuestion(question);
			overflowService.createAnswer(answer);
			return "redirect:/showQuestion/" + question.getId();
		}
	}
	
	
}
