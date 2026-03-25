package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserStoreTest {
    @Test
    void whenUserDataEmpty() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    UserStore.findUser(null, "dontcare");
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Users storage is empty");
    }

    @Test
    void whenUserNotFound() {
        User[] users = {
                new User("admin", true),
                new User("user", true),
                new User("dev", true)
        };
        String login = "tester";
        UserNotFoundException exception = assertThrows(
                UserNotFoundException.class,
                () -> {
                    UserStore.findUser(users, login);
                }
        );
        assertThat(exception.getMessage()).isEqualTo("User - " + login + " not found");
    }

    @Test
    void whenUserValidFalse() {
        UserInvalidException exception = assertThrows(
                UserInvalidException.class,
                () -> {
                    UserStore.validate(new User("admin", false));
                }
        );
        assertThat(exception.getMessage()).isEqualTo("User is not a valid");
    }

    @Test
    void whenUsernameLengthLessThen3() {
        UserInvalidException exception = assertThrows(
                UserInvalidException.class,
                () -> {
                    UserStore.validate(new User("u1", true));
                }
        );
        assertThat(exception.getMessage()).isEqualTo("User is not a valid");
    }

    @Test
    void whenFindUserSuccess() throws UserNotFoundException {
        User[] users = {
                new User("admin", true),
                new User("user", true),
                new User("dev", true)
        };
        String username = "user";
        assertThat(UserStore.findUser(users, username)).isEqualTo(users[1]);

    }

    @Test
    void whenUserHasAccess() throws UserNotFoundException {
        assertThat(UserStore.validate(new User("dev", true))).isTrue();
    }
}