package vn.its.controller.api;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import vn.its.model.BaiViet;
import vn.its.service.BaiVietService;

@RestController
public class BaiVietAPI {

	public static final Logger logger = LoggerFactory.getLogger(BaiVietAPI.class);

	@Autowired
	private BaiVietService baiVietService;

	//http://localhost:8080/api
	@GetMapping("/api")
	public String welcome() {
		return "Spring Rest";
	}

	//http://localhost:8080/api/baiviet
	@GetMapping("/api/baiviet")
	public String bietViet() {
		return "Spring Rest Bai Viet";
	}

	// http://localhost:8080/api/baiviet/all
	@GetMapping("api/baiviet/all")
	public ResponseEntity<List<BaiViet>> getAllBaiViet() {
		List<BaiViet> getAllBaiViet = baiVietService.findAllBaiViet();
		if (getAllBaiViet.isEmpty()) {
			return new ResponseEntity<List<BaiViet>>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<List<BaiViet>> list = new ResponseEntity<List<BaiViet>>(getAllBaiViet, HttpStatus.OK);
			return list;
		}

	}

	// http://localhost:8080/api/baiviet/4
	@GetMapping("api/baiviet/{maBV}")
	public ResponseEntity<BaiViet> getBaiVietByMaBV(@PathVariable("maBV") Integer maBV) {
		logger.info("Fetching BaiViet with maBV {}", maBV);
		BaiViet getBaiVietByMaBV = baiVietService.findByMaBV(maBV);
		if (getBaiVietByMaBV == null) {
			logger.error("BaiViet with maBV {} not found.", maBV);
			return new ResponseEntity<BaiViet>(HttpStatus.NOT_FOUND);
		} else {
			ResponseEntity<BaiViet> baiViet = new ResponseEntity<BaiViet>(getBaiVietByMaBV, HttpStatus.OK);
			return baiViet;
		}
	}

	// http://localhost:8080/api/baiviet/create
	// {
	// "tieuDe": "Hình ảnh thực tế về iPhone 82",
	// "danhMuc": "Công nghệ",
	// "chiTiet": "IPhone X là tương lai của điện thoại 8",
	// "lichDang": 1506747783000,
	// "trangThai": "Duyệt",
	// "nhan": "su-kien iphone apple"
	// }
	@PostMapping("api/baiviet/create")
	public ResponseEntity<Void> createBaiViet(@RequestBody BaiViet baiViet, UriComponentsBuilder builder) {
		logger.info("Creating BaiViet : {}", baiViet);
		boolean flag = baiVietService.createBaiViet(baiViet);
		if (flag == false) {
			logger.error("Unable to create. A BaiViet with tieuDe {} already exist", baiViet.getTieuDe());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("{maBV}").buildAndExpand(baiViet.getMaBV()).toUri());
			ResponseEntity<Void> createBaiViet = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			return createBaiViet;
		}
	}

	// http://localhost:8080/api/baiviet/update/8
	// {
	// "maBV": 8,
	// "tieuDe": "Hình ảnh thực tế về iPhone 828",
	// "danhMuc": "Công nghệ",
	// "chiTiet": "IPhone X là tương lai của điện thoại 8",
	// "lichDang": 1506747783000,
	// "trangThai": "Duyệt",
	// "nhan": "su-kien iphone apple"
	// }
	@PutMapping("api/baiviet/update/{maBV}")
	public ResponseEntity<BaiViet> updateBaiViet(@PathVariable("maBV") Integer maBV, @RequestBody BaiViet baiViet) {
		logger.info("Updating BaiViet with maBV {}", maBV);
		BaiViet currentBaiViet = baiVietService.findByMaBV(maBV);
		if (currentBaiViet == null) {
			logger.error("Unable to update. BaiViet with maBV {} not found.", maBV);
			return new ResponseEntity<BaiViet>(HttpStatus.NOT_FOUND);
		} else {
			maBV = baiViet.getMaBV();
			String tieuDe = baiViet.getTieuDe();
			String danhMuc = baiViet.getDanhMuc();
			String chiTiet = baiViet.getChiTiet();
			Date lichDang = baiViet.getLichDang();
			String trangThai = baiViet.getTrangThai();
			String nhan = baiViet.getNhan();
			currentBaiViet = new BaiViet(maBV, tieuDe, danhMuc, chiTiet, lichDang, trangThai, nhan);
			baiVietService.updateBaiViet(currentBaiViet);
			ResponseEntity<BaiViet> updateBaiViet = new ResponseEntity<BaiViet>(currentBaiViet, HttpStatus.OK);
			return updateBaiViet;
		}
	}

	// http://localhost:8080/api/baiviet/delete/6
	@DeleteMapping("api/baiviet/delete/{maBV}")
	public ResponseEntity<Void> deleteBaiViet(@PathVariable("maBV") Integer maBV) {
		logger.info("Fetching & Deleting BaiViet with maBV {}", maBV);
		BaiViet currentBaiViet = baiVietService.findByMaBV(maBV);
		if (currentBaiViet == null) {
			logger.error("Unable to update. BaiViet with maBV {} not found.", maBV);
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			baiVietService.deleteBaiViet(maBV);
			ResponseEntity<Void> deleteBaiViet = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return deleteBaiViet;
		}
	}

	// http://localhost:8080/api/baiviet/delete/all
	@DeleteMapping("api/baiviet/delete/all")
	public ResponseEntity<BaiViet> deleteAllBaiViet(@PathVariable("maBV") Integer maBV) {
		logger.info("Deleting All BaiViet");
		baiVietService.deleteAllBaiViet();
		ResponseEntity<BaiViet> deleteBaiViet = new ResponseEntity<BaiViet>(HttpStatus.NO_CONTENT);
		return deleteBaiViet;

	}

}
