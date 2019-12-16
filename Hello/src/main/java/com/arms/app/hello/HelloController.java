package com.arms.app.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.arms.domain.entity.Hello;
import com.arms.domain.repository.HelloRepository;

@Controller
@RequestMapping("/")
public class HelloController {
	@Autowired
	
	HelloRepository helloResposity;
	@RequestMapping(value = "", method = RequestMethod.GET)
	
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.addObject("list", helloResposity.findAll()); //List รับตารางที่สร้างจาก Hello.java(SELECT * FROM Hello) findAll ค้นหาและแสดง
		modelAndView.setViewName("hello/list"); //Show list page
		return modelAndView;
	}
	
	@RequestMapping(value = "create", params = "form", method = RequestMethod.GET)
	public String create() {
	return "hello/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String doneCreate(@RequestParam("name") String name) {
	Hello hello = new Hello(); //สร้าง Rows ใหม่
	hello.setName(name);
	helloResposity.save(hello); //Insert
	return "redirect:/list"; } //วิ่งไปทำ Method list ข้างล่าง
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView modelAndView) {
		modelAndView.addObject("list", helloResposity.findAll());
		modelAndView.setViewName("hello/list"); //Show list page
	return modelAndView;
	}
	
	@RequestMapping(value = "update/{id}", params = "form", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id, ModelAndView modelAndView) {
	modelAndView.addObject("hello", helloResposity.getOne(id));
	modelAndView.setViewName("hello/update");
	return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestParam("id") int id, @RequestParam String name) {
	Hello hello = helloResposity.getOne(id);
	hello.setName(name);
	helloResposity.save(hello);
	return "redirect:/list";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		helloResposity.deleteById(id);
	return "redirect:/list";
	}
}
