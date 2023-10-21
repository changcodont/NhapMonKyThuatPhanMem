/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.supp.Entity.NhanVien;
import com.supp.Util.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84934
 */
public class nhanVienDao extends EduSysDAO<NhanVien, String> {

    final String INSERT_SQL = "	INSERT INTO NhanVien(MaNV,TenNV,MatKhau,DienThoai,Email,VaiTro,Hinh) values(?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "	UPDATE NhanVien set TenNV = ?, MatKhau = ?, DienThoai = ?,Email = ?,VaiTro = ?, Hinh = ? Where MaNV = ?";
    final String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    final String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV =?";

    @Override
    public void insert(NhanVien entity) {

        JDBCHelper.update(INSERT_SQL, entity.getMaNV(), entity.getTenNV(), entity.getMatKhau(), entity.getDienThoai(), entity.getEmail(), entity.getVaiTro(), entity.getHinhAnh());

    }

    @Override
    public void update(NhanVien entity) {

        JDBCHelper.update(UPDATE_SQL, entity.getTenNV(), entity.getMatKhau(), entity.getDienThoai(), entity.getEmail(), entity.getVaiTro(), entity.getHinhAnh(), entity.getMaNV());

    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);

    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);

    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setTenNV(rs.getString("TenNV"));

                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setDienThoai(rs.getString("DienThoai"));
                entity.setEmail(rs.getString("Email"));

                entity.setVaiTro(rs.getString("VaiTro"));
                entity.setHinhAnh(rs.getString("Hinh"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public List<NhanVien> selectByKeyword(String keyword){
        String sql = "SELECT * FROM NhanVien WHERE TenNV like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

}
