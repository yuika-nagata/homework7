package com.raisetech.task7;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CreateForm {
    @NotBlank
    @Length(max = 20)
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
