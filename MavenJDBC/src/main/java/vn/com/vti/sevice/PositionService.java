package vn.com.vti.sevice;

import vn.com.vti.entity.Position;

import java.sql.SQLException;
import java.util.List;

public interface  PositionService {
    List<Position> getListPosition() throws SQLException ;


    void cretePosition(Position request) throws SQLException;

    void updatePosition(Position request) throws SQLException;

    void deletePosition(Position request) throws SQLException;


}
