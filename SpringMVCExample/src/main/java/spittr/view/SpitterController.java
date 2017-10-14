package spittr.view;

import static org.springframework.web.bind.annotation.RequestMethod.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spittr.entity.Spitter;
import spittr.service.SpitterService;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
  @Autowired  
  private SpitterService spitterService;
  
  @RequestMapping(value="/register", method=GET)
  public String showRegistrationForm() {
    return "registerForm";
  }
  
  @RequestMapping(value="/register", method=POST)
  public String processRegistration(Spitter spitter) {
      
	Spitter newSpitter =  spitterService.save(spitter);
	if	(null != newSpitter) {
		return "redirect:/spitter/" + spitter.getUsername();
	}else {
	     return "registerForm";
	}
  }
  
  @RequestMapping(value="/{username}", method=GET)
  public String showSpitterProfile(@PathVariable String username, Model model) {
    Spitter spitter = spitterService.findByUsername(username);
    model.addAttribute(spitter);
    return "profile";
  }
  
}
