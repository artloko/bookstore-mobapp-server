package org.bsu.famcs.bookstoremobappserver.controller.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bsu.famcs.bookstoremobappserver.repository.entity.UserEntity;

import java.util.Date;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoRs {
    
    private String email;
    private String name;
    private String address;
    private Date registrationDate;

    public UserInfoRs(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.name = userEntity.getName();
        this.address = userEntity.getAddress();
        this.registrationDate = userEntity.getCreatedAt();
    }
    
}
