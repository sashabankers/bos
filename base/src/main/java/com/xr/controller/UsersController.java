package com.xr.controller;

import com.xr.entity.Users;
import com.xr.service.UsersService;
import com.xr.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("user")
@Api("用户管理相关接口")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("list")
    @RequiresPermissions("user:list")
    @ApiOperation(value = "获得用户列表",notes = "获得用户列表")
    public ResponseResult list(Users users,Integer page,Integer limit){
        System.out.println("list");
        // 查询的所有，还未分页
        List<Users> list = usersService.list(users);
        ResponseResult result = new ResponseResult();
        result.getData().put("items",list);
        result.getData().put("total",list.size());
        return result;
    }

    @RequestMapping("add")
    @RequiresPermissions("user:add")
    @ApiOperation(value = "添加用户",notes = "添加用户")
    public ResponseResult add(@RequestBody  Users users){
        System.out.println("add");
        usersService.add(users);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","添加成功");
        return result;
    }

    @RequestMapping("update")
    @RequiresPermissions("user:update")
    @ApiOperation(value = "修改用户",notes = "修改用户")
    public ResponseResult update(@RequestBody Users users){
        System.out.println("users"+users);
        usersService.update(users);
        ResponseResult result = new ResponseResult();
        result.getData().put("message","修改成功");
        return result;
    }

    @RequestMapping("delete")
    @RequiresPermissions("user:delete")
    @ApiOperation(value = "删除用户",notes = "删除用户")
    public ResponseResult add(Long id, HttpServletRequest request){
        String uid = request.getParameter("id");
        System.out.println("id"+uid);
        usersService.delete(Long.parseLong(uid));
        ResponseResult result = new ResponseResult();
        result.getData().put("message","删除成功");
        return result;
    }


    @RequestMapping("login")
    @ApiOperation(value = "用户登录",notes = "用户登录")
    // 把ResponseResult改成ResponseEntity<Map<String,Object>>
    public ResponseResult login(@RequestBody Users users,HttpSession session){
//        System.out.println(users);
//        Users loginUser = usersService.login(users);
//        ResponseResult result = new ResponseResult();
////        Map<String,Object> map=new HashMap<>();
//        if (loginUser!=null){
//            //登陆成功
////            session.setAttribute("loginUser",loginUser);
//            // 登录成功，返回前端的消息
//            result.getData().put("message","登录成功");
//            // 前台唯一标识
//            result.getData().put("token",loginUser.getUsername());
////            map.put("msg","登陆成功");
////            map.put("loginUser",loginUser);
////            return ResponseEntity.status(HttpStatus.OK).body(map);
//        }else{
//            //登陆失败
////            map.put("msg","登陆失败，用户名或密码错误");
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
//            //登录失败，返回前端的消息
//            result.getData().put("message","登录失败，用户名或密码错误");
//        }
//        return result;
        ResponseResult result = new ResponseResult();
        UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(), users.getPassword());
        // 获得登录的主题
        Subject subject = SecurityUtils.getSubject();
        // 调用登录方法
        subject.login(token);
        // 返回给前台的toke，唯一标识用户
        result.getData().put("token",subject.getSession().getId());
        return result;
    }

    @RequestMapping("info")
    @ApiOperation(value = "获得登录用户信息",notes = "获得登录用户信息")
    public ResponseResult info(String token){
//        System.out.println(token);
//        // 根据用户名查询用户信息
//        Users user = usersService.findUserByUserName(token);
//        System.out.println(user);
//        // 根据用户名查询角色信息
//        List<String> roles =  usersService.findUserRoles(token);
//        System.out.println(roles.size());
//        ResponseResult result = new ResponseResult();
//        result.getData().put("roles",roles);
//        result.getData().put("introduction","I am an editor");
//        result.getData().put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
//        result.getData().put("name",user.getUsername());
//        return result;
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        ResponseResult result = new ResponseResult();
        if(token.equals(subject.getSession().getId().toString())){
            // 从shiro的session里获得保存的用户信息
            Users loginUser = (Users) session.getAttribute("USER_SESSION");
            // 获得角色字符串集合
            List<String> roles = (List<String>) session.getAttribute("roles");
            if(loginUser!=null){
                // 根据用户获得角色字符串数组
                roles = usersService.findUserRoles(loginUser.getUsername());
                result.getData().put("roles",roles);
                result.getData().put("introduction","I am an editor");
                result.getData().put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
                result.getData().put("name",loginUser.getUsername());
                return result;
            }
        }
        return null;
    }

    @RequestMapping("logout")
    public ResponseResult logout(){
        ResponseResult result = new ResponseResult();
        Subject subject = SecurityUtils.getSubject();
        // 只需调用shiro的logout方法就可以了
        subject.logout();
        return result;
    }

}
