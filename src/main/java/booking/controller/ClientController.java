package booking.controller;

import java.util.List;

import booking.dto.ClientDto;
import booking.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ClientController {
	
	@Autowired
	private BookingService bookingService;
	
	
	@RequestMapping("/booking/openClientList.do")
	public ModelAndView openClientList() throws Exception {
		ModelAndView mv = new ModelAndView("booking/clientlist");
		
		log.debug("------1111-------");
		List<ClientDto> list = bookingService.getAllClients();
		log.debug("------2222-------");
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/booking/clientSignUp.do")
	public String signUp() throws Exception {
		return "/booking/clientsignup";
	}
	
	@RequestMapping("/booking/insertClient.do")
	public String insertClient(ClientDto client) throws Exception {
		
		//log.debug("-------openInsert.do----");
		//log.debug(Integer.toString(board2.getNum()));
		//log.debug("-------openInsert.do----");

		bookingService.insertClient(client);
		return "redirect:/booking/openClientList.do";
	}
	
	@RequestMapping("/booking/updateClient.do")
	public String updateClient(ClientDto client) throws Exception {
		bookingService.updateClient(client);
		return "redirect:/booking/openClientList.do";
	}
	
	@RequestMapping("/booking/clientDetail.do")
	public ModelAndView clientDetail(@RequestParam int clientNo) throws Exception {
		ModelAndView mv = new ModelAndView("/booking/clientdetail");
		ClientDto client = bookingService.clientDetail(clientNo);
		mv.addObject("list", client);
		return mv;
	}
	
	@RequestMapping("/booking/deleteClient.do")
	public String deleteClient(@RequestParam int clientNo) throws Exception {
		bookingService.deleteClient(clientNo);
		return "redirect:/booking/openClientList.do";
	}
}