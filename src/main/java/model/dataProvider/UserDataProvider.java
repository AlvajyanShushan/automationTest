package model.dataProvider;

import model.etities.UserEntity;
import util.Utils;

public class UserDataProvider {

    public static final UserEntity NEW_USER = UserEntity
            .builder()
            .name("New User")
            .gender("Male")
            .email(Utils.generateRandomEmail())
            .status("Active")
            .build();

    public static final UserEntity USER_WITH_WRONG_EMAIL = UserEntity
            .builder()
            .name("New User")
            .gender("Male")
            .email("pogos@")
            .status("Active")
            .build();

    public static final UserEntity USER_WITH_EMPTY_STATUS = UserEntity
            .builder()
            .name("New User")
            .gender("Male")
            .email(Utils.generateRandomEmail())
            .status("")
            .build();


}
