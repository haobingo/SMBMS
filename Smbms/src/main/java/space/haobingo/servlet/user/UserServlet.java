package space.haobingo.servlet.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import space.haobingo.pojo.Role;
import space.haobingo.pojo.User;
import space.haobingo.service.role.RoleServiceImpl;
import space.haobingo.service.user.UserService;
import space.haobingo.service.user.UserServiceImpl;
import space.haobingo.util.Constants;
import space.haobingo.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServlet extends HttpServlet {
    public void init(){
    }
    public UserServlet(){
        super();
    }
    public void destroy(){
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        System.out.println("method----> " + method);
        if(method!=null&&method.equals("savepwd")){
            this.updatePwd(req,resp);
        }else if(method!=null&&method.equals("pwdmodify")){
            this.modifyPwd(req,resp);
        }else if(method!=null&&method.equals("query")){
            this.query(req,resp);
        }else if(method!=null&&method.equals("add")){
            try {
                this.add(req,resp);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }else if(method !=null&&method.equals("getrolelist")){
            this.getrolelist(req,resp);
        }else if(method!=null&&method.equals("ucexist")){
            this.userCodeExist(req,resp);
        }else if(method!=null&&method.equals("deluser")){
            this.deluser(req,resp);
        }else if(method!=null&&method.equals("view")){
            this.getUserById(req,resp,"userview.jsp");
        }else if(method!=null&&method.equals("modify")){
            System.out.println("进入modify");
            this.getUserById(req,resp,"usermodify.jsp");
        }else if(method!=null&&method.equals("modifyexe")){
            System.out.println("进入modifyexe");
            this.modify(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void updatePwd(HttpServletRequest req, HttpServletResponse resp){
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        String newpassword = req.getParameter("newpassword");
        boolean flag = false;
        System.out.println("selvert:"+newpassword);
        if(attribute!=null && !StringUtils.isNullOrEmpty(newpassword)){
            UserService userService = new UserServiceImpl();
            flag = userService.updatePwd(((User) attribute).getId(), newpassword);
            if(flag){
                req.setAttribute(Constants.SYS_MESSAGE ,"修改密码成功，请退出后重新登录");
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }else{
                req.setAttribute(Constants.SYS_MESSAGE ,"密码修改失败，请重新输入");
            }
        }else{
            req.setAttribute(Constants.SYS_MESSAGE ,"新密码设置错误，请重新输入");
        }
        try {
//            req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
            resp.sendRedirect("/smbms/error.jsp");
        }/* catch (ServletException e) {
            e.printStackTrace();
        }*/ catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void modifyPwd(HttpServletRequest req, HttpServletResponse resp) {
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");
        Map<String, String> resultMap = new HashMap<String, String>();
        if(attribute==null){
            resultMap.put("result","sessionerror");
        }else if(StringUtils.isNullOrEmpty(oldpassword)){
            resultMap.put("result","error");
        }else{
            String userPassword = ((User) attribute).getUserPassword();
            if(oldpassword.equals(userPassword)){
                resultMap.put("result","true");
            }else{
                resultMap.put("result","false");
            }
        }
        try {
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.write(JSON.toJSONString(resultMap));
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryUserName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole = 0;

        UserServiceImpl userService = new UserServiceImpl();
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<User> userList = null;
        List<Role> roleList = null;
        int pageSize = Constants.pageSize;
        int currentPageNo = 1;
        System.out.println("queryUserName servlet--------"+queryUserName);
        System.out.println("queryUserRole servlet--------"+queryUserRole);
        System.out.println("query pageIndex--------- > " + pageIndex);

        if(queryUserName==null){
            queryUserName = "";
        }
        if(temp!=null&&!temp.equals("")){
            queryUserRole = Integer.parseInt(temp);
        }
        if(pageIndex!=null){
            currentPageNo = Integer.parseInt(pageIndex);
        }
        int totalCount  = userService.getUserCount(queryUserName,queryUserRole);
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        int totalPageCount = pageSupport.getTotalPageCount();
        if(currentPageNo<1){
            currentPageNo=1;
        } else if (currentPageNo>totalPageCount) {
            currentPageNo = totalPageCount;
        }
        userList = userService.getUserList(queryUserName,queryUserRole,currentPageNo,pageSize);
        roleList = roleService.getRoleList();
       req.setAttribute("queryUserName",queryUserName);
       req.setAttribute("roleList",roleList);
       req.setAttribute("queryUserRole",queryUserRole);
       req.setAttribute("userList",userList);
       req.setAttribute("totalPageCount",totalPageCount);
       req.setAttribute("totalCount",totalCount);
       req.setAttribute("currentPageNo",currentPageNo);
       req.setAttribute("totalPageCount",totalPageCount);
       req.getRequestDispatcher("userlist.jsp").forward(req,resp);
    }
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ParseException {
        System.out.println("当前正在执行增加用户操作");
        String userCode =  req.getParameter("userCode");
        String userName =  req.getParameter("userName");
        String userPassword =  req.getParameter("userPassword");
        String gender =  req.getParameter("gender");
        String birthday =  req.getParameter("birthday");
        String phone =  req.getParameter("phone");
        String address =  req.getParameter("address");
        String userRole =  req.getParameter("userRole");
        User user = new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setAddress(address);
        user.setGender(Integer.valueOf(gender));
        user.setPhone(phone);
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setUserRole(Integer.valueOf(userRole));
        user.setCreatedBy(((User)req.getSession().getAttribute(Constants.USER_SESSION)).getId());
        user.setCreationDate(new Date());
        UserServiceImpl userService = new UserServiceImpl();
        Boolean flag = userService.add(user);
        if(flag){
            resp.sendRedirect(req.getContextPath()+"/jsp/user.do?method=query");
        }else{
            req.getRequestDispatcher("useradd.jsp").forward(req,resp);
        }
    }
    private void getrolelist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Role> roleList = null;
        RoleServiceImpl roleService = new RoleServiceImpl();
        roleList = roleService.getRoleList();
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSON.toJSONString(roleList));
        writer.flush();
        writer.close();
    }
    private void userCodeExist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userCode = req.getParameter("userCode");
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(StringUtils.isNullOrEmpty(userCode)){
            resultMap.put("userCode","exist");
        }else{
            UserServiceImpl userService = new UserServiceImpl();
            User user = userService.selectUserCodeExist(userCode);
            if(null!=user){
                resultMap.put("userCode","exist");
            }else{
                resultMap.put("userCode","notexist");
            }
        }
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(resultMap));
        writer.flush();
        writer.close();
    }

    private void deluser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("uid");
        Integer delId = 0;
        try{
            delId = Integer.valueOf(id);
        }catch (Exception e){
            delId = 0;
        }
        HashMap<String, String> resultMap = new HashMap<>();
        if(delId<=0){
            resultMap.put("delResult","notexist");
        }else{
            UserServiceImpl userService = new UserServiceImpl();
            if(userService.deleteUserById(delId)){
                resultMap.put("delResult","true");
            }else{
                resultMap.put("delResult","false");
            }
        }
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(resultMap));
        writer.flush();
        writer.close();
    }


    private void getUserById(HttpServletRequest req, HttpServletResponse resp,String url) throws ServletException, IOException {
        String id = req.getParameter("uid");
        if(!StringUtils.isNullOrEmpty(id)){
            UserServiceImpl userService = new UserServiceImpl();
            User user = userService.getUserById(Integer.valueOf(id));
            req.setAttribute("user",user);
            req.getRequestDispatcher(url).forward(req,resp);
        }
    }
    private void modify(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("进入UserServlet(未验证)---user");
        String id = req.getParameter("uid");
        String userName = req.getParameter("userName");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");
        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setUserName(userName);
        user.setGender(Integer.valueOf(gender));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(Integer.valueOf(userRole));
        user.setModifyBy(((User)req.getSession().getAttribute(Constants.USER_SESSION)).getId());
        user.setModifyDate(new Date());
        UserServiceImpl userService = new UserServiceImpl();
        boolean flag = userService.modify(user);
        if(flag){
            System.out.println("进入UserServlet(验证成功)---user");
            resp.sendRedirect(req.getContextPath()+"/jsp/user.do?method=query");
        }else{
            req.getRequestDispatcher("usermodify.jsp").forward(req,resp);
        }
    }
}
