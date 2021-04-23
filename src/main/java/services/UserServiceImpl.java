package services;

import configuration.DbConnectionConfiguration;
import model.etities.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    Connection connection;

    @Override
    public int add(UserEntity userEntity) throws SQLException {
        String query
                = "insert into AppUser(name,email,gender,status,created_at, update_at) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps
                = connection.prepareStatement(query);
        ps.setString(1, userEntity.getName());
        ps.setString(2, userEntity.getEmail());
        ps.setString(3, userEntity.getGender());
        ps.setString(4, userEntity.getStatus());
        ps.setString(5, String.valueOf(userEntity.getCreatedAt()));
        ps.setString(6, String.valueOf(userEntity.getUpdatedAt()));
        return ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public UserEntity getUser(int id) throws SQLException {
        return null;
    }

    @Override
    public List<UserEntity> getUsers() throws SQLException {
        return null;
    }

    @Override
    public void update(UserEntity userEntity) throws SQLException {

    }
}
