package mx.edu.uacm.mocks.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mx.edu.uacm.mocks.domain.Bug;
import mx.edu.uacm.mocks.service.BugService;

@Controller
public class BugController {

	Logger log = LogManager.getLogger(BugController.class);
	
	private BugService  bugService;
	
	public BugController(BugService bugService) {
		this.bugService = bugService;
	}
	
	@GetMapping("/bugs")
	public String list(Model model) {
		
		model.addAttribute("bugs", bugService.getBugs());
		
		/*Optional<Bug> bug = bugService.getById(1L);
		
		log.debug("Show this: " + bug);*/
		
		log.debug("LLego");
		
		return "bugs";
	}
}
