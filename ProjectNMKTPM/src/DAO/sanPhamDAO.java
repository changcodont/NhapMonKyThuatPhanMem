/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.supp.Entity.NhanVien;
import com.supp.Entity.SanPham;
import com.supp.Util.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class sanPhamDAO extends EduSysDAO<SanPham, String>{
    
    final String INSERT_SQL = "	INSERT INTO SanPham(MaSP,MaNV,TenSP,TonKho,NhaSX,NgaySX,Gia,Hinh) values(?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "	UPDATE SanPham set MaNV = ?, TenSP = ?, TonKho = ?,NhaSX = ?,NgaySX = ?,Gia = ?, Hinh = ? Where MaSP = ?";
    final String DELETE_SQL = "DELETE FROM SanPham WHERE MaSP = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM SanPham";
    final String SELECT_BY_ID_SQL = "SELECT * FROM SanPham WHERE MaSP =?";
    
    
    @Override
    public void insert(SanPham entity) {
        JDBCHelper.update(INSERT_SQL,
                entity.getMaSP(),
                entity.getMaNV(),
                entity.getTenSP(),
                entity.getTonKho(),
                entity.getNhaSX(),
                entity.getNgaySX(),
                entity.getGia(),
                entity.getHinh());
    }

    @Override
    public void update(SanPham entity) {
        JDBCHelper.update(UPDATE_SQL, 
                entity.getMaNV(),
                entity.getTenSP(),
                entity.getTonKho(),
                entity.getNhaSX(),
                entity.getNgaySX(),
                entity.getGia(),
                entity.getHinh(),
                entity.getMaSP());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<SanPham> selectAll() {
        return selectBySql(SELECT_ALL_SQL);

    }

    @Override
    public SanPham selectById(String id) {
        List<SanPham> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                SanPham entity = new SanPham();
                entity.setMaSP(rs.getString("MaSP"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setTenSP(rs.getString("TenSP"));

                entity.setTonKho(rs.getInt("TonKho"));
                entity.setNhaSX(rs.getString("NhaSX"));
                entity.setNgaySX(rs.getDate("NgaySX"));
                entity.setGia(rs.getDouble("Gia"));

                entity.setHinh(rs.getString("Hinh"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
