package vn.its.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaiVietWeb {
	
	@GetMapping("/")
	public String getWeb() {
		return "admin/index";
	}
	
	@GetMapping("/web/baiviet")
	public String getBaiVietPage() {
		return "admin/BaiViet";
	}
}
