package vn.its.model;

import java.util.Date;

public class BaiViet {
	private int maBV;
	private String tieuDe;
	private String danhMuc;
	private String chiTiet;
	private Date lichDang;
	private String trangThai;
	private String nhan;

	public BaiViet() {
		super();
	}

	public BaiViet(int maBV, String tieuDe, String danhMuc, String chiTiet, Date lichDang, String trangThai,
			String nhan) {
		super();
		this.maBV = maBV;
		this.tieuDe = tieuDe;
		this.danhMuc = danhMuc;
		this.chiTiet = chiTiet;
		this.lichDang = lichDang;
		this.trangThai = trangThai;
		this.nhan = nhan;
	}

	public BaiViet(String tieuDe, String danhMuc, String chiTiet, Date lichDang, String trangThai, String nhan) {
		super();
		this.tieuDe = tieuDe;
		this.danhMuc = danhMuc;
		this.chiTiet = chiTiet;
		this.lichDang = lichDang;
		this.trangThai = trangThai;
		this.nhan = nhan;
	}

	@Override
	public String toString() {
		return "BaiViet [maBV=" + maBV + ", tieuDe=" + tieuDe + ", danhMuc=" + danhMuc + ", chiTiet=" + chiTiet + ", lichDang=" + lichDang + ", trangThai=" + trangThai + ", nhan=" + nhan + "]";
	}

	public int getMaBV() {
		return maBV;
	}

	public void setMaBV(int maBV) {
		this.maBV = maBV;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(String danhMuc) {
		this.danhMuc = danhMuc;
	}

	public String getChiTiet() {
		return chiTiet;
	}

	public void setChiTiet(String chiTiet) {
		this.chiTiet = chiTiet;
	}

	public Date getLichDang() {
		return lichDang;
	}

	public void setLichDang(Date lichDang) {
		this.lichDang = lichDang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getNhan() {
		return nhan;
	}

	public void setNhan(String nhan) {
		this.nhan = nhan;
	}

}
