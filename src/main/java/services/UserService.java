package services;

import model.etities.UserEntity;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public int add(UserEntity userEntity) throws SQLException;

    public void delete(int id) throws SQLException;

    public UserEntity getUser(int id) throws SQLException;

    public List<UserEntity> getUsers() throws SQLException;

    public void update(UserEntity userEntity) throws SQLException;
}