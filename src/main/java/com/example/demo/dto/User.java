package com.example.demo.dto;


import com.example.demo.group.AddGroup;
import com.example.demo.group.UpdateGroup;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author wxd
 * @create 2022-11-07 12:19
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id不能为空",groups = {UpdateGroup.class})
    private Long userId;
    @NotBlank(message = "名称不能为口",groups = {AddGroup.class, UpdateGroup.class})
    private String userName;
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号格式错误",groups = {AddGroup.class,UpdateGroup.class})
    @NotBlank(message = "手机号码不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private String phone;
    @Range(min = 1,max = 150,message = "年龄应该1-150岁之间",groups = {AddGroup.class, UpdateGroup.class})
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
