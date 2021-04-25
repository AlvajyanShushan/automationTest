package services;

import configuration.DbConnectionConfiguration;
import model.etities.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public int add(UserEntity userEntity) throws SQLException {
        String query
                = "insert into AppUser(user_id, name,email,gender,status,created_at, update_at) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps
                = DbConnectionConfiguration.getConnection().prepareStatement(query);
        ps.setInt(1, userEntity.getUserId());
        ps.setString(2, userEntity.getName());
        ps.setString(3, userEntity.getEmail());
        ps.setString(4, userEntity.getGender());
        ps.setString(5, userEntity.getStatus());
        ps.setString(6, userEntity.getCreatedAt());
        ps.setString(7, userEntity.getUpdatedAt());
        return ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String query
                = "delete from AppUser where user_id =?";
        PreparedStatement ps
                =  DbConnectionConfiguration.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
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
