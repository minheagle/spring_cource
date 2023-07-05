package usermanagement.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import usermanagement.entity.User;
import usermanagement.service.IUserService;

import java.util.List;
import java.util.Scanner;

@Component
public class ManagementApp {
    public static Scanner scanner = new Scanner(System.in);
    @Autowired
    private IUserService userService;

    public void run(){
        while (true){
            System.out.println("<======================================>");
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ USER SIÊU CẤP");
            System.out.println("1.Lấy toàn bộ danh sách User.");
            System.out.println("2.Lấy thông tin của 1 User.");
            System.out.println("3.Thêm 1 User mới.");
            System.out.println("4.Cập nhật lại thông tin cho 1 User.");
            System.out.println("5.Xóa 1 User.");
            System.out.println("6.Tìm User theo tên.");
            System.out.println("7.Tìm User theo email.");
            System.out.println("8.Tìm User theo số điện thoại.");
            System.out.println("9.Tìm User theo địa chỉ.");
            System.out.println("10.Thoát chương trình.");
            System.out.println("<======================================>");
            int choose;
            do {
                System.out.println("Mời mấy ông bà già chọn chương trình : (Chọn từ 1 đến 10 thôi nha)");
                choose = Integer.parseInt(scanner.nextLine());
            }while (choose < 1 || choose > 10);
            switch (choose){
                case 1:
                    getAllUser();
                    break;
                case 2:
                    System.out.println("Nhập Id của User vào :");
                    getDetail(Long.parseLong(scanner.nextLine()));
                    break;
                case 3:
                    addNewUser();
                    break;
                case 4:
                    updateUser1();
                    break;
                case 5:
                    System.out.println("Mời nhập Id của User muốn xóa : ");
                    long deleteId = Long.parseLong(scanner.nextLine());
                    if(checkExist(deleteId)) {
                        deleteUser(deleteId);
                    }
                    break;
                case 6:
                    System.out.println("Mời nhập tên mà bạn muốn tìm kiếm : ");
                    String nameSearch = scanner.nextLine();
                    showListUserByNameSearch(nameSearch);
                    break;
                case 7:
                    System.out.println("Mời nhập email mà bạn muốn tìm kiếm : ");
                    String emailSearch = scanner.nextLine();
                    showListUserByEmailSearch(emailSearch);
                    break;
                case 8:
                    System.out.println("Mời nhập số điện thoại mà bạn muốn tìm kiếm : ");
                    String phoneSearch = scanner.nextLine();
                    showListUserByPhoneSearch(phoneSearch);
                    break;
                case 9:
                    System.out.println("Mời nhập địa chỉ mà bạn muốn tìm kiếm : ");
                    String addressSearch = scanner.nextLine();
                    showListUserByAddressSearch(addressSearch);
                    break;
                case 10:
                    System.out.println("Bye nha mấy ông bà già, tui đi ngủ đây.");
                    System.exit(0);
                    break;
            }
        }
    }

    private void printList(List<User> listUser){
        for (User user: listUser) {
            System.out.println(user.toString());
        }
    }

    private void getAllUser(){
        try{
            List<User> listUser = userService.getAll();
            printList(listUser);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void getDetail(long id){
        try{
            User user = userService.getUserById(id);
            System.out.println(user.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void addNewUser(){
        User newUser = new User();
        System.out.println("Mời nhập Id :");
        long newUserId = Long.parseLong(scanner.nextLine());
        try {
                newUser.setId(newUserId);
                System.out.println("Mời nhập tên :");
                newUser.setName(scanner.nextLine());
                System.out.println("Mời nhập tuổi : ");
                newUser.setAge(Integer.parseInt(scanner.nextLine()));
                System.out.println("Mời nhập địa chỉ : ");
                newUser.setAddress(scanner.nextLine());
                System.out.println("Mời nhập số điện thoại : ");
                newUser.setPhone(scanner.nextLine());
                System.out.println("Mời nhập email : ");
                newUser.setEmail(scanner.nextLine());
                System.out.println("Mời nhập mật khẩu : ");
                newUser.setPassword(scanner.nextLine());
                newUser.setRole("user");
                User user = userService.insert(newUser);
                System.out.println("Thêm User thành công !");
                System.out.println(user.toString());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void updateUser1(){
        System.out.println("Mời nhập Id của User muốn thay đổi : ");
        long id = Long.parseLong(scanner.nextLine());
        if(checkExist(id)){
            User updateUser = new User();
            System.out.println("Mời nhập tên :");
            updateUser.setName(scanner.nextLine());
            System.out.println("Mời nhập tuổi : ");
            updateUser.setAge(Integer.parseInt(scanner.nextLine()));
            System.out.println("Mời nhập địa chỉ : ");
            updateUser.setAddress(scanner.nextLine());
            System.out.println("Mời nhập số điện thoại : ");
            updateUser.setPhone(scanner.nextLine());
            System.out.println("Mời nhập email : ");
            updateUser.setEmail(scanner.nextLine());
            System.out.println("Mời nhập mật khẩu : ");
            updateUser.setPassword(scanner.nextLine());
            updateUser.setRole("user");
            updateUser.setId(id);
            updateUser2(id, updateUser);
        }
    }

    private void updateUser2(long id, User updateUser){
        try{
            User user = userService.edit(id, updateUser);
            System.out.println("Cập nhật User thành công !");
            System.out.println(user.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void deleteUser(long id){
        try{
            User user = userService.remove(id);
            System.out.println("Xóa User thành công !");
            System.out.println(user.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private boolean checkExist(long id){
        User user = userService.getUserById(id);
        if(user != null){
            return true;
        }
        return false;
    }

    private void showListUserByNameSearch(String nameSearch){
        try {
            List<User> list = userService.getListUserByName(nameSearch);
            printList(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void showListUserByEmailSearch(String emailSearch){
        try {
            List<User> list = userService.getListUserByEmail(emailSearch);
            printList(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void showListUserByPhoneSearch(String phoneSearch){
        try {
            List<User> list = userService.getListUserByPhone(phoneSearch);
            printList(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void showListUserByAddressSearch(String addressSearch){
        try {
            List<User> list = userService.getListUserByAddress(addressSearch);
            printList(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
