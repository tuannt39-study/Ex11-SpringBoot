package vn.its.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.its.dao.BaiVietDAO;
import vn.its.model.BaiViet;

@Service("baiVietService")
public class BaiVietServiceImpl implements BaiVietService{
	
	@Autowired
	private BaiVietDAO baiVietDAO;

	@Override
	public List<BaiViet> findAllBaiViet() {
		return baiVietDAO.findAllBaiViet();
	}

	@Override
	public BaiViet findByMaBV(int maBV) {
		BaiViet baiViet = baiVietDAO.findByMaBV(maBV);
		return baiViet;
	}

	@Override
	public synchronized boolean createBaiViet(BaiViet baiViet) {
		if (baiVietDAO.isBaiVietExist(baiViet.getTieuDe())) {
			return false;
		} else {
			baiVietDAO.createBaiViet(baiViet);
			return true;
		}
	}

	@Override
	public void updateBaiViet(BaiViet baiViet) {
		baiVietDAO.updateBaiViet(baiViet);
	}

	@Override
	public void deleteBaiViet(int maBV) {
		baiVietDAO.deleteBaiViet(maBV);
	}

	@Override
	public void deleteAllBaiViet() {
		baiVietDAO.deleteAllBaiViet();
	}
	
}
