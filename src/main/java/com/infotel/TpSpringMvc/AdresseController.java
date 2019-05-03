package com.infotel.TpSpringMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.TpSpringMvc.metier.Adresse;
import com.infotel.TpSpringMvc.service.Iservice;

@Controller
public class AdresseController {
	
	@Autowired
	private Iservice service;
	
	@RequestMapping(value = "/indexAdresse", method = RequestMethod.GET)
	public String lister(Model model) {
		model.addAttribute("adresse", new Adresse());
		model.addAttribute("adresses", service.findAllAdresse());
		return "adresses";

	}
	
	@RequestMapping(value = "/saveAdresse")
	public String save(Adresse adresse, Model model) {
		if (adresse.getIdAdresse() == 0) {
			service.ajouterAdresse(adresse);
			model.addAttribute("adresse", new Adresse());
			model.addAttribute("adresses", service.findAllAdresse());
			return "adresses";
		} else {
			service.modifierAdresse(adresse);
			model.addAttribute("adresse", new Adresse());
			model.addAttribute("adresses", service.findAllAdresse());
			return "adresses";
		}

	}
	
	@RequestMapping(value = "/deleteAdresse")
    public String delete(@RequestParam int idAdresse, Model model) {
        service.supprimerAdresse(idAdresse);
        model.addAttribute("adresse", new Adresse());
        model.addAttribute("adresses", service.findAllAdresse());
        return "adresses";
    }
    @RequestMapping(value = "/editAdresse")
    public String edit(@RequestParam int idAdresse, Model model) {
        model.addAttribute("adresse", service.getAdresse(idAdresse));
        model.addAttribute("adresses", service.findAllAdresse());
        return "adresses";
    }


}
