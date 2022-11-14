package vn.com.vti;

import vn.com.vti.controller.PositionController;


import vn.com.vti.entity.Position;
import vn.com.vti.repository.PositionRepository;

import vn.com.vti.sevice.PositionService;
import vn.com.vti.utils.ScannerUtils;

import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        PositionRepository repository = new PositionRepository();
        PositionService service = new PositionService() {
            @Override
            public List<Position> getListPosition() throws SQLException {
                return null;
            }

            @Override
            public void cretePosition(Position request) throws SQLException {

            }

            @Override
            public void updatePosition(Position request) throws SQLException {

            }

            @Override
            public void deletePosition(Position request) throws SQLException {

            }
        } ;
        PositionController controller = new PositionController(service);
        boolean exit = false;
        do {
            showMenu();
            // Lưu chữ sự lựa chọn
            int choice = ScannerUtils.inputInt();
            switch (choice) {
                case 1:
                    System.out.println("========== Danh sách chức vụ ==========");
                    List<Position> positions = controller.getListPosition();
                    for (Position position : positions) {
                        System.out.println(position);
                    }
                    break;
/*

*/
                default:
                    System.out.println("Bạn đã chọn sai chức năng mời bạn chạy lại chương trình và chọn lại các chức năng từ 1 đến 5");
                    break;
            }
        } while (!exit);
    }

    public static void showMenu() {
        System.out.println("+---------------------------------------------------+");
        System.out.println("1.Hiển thị danh sách chức vụ");
        System.out.println("2.Thêm mới chức vụ");
        System.out.println("3.Chỉnh sửa thông tin chức vụ");
        System.out.println("4.Xoá chức vụ");
        System.out.println("5.Thoát chức vụ");
        System.out.println("+---------------------------------------------------+");
        System.out.print("Hãy nhập vào sự lựa chọn của bạn: ");
    }

}