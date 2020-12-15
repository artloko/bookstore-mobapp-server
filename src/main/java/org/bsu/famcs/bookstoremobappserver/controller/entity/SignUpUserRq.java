package org.bsu.famcs.bookstoremobappserver.controller.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bsu.famcs.bookstoremobappserver.repository.entity.UserEntity;


@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignUpUserRq {

    private String email;
    private String name;
    private String passwordEncrypted;
    private String address;

    public UserEntity convert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setPasswordEncrypted(passwordEncrypted);
        userEntity.setName(name);
        userEntity.setAddress(address);
        return userEntity;
    }

}
