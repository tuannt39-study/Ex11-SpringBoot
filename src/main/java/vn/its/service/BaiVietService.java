package vn.its.service;

import java.util.List;

import vn.its.model.BaiViet;

public interface BaiVietService {
	List<BaiViet> findAllBaiViet();
	BaiViet findByMaBV(int maBV);
	boolean createBaiViet(BaiViet baiViet);
	void updateBaiViet(BaiViet baiViet);
	void deleteBaiViet(int maBV);
	void deleteAllBaiViet();
}
