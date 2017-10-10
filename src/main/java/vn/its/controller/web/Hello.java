package vn.its.controller.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.its.model.BaiViet;
import vn.its.service.BaiVietService;

@Controller
public class Hello {

	@Autowired
	private BaiVietService baiVietService;

	@GetMapping("/hello")
	public String hello(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "admin/hello";
	}

	@GetMapping("/hello/baiviet")
	public String bvList(Model model) {
		model.addAttribute("baiviets", baiVietService.findAllBaiViet());
		return "admin/bvlist";
	}

	@GetMapping("/hello/baiviet/create")
	public String add(Model model) {
		model.addAttribute("baiviet", new BaiViet());
		return "admin/bvform";
	}

	@GetMapping("/hello/baiviet/update/{maBV}")
	public String edit(@PathVariable int maBV, Model model) {
		BaiViet baiViet = baiVietService.findByMaBV(maBV);
		if (baiViet == null) {
			return "admin/404";
		} else {
			model.addAttribute("baiviet", baiViet);
			return "admin/bvform";
		}
	}

	@PostMapping("/hello/baiviet/save")
	public String save(@Valid BaiViet baiViet, Model model) {
		if (baiViet.getMaBV() == 0) {
			baiVietService.createBaiViet(baiViet);
		} else {
			baiVietService.updateBaiViet(baiViet);
		}
		return "redirect:/hello/baiviet";
	}

	@GetMapping("/hello/baiviet/delete/{maBV}")
	public String delete(@PathVariable int maBV) {
		BaiViet baiViet = baiVietService.findByMaBV(maBV);
		if (baiViet == null) {
			return "admin/404";
		} else {
			baiVietService.deleteBaiViet(maBV);
			return "redirect:/hello/baiviet";
		}
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
