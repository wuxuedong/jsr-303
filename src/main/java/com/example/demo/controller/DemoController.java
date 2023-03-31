package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.dto.User;
import com.example.demo.group.AddGroup;
import com.example.demo.group.UpdateGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    /**
     *  加入@Validated注解生效，AddGroup.class代表只对User类中加入groups = {UpdateGroup.class}属性才验证
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Result<String> add(@Validated(AddGroup.class) @RequestBody User user){
        System.out.println(user);
        return Result.success("成功");
    }

    @PostMapping("update")
    public void update(@Validated(UpdateGroup.class) @RequestBody User user){
        System.out.println(user);
    }
}
