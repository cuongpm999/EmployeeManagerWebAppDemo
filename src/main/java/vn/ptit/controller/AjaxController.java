package vn.ptit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.AjaxResponse;
import vn.ptit.entities.Department;
import vn.ptit.entities.Ticket;
import vn.ptit.repositories.DepartmentRepository;
import vn.ptit.repositories.TicketRepository;
import vn.ptit.services.DepartmentServices;
import vn.ptit.services.TicketServices;
import vn.ptit.ultils.DepartmentDisplay;
import vn.ptit.ultils.ListDepartmentAndSize;
import vn.ptit.ultils.ListTicketAndSizeDisplay;
import vn.ptit.ultils.TicketDisplay;

@RestController
@RequestMapping("/rest/api")
public class AjaxController {
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	TicketServices ticketServices;
	@Autowired
	DepartmentServices departmentServices;

	@PostMapping(value = "/add-ticket")
	public ResponseEntity<AjaxResponse> addTicket(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		String clientName = (String) data.get("clientName");
		String clientMobile = (String) data.get("clientMobile");
		String clientContent = (String) data.get("clientContent");
		String idPhongBan = (String) data.get("idPhongBan");

		Ticket ticket = new Ticket();
		ticket.setNameClient(clientName);
		ticket.setMobileClient(clientMobile);
		ticket.setTimeAccept(new Date());
		ticket.setContentOfClient(clientContent);
		ticket.setDepartment(departmentRepository.getOne(Integer.parseInt(idPhongBan)));
		ticket.setStatus(false);

		ticketRepository.save(ticket);
		List<Ticket> list = ticketRepository.findAll();

		return ResponseEntity.ok(new AjaxResponse(69, getToDisplay(list)));
	}

	public ListTicketAndSizeDisplay getToDisplay(List<Ticket> list) {
		List<TicketDisplay> list2 = new ArrayList<>();
		for (Ticket ticket : list) {
			list2.add(new TicketDisplay(ticket.getId(), ticket.getDepartment().getName(), ticket.getMobileClient(),
					ticket.getContentOfClient(), ticket.getTimeAccept(), ticket.getContentReply(), ticket.getStatus(),
					ticket.getTimeReply()));
		}

		return new ListTicketAndSizeDisplay(list2.size(), list2);
	}

	@PostMapping(value = "/search-ticket")
	public ResponseEntity<AjaxResponse> searchTicket(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String inputTypeSearch = (String) data.get("inputTypeSearch");

		Date from = null, to = null;
		if (!data.get("from").toString().isEmpty() && !data.get("to").toString().isEmpty()) {
			try {
				from = sdf.parse(data.get("from").toString());
				to = sdf.parse(data.get("to").toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		List<Ticket> list = ticketServices.searchByType(inputTypeSearch, from, to);

		return ResponseEntity.ok(new AjaxResponse(169, getToDisplay(list)));
	}
	
	@PostMapping(value = "/search-ticket-by-idDe")
	public ResponseEntity<AjaxResponse> searchTicketByIdDe(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		List<Ticket> list = ticketServices.searchByIdDepartment(Integer.parseInt(data.get("id").toString()));
		return ResponseEntity.ok(new AjaxResponse(269, getToDisplay(list)));
	}
	
	@PostMapping(value = "/search-department-by-id")
	public ResponseEntity<AjaxResponse> searchDeById(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		List<Department> list = departmentServices.searchByIdDepartment(Integer.parseInt(data.get("id").toString()));
		return ResponseEntity.ok(new AjaxResponse(369, getToDisplay1(list)));
	}
	
	@PostMapping(value = "/search-department-by-name")
	public ResponseEntity<AjaxResponse> searchDeByName(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		List<Department> list = departmentServices.searchByName(data.get("input").toString());
		return ResponseEntity.ok(new AjaxResponse(469, getToDisplay1(list)));
	}
	
	public ListDepartmentAndSize getToDisplay1(List<Department> list) {
		List<DepartmentDisplay> list2 = new ArrayList<>();
		for (Department department : list) {
			list2.add(new DepartmentDisplay(department.getId(),department.getName(),department.getDateCreate()));
		}

		return new ListDepartmentAndSize(list2.size(), list2);
	}
	
	@PostMapping(value = "/add-department")
	public ResponseEntity<AjaxResponse> addDepartment(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		String nameDe = (String) data.get("nameDe");

		Department department = new Department();
		department.setName(nameDe);
		department.setDateCreate(new Date());

		departmentRepository.save(department);
		
		List<Department> list = departmentRepository.findAll();
		
		return ResponseEntity.ok(new AjaxResponse(569, getToDisplay1(list)));
	}
	
	@PostMapping(value = "/get-to-edit-department")
	public ResponseEntity<AjaxResponse> getValueToEdit(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		Department department = departmentRepository.findById(Integer.parseInt(data.get("deId").toString())).get();
		DepartmentDisplay departmentDisplay = new DepartmentDisplay(department.getId(),department.getName(),department.getDateCreate());
		return ResponseEntity.ok(new AjaxResponse(669, departmentDisplay));
	}
	
	@PutMapping(value = "/edit-department")
	public ResponseEntity<AjaxResponse> editDepartment(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		String nameDe = (String) data.get("nameDe");
		Department department = departmentRepository.findById(Integer.parseInt(data.get("deId").toString())).get();
		department.setName(nameDe);

		departmentRepository.save(department);
		
		List<Department> list = departmentRepository.findAll();
		
		return ResponseEntity.ok(new AjaxResponse(769, getToDisplay1(list)));
	}
	
	@DeleteMapping(value = "/delete-department")
	public ResponseEntity<AjaxResponse> deletetDepartment(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		departmentRepository.deleteById(Integer.parseInt(data.get("id").toString()));
		
		List<Department> list = departmentRepository.findAll();
		
		return ResponseEntity.ok(new AjaxResponse(869, getToDisplay1(list)));
	}


}
