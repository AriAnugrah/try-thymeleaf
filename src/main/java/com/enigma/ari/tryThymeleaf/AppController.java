package com.enigma.ari.tryThymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
	
	@Autowired
	private EmployeesDao dao;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Employeess> listEmployeess = dao.list();
		model.addAttribute("listEmployeess", listEmployeess);
	    return "index";
	}
	
	@RequestMapping("/new")
	public String showNewForm(Model model) {
	    Employeess employeess = new Employeess();
	    model.addAttribute("employeess", employeess);
	     
	    return "new_form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("employeess") Employeess employeess) {
	    dao.save(employeess);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_form");
	    Employeess employeess = dao.get(id);
	    mav.addObject("employeess", employeess);
	     
	    return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("employeess") Employeess employeess) {
	    dao.update(employeess);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int id) {
	    dao.delete(id);
	    return "redirect:/";       
	}	
}
