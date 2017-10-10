package vn.its.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.its.model.BaiViet;
import vn.its.model.BaiVietRowMapper;

@Transactional
@Repository
public class BaiVietDAOImpl implements BaiVietDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<BaiViet> findAllBaiViet() {
		String findAllBaiViet = "SELECT MABV, TIEUDE, DANHMUC, CHITIET, LICHDANG, TRANGTHAI, NHAN " + "FROM TUAN.BAIVIET ORDER BY MABV";
		RowMapper<BaiViet> rowMapper = new BaiVietRowMapper();
		List<BaiViet> list = jdbcTemplate.query(findAllBaiViet, rowMapper);
		return list;
	}

	@Override
	public BaiViet findByMaBV(int maBV) {
		String findByMaBV = "SELECT MABV, TIEUDE, DANHMUC, CHITIET, LICHDANG, TRANGTHAI, NHAN " + "FROM TUAN.BAIVIET " + "WHERE MABV=?";
		RowMapper<BaiViet> rowMapper = new BeanPropertyRowMapper<BaiViet>(BaiViet.class);
		BaiViet baiViet = jdbcTemplate.queryForObject(findByMaBV, rowMapper, maBV);
		if (baiViet.getMaBV() == maBV) {
			return baiViet;
		}else {
			return null;
		}
	}

	@Override
	public void createBaiViet(BaiViet baiViet) {
		String createBaiViet = "INSERT INTO TUAN.BAIVIET (TIEUDE, DANHMUC, CHITIET, LICHDANG, TRANGTHAI, NHAN) " + "VALUES (?, ?, ?, ?, ?, ?)";
		String tieuDe = baiViet.getTieuDe();
		String danhMuc = baiViet.getDanhMuc();
		String chiTiet = baiViet.getChiTiet();
		Date lichDang = baiViet.getLichDang();
		String trangThai = baiViet.getTrangThai();
		String nhan = baiViet.getNhan();
		jdbcTemplate.update(createBaiViet, tieuDe, danhMuc, chiTiet, lichDang, trangThai, nhan);
	}

	@Override
	public void updateBaiViet(BaiViet baiViet) {
		String updateBaiViet = "UPDATE TUAN.BAIVIET " + "SET TIEUDE = ?, DANHMUC = ?, CHITIET = ?, LICHDANG = ?, TRANGTHAI = ?, NHAN = ? " + "WHERE MABV = ?";
		String tieuDe = baiViet.getTieuDe();
		String danhMuc = baiViet.getDanhMuc();
		String chiTiet = baiViet.getChiTiet();
		Date lichDang = baiViet.getLichDang();
		String trangThai = baiViet.getTrangThai();
		String nhan = baiViet.getNhan();
		int maBV = baiViet.getMaBV();
		jdbcTemplate.update(updateBaiViet, tieuDe, danhMuc, chiTiet, lichDang, trangThai, nhan, maBV);
	}

	@Override
	public void deleteBaiViet(int maBV) {
		String deleteBaiViet = "DELETE FROM TUAN.BAIVIET " + "WHERE MABV = ?";
		jdbcTemplate.update(deleteBaiViet, maBV);
	}

	@Override
	public void deleteAllBaiViet() {
		String deleteAllBaiViet = "DELETE FROM TUAN.BAIVIET";
		jdbcTemplate.update(deleteAllBaiViet);
	}

	@Override
	public boolean isBaiVietExist(String tieuDe) {
		String baiVietExit = "SELECT count(*) FROM TUAN.BAIVIET " + "WHERE TIEUDE = ?";
		int count = jdbcTemplate.queryForObject(baiVietExit, Integer.class, tieuDe);
		if (count ==0 ) {
			return false;
		} else {
			return true;
		}
	}
	
}
