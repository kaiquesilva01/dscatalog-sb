package com.developer.dscatalog.dto;

import com.developer.dscatalog.services.validation.UserInsertValid;
import com.developer.dscatalog.services.validation.UserUpdateValid;

@UserUpdateValid
public class UserUpdateDTO extends UserDTO{

    public UserUpdateDTO() {
        super();
    }

}
