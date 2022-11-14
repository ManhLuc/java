package vn.com.vti.controller;


import vn.com.vti.entity.Position;
import vn.com.vti.sevice.PositionService;

import java.util.ArrayList;
import java.util.List;

public class PositionController {
    private final PositionService positionService;
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }
    public List<Position> getListPosition() {
        List<Position> positions = new ArrayList<>();
        try {
            positions = positionService.getListPosition();
        } catch (Exception e) {
            System.out.println("Lấy danh sách account không thành công " + e.getMessage());
        }
        return positions;
    }

}