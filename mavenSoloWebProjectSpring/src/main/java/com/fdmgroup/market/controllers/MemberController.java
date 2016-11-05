package com.fdmgroup.market.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.market.dao.AddressDAO;
import com.fdmgroup.market.dao.FighterDAO;
import com.fdmgroup.market.dao.MemberDAO;
import com.fdmgroup.market.entity.Cat;
import com.fdmgroup.market.entity.Dog;
import com.fdmgroup.market.entity.Fighter;
import com.fdmgroup.market.entity.Member;
import com.fdmgroup.market.enums.City;

@Controller
public class MemberController {
	public static final Logger LOG = Logger.getLogger(MemberController.class);

	@Autowired
	MemberDAO daoM;
	@Autowired
	AddressDAO daoA;
	@Autowired
	FighterDAO daoF;

	public MemberController() {
	}

	public MemberController(MemberDAO daoM, AddressDAO daoA) {
		this.daoM = daoM;
		this.daoA = daoA;

	}

	@RequestMapping(value = "/member/MemberHome", method = RequestMethod.GET)
	public String goToAdminHome() {

		return "member/MemberHome";

	}

	// Log in and grep member's name
	@RequestMapping(value = "/member/memberLogin", method = RequestMethod.GET)
	public String grepLoginName(HttpServletRequest request) {
		String userName = request.getUserPrincipal().getName();
		request.getSession().setAttribute("userName", userName);
		Member memberLoggedIn = daoM.getMemberByName(userName);
		LOG.info(memberLoggedIn);
		request.getSession().setAttribute("memberLoggedIn", memberLoggedIn);
		LOG.info(userName);

		return "member/MemberHome";
	}

	// show your fighter list
	@RequestMapping(value = "/member/AllFighterList", method = RequestMethod.GET)
	public String showAllFighters(HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute(
				"memberLoggedIn");
		LOG.info(member);
		List<Fighter> OneMembersFighterList = new ArrayList<Fighter>();
		OneMembersFighterList = daoM.listAllFightersofOneMember(String
				.valueOf(member.getId()));
		request.getSession().setAttribute("OneMembersFighterList",
				OneMembersFighterList);

		return "member/OwnFighterList";
	}

	// add fighter
	@RequestMapping(value = "/member/AddFighterCat", method = RequestMethod.GET)
	public String addFighterCat(HttpServletRequest request, Model model, Cat cat) {
		LOG.info(cat);
		cat = new Cat();
		model.addAttribute("cat", cat);
		LOG.info(cat);

		return "member/AddNewFighterCat";

	}

	@RequestMapping(value = "/member/AddFighterCat", method = RequestMethod.POST)
	public String fighterCatAdded(HttpServletRequest request, Model model,
			Cat cat) {
		daoF.addCat(cat);
		daoM.addFighterToNewMember(cat, (Member) request.getSession()
				.getAttribute("memberLoggedIn"));
		return "member/MemberHome";

	}

	@RequestMapping(value = "/member/AddFighterDog", method = RequestMethod.GET)
	public String addFighterDog(HttpServletRequest request, Model model, Dog dog) {

		dog = new Dog();
		model.addAttribute("dog", dog);

		return "member/AddNewFighterDog";

	}

	@RequestMapping(value = "/member/AddFighterDog", method = RequestMethod.POST)
	public String fighterDogAdded(HttpServletRequest request, Model model,
			Dog dog) {
		daoF.addDog(dog);
		daoM.addFighterToNewMember(dog, (Member) request.getSession()
				.getAttribute("memberLoggedIn"));
		LOG.info(dog);
		return "member/MemberHome";

	}

	// show Fighters In Your City

	@RequestMapping(value = "/member/FightersInYourCity", method = RequestMethod.GET)
	public String listFightersInYourCity(HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute(
				"memberLoggedIn");
		City city = member.getAddress().getCity();
		List<Fighter> FightersInYourCity = daoM.FightersInYourCity(city,
				member.getId());
		request.getSession().setAttribute("FightersInYourCity",
				FightersInYourCity);
		request.getSession().setAttribute("city", city);

		return "member/fightersInMembersOwnCity";

	}

	// Buy fighter

	@RequestMapping(value = "member/buy", method = RequestMethod.GET)
	public String buyFighterFromSameCity(HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute(
				"memberLoggedIn");
		City city = member.getAddress().getCity();
		String fighterId = request.getParameter("fighterId");
		Fighter fighterToBuy = daoF.getFighter(Integer.parseInt(fighterId));
		daoM.buyFighter(fighterToBuy, member);
		Member fightersPreviousOwner = fighterToBuy.getMember();
		request.getSession().setAttribute("fightersBought", fighterToBuy);
		request.getSession().setAttribute("fightersPreviousOwner",
				fightersPreviousOwner);
		return "member/purchaseResult";
	}

	@RequestMapping(value = "member/FightThisFighter", method = RequestMethod.GET)
	public String fightFighterFromSameCity(HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute(
				"memberLoggedIn");
		City city = member.getAddress().getCity();
		String fighterId = request.getParameter("oppoFighterId");
		Fighter fighterToFight = daoF.getFighter(Integer.parseInt(fighterId));
		request.getSession().setAttribute("fighterToFight", fighterToFight);

		List<Fighter> YourOneMembersFighterList = daoM
				.listAllFightersofOneMember(String.valueOf(member.getId()));
		request.getSession().setAttribute("YourOneMembersFighterList",
				YourOneMembersFighterList);

		return "member/PickMyFighter";
	}

	@RequestMapping(value = "member/ChooseMyFighter", method = RequestMethod.GET)
	public String chooseMyFighterToFight(HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute(
				"memberLoggedIn");
		Fighter fighterToFight = (Fighter) request.getSession().getAttribute(
				"fighterToFight");
		String myFighterId = request.getParameter("myFighterId");
		Fighter myFighter = daoF.getFighter(Integer.parseInt(myFighterId));
		daoF.fight(myFighter, fighterToFight);

		request.getSession().setAttribute("myFighter", myFighter);

		return "member/FightResult";
	}

	// log out

	@RequestMapping(value = "/member/Logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}
