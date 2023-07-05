package usermanagement.repository;

import org.springframework.stereotype.Repository;
import usermanagement.entity.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{
    private List<User> listUser = new ArrayList<>();

    @PostConstruct
    public void initData(){
        User user1 = new User();
        user1.setId(1);
        user1.setName("Hoàng Tôn Thất Nhật Minh");
        user1.setAge(25);
        user1.setAddress("Thành phố Huế, tỉnh Thừa Thiên Huế, Việt Nam");
        user1.setPhone("0384895512");
        user1.setEmail("hoangnhatminh23081998@gmail");
        user1.setPassword("NhatMinh123@");
        user1.setRole("admin");

        User user2 = new User();
        user2.setId(2);
        user2.setName("Nguyễn Thái Hưng");
        user2.setAge(26);
        user2.setAddress("Thành phố Nha Trang, tỉnh Khánh Hòa, Việt Nam");
        user2.setPhone("0369088004");
        user2.setEmail("nguyenthaihung@gmail.com");
        user2.setPassword("ThaiHung456@");
        user2.setRole("user");

        User user3 = new User();
        user3.setId(3);
        user3.setName("Nguyễn Hữu Học");
        user3.setAge(20);
        user3.setAddress("Huyện Thăng Bình, tỉnh Quảng Nam, Việt Nam");
        user3.setPhone("0788640856");
        user3.setEmail("nguyenhuuhoc@gmail.com");
        user3.setPassword("HuuHoc789@");
        user3.setRole("user");

        User user4 = new User();
        user4.setId(4);
        user4.setName("Lê Đức Thông");
        user4.setAge(20);
        user4.setAddress("Huyện Hòa Vang, thành phố Đà Nẵng, Việt Nam");
        user4.setPhone("0902461457");
        user4.setEmail("leducthong@gmail.com");
        user4.setPassword("DucThongJQK@");
        user4.setRole("user");

        User user5 = new User();
        user5.setId(5);
        user5.setName("Phạm Hoàng Bảo");
        user5.setAge(23);
        user5.setAddress("Thành phố Tam Kỳ, tỉnh Quảng Nam, Việt Nam");
        user5.setPhone("0702533884");
        user5.setEmail("phamhoangbao@gmail");
        user5.setPassword("HoangBaoA23@");
        user5.setRole("user");

        User user6 = new User();
        user6.setId(6);
        user6.setName("Trần Đức Huy");
        user6.setAge(21);
        user6.setAddress("Quận Ngũ Hành Sơn, thành phố Đà Nẵng");
        user6.setPhone("037785695");
        user6.setEmail("tranduchuy@gmail.com");
        user6.setPassword("DucHuyD56@");
        user6.setRole("user");

        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);
        listUser.add(user4);
        listUser.add(user5);
        listUser.add(user6);
    }

    private int getIndex(long id){
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    @Override
    public List<User> findAll() {
        if (listUser.isEmpty()){
            throw new RuntimeException("Danh sách trống, có ai đâu mà đòi xem. Lêu Lêu :))");
        }
        return listUser;
    }

    @Override
    public User findById(long id) {
        if(listUser.isEmpty()){
            throw new RuntimeException("Danh sách có ai đâu mà tìm. Lêu lêu");
        }
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getId() ==  id){
                return listUser.get(i);
            }
        }
        return null;
    }

    @Override
    public List<User> findListByName(String name) {
        if(listUser.isEmpty()){
            throw new RuntimeException("Danh sách có ai đâu mà tìm. Lêu lêu");
        }
        List<User> newList = new ArrayList<>();
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                newList.add(listUser.get(i));
            }
        }
        return newList;
    }

    @Override
    public List<User> findListByEmail(String email) {
        if(listUser.isEmpty()){
            throw new RuntimeException("Danh sách có ai đâu mà tìm. Lêu lêu");
        }
        List<User> newList = new ArrayList<>();
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getEmail().toLowerCase().contains(email.toLowerCase())){
                newList.add(listUser.get(i));
            }
        }
        return newList;
    }

    @Override
    public List<User> findListByPhone(String phone) {
        if(listUser.isEmpty()){
            throw new RuntimeException("Danh sách có ai đâu mà tìm. Lêu lêu");
        }
        List<User> newList = new ArrayList<>();
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getPhone().toLowerCase().contains(phone.toLowerCase())){
                newList.add(listUser.get(i));
            }
        }
        return newList;
    }

    @Override
    public List<User> findListByAddress(String address) {
        if(listUser.isEmpty()){
            throw new RuntimeException("Danh sách có ai đâu mà tìm. Lêu lêu");
        }
        List<User> newList = new ArrayList<>();
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getAddress().toLowerCase().contains(address.toLowerCase())){
                newList.add(listUser.get(i));
            }
        }
        return newList;
    }

    @Override
    public User save(User user) {
        listUser.add(user);
        return user;
    }

    @Override
    public User update(long id, User updateUser) {
        if(listUser.isEmpty()){
            throw new RuntimeException("Danh sách có ai đâu mà tìm. Lêu lêu");
        }
        if(getIndex(id) != -1){
            int index = getIndex(id);
            listUser.set(index, updateUser);
        }else {
            throw new RuntimeException("Lừa nhau à, làm gì có ai có Id = " + id);
        }
        return updateUser;
    }

    @Override
    public User delete(long id) {
        if(listUser.isEmpty()){
            throw new RuntimeException("Danh sách có ai đâu mà tìm. Lêu lêu");
        }
        User user = listUser.get(getIndex(id));
        if(getIndex(id) != -1){
            listUser.remove(getIndex(id));
        }else {
            throw new RuntimeException("Lừa nhau à, làm gì có ai có Id = " + id);
        }
        return user;
    }

    @Override
    public boolean checkExistId(long id) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkExistEmail(String email) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getPhone().equals(phone)){
                return true;
            }
        }
        return false;
    }
}
