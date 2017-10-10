package vn.its.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class BaiVietRowMapper implements RowMapper<BaiViet>{
	
	@Override
	public BaiViet mapRow(ResultSet row, int rowNum) throws SQLException {
		int maBV = row.getInt("MABV");
		String tieuDe = row.getString("TIEUDE");
		String danhMuc = row.getString("DANHMUC");
		String chiTiet = row.getString("CHITIET");
		Date lichDang = row.getDate("LICHDANG");
		String trangThai = row.getString("TRANGTHAI");
		String nhan = row.getString("NHAN");
		BaiViet baiViet = new BaiViet(maBV, tieuDe, danhMuc, chiTiet, lichDang, trangThai, nhan);
		return baiViet;
	}
}