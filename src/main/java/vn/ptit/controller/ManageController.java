package vn.ptit.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.ptit.entities.UserInfo;
import vn.ptit.repositories.DepartmentRepository;
import vn.ptit.repositories.TicketRepository;
import vn.ptit.repositories.UserInfoRepository;
import vn.ptit.services.TicketServices;

@Controller
public class ManageController {
	@Autowired TicketRepository ticketRepository;
	@Autowired DepartmentRepository departmentRepository;
	@Autowired TicketServices ticketServices;
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@RequestMapping(value = { "/manage-ticket" }, method = { RequestMethod.GET })
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		
		model.addAttribute("listTicket", ticketRepository.findAll());
		model.addAttribute("phongBans", departmentRepository.findAll());
		model.addAttribute("sizeListTicket", ticketRepository.findAll().size());

		return "manage_ticket";
	}
	
	@RequestMapping(value = { "/manage-department" }, method = { RequestMethod.GET })
	public String manageDepartment(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		
		model.addAttribute("listDe", departmentRepository.findAll());
		model.addAttribute("phongBans", departmentRepository.findAll());
		model.addAttribute("sizeListDe", departmentRepository.findAll().size());

		return "manage_department";
	}
	
	@RequestMapping(value = { "/login" }, method = { RequestMethod.GET })
	public String login(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {

		return "login";
	}
	
	@RequestMapping(value = { "/" }, method = { RequestMethod.GET })
	public String relogin(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		
		return "redirect:/manage-ticket";
	}
	
	@RequestMapping(value = { "/error-403" }, method = { RequestMethod.GET })
	public String error403(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		
		return "error_403";
	}

}
