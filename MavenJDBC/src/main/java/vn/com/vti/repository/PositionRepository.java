package vn.com.vti.repository;


import vn.com.vti.entity.Position;
import vn.com.vti.entity.PositionName;
import vn.com.vti.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository {
    // Khai báo đối tượng connection để kết nối đến CSDL
    private final Connection con = DatabaseUtils.getInstance().getDatabaseConnection();

    public List<Position> getListPosition() throws SQLException {
        List<Position> positions = new ArrayList<>();
        String sql = "SELECT * FROM `Position` ORDER BY `PositionID`";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        con.commit();
        while (rs.next()) {
            Position position = new Position();
            position.setId(rs.getInt(1));
            position.setName(PositionName.valueOf(rs.getString(2)));
            positions.add(position);
        }
        return positions;


    }


}