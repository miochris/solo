package com.fdmgroup.market.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.market.dao.AddressDAO;
import com.fdmgroup.market.dao.MemberDAO;
import com.fdmgroup.market.entity.Address;
import com.fdmgroup.market.entity.Fighter;
import com.fdmgroup.market.entity.Member;

@Controller
public class AdminController {
	public static final Logger LOG = Logger.getLogger(AdminController.class);
	@Autowired
	MemberDAO daoM;
	@Autowired
	AddressDAO daoA;

	public AdminController(MemberDAO daoM, AddressDAO daoA) {
		this.daoM = daoM;
		this.daoA = daoA;

	}
	

	public AdminController() {
	}


	/**
	 * Go to Home Page when logging in
	 * 
	 * @return
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToIndex() {
		return "index";
	}

	/**
	 * Back to Home Page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goToIndex2() {
		return "index";
	}

	/**
	 * Go to Admin's home page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/AdminHome", method = RequestMethod.GET)
	public String goToAdminHome() {
		return "admin/AdminHome";
	}

	/**
	 * Grep user's name when logging in
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/adminLogin", method = RequestMethod.GET)
	public String grepLoginName(HttpServletRequest request) {
		String userName = request.getUserPrincipal().getName();
		request.getSession().setAttribute("userName", userName);
		LOG.info(userName);
		return "admin/AdminHome"; 
	}

	/**
	 * Go to registration page to fill in the new member's details
	 * 
	 * @param model
	 * @param member
	 * @param address
	 * @return
	 */
	@RequestMapping(value = "/admin/adminAddMember", method = RequestMethod.GET)
	public String goToRegistrationPage(Model model, Member member,
			Address address) {
		address = new Address();
		member = new Member();
		member.setAddress(address);
		model.addAttribute("member", new Member());
		model.addAttribute("address", new Address());
		return "admin/AddNewMember";
	}

	/**
	 * add a new member
	 * 
	 * @param model
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/admin/adminAddMember", method = RequestMethod.POST)
	public String adminAddMember(Model model, Member member) {
		daoM.addNewMember(member);
		return "admin/memberAdded";
	}

	/**
	 * show all member's information
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/admin/AllMemberList", method = RequestMethod.GET)
	public String showAllMemmbers(HttpServletRequest request) {
		List<Member> memberList = daoM.showAllMembers();
		request.getSession().setAttribute("memberList", memberList);
		return "admin/memberList";
	}

	/**
	 * Show all fighters
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/AllFighterList", method = RequestMethod.GET)
	public String showAllFighters(HttpServletRequest request) {
		List<Fighter> AllFighterList = daoM.listAllFighters();
		request.getSession().setAttribute("fighterList", AllFighterList);
		return "admin/FighterList";
	}

	/**
	 * Show all fighters in London
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/FightersInLondon", method = RequestMethod.GET)
	public String showAllFightersInLondon(HttpServletRequest request) {
		List<Fighter> AllfighersInOneCity = daoM.FightersInOneCity("London");
		request.getSession().setAttribute("AllfighersInOneCity",
				AllfighersInOneCity);
		return "admin/fightersInOneCity";
	}

	/**
	 * Show all fighters in NY
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/FightersInNY", method = RequestMethod.GET)
	public String showAllFightersInNY(HttpServletRequest request) {
		// request.getSession().invalidate();
		List<Fighter> AllfighersInOneCity = daoM.FightersInOneCity("NY");
		request.getSession().setAttribute("AllfighersInOneCity",
				AllfighersInOneCity);
		return "admin/fightersInOneCity";
	}

	/**
	 * Show all fighters in TOKYO
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/FightersInTOKYO", method = RequestMethod.GET)
	public String showAllFightersInTOKYO(HttpServletRequest request) {
		List<Fighter> AllfighersInOneCity = daoM.FightersInOneCity("TOKYO");
		request.getSession().setAttribute("AllfighersInOneCity",
				AllfighersInOneCity);
		return "admin/fightersInOneCity";
	}

	/**
	 * Show a member's all fighters choose the member's id
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/OneMemberFighter", method = RequestMethod.GET)
	public String chooseMemberId(HttpServletRequest request, Model model,
			Member member) {

		List<Integer> memberListNum = daoM.showAllMembersID();
		request.getSession().setAttribute("memberListNum", memberListNum);
		return "admin/memberId";
	}

	@RequestMapping(value = "/admin/OneMemberFighter", method = RequestMethod.POST)
	public String showOneMembersFighters(HttpServletRequest request,
			Model model, Member member, @RequestParam String id) {

		member = daoM.getMemberById(Integer.parseInt(id));
		List<Fighter> OneMembersFighterList = daoM
				.listAllFightersofOneMember(id);
		request.getSession().setAttribute("OneMembersFighterList",
				OneMembersFighterList);
		request.getSession().setAttribute("member", member);
		return "admin/OneMembersFighterList";
	}

	/**
	 * Log out from admin
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/Logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

}
