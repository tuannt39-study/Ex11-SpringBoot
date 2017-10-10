package vn.its.dao;

import java.util.List;

import vn.its.model.BaiViet;

public interface BaiVietDAO {
	List<BaiViet> findAllBaiViet();
	BaiViet findByMaBV(int maBV);
	void createBaiViet(BaiViet baiViet);
	void updateBaiViet(BaiViet baiViet);
	void deleteBaiViet(int maBV);
	void deleteAllBaiViet();
	boolean isBaiVietExist(String tieuDe);
}
