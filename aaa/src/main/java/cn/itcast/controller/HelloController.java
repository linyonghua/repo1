package cn.itcast.controller;

import cn.itcast.domin.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * 控制器
 *
 * @author rt
 */
@Controller
public class HelloController {
    /**
     * 接收请求
     *
     * @return
     */
    @RequestMapping(value = "/hh")
    public String sayHello(User user) {
        System.out.println("Hello SpringMVC!!");
        System.out.println(user.getUsername());
        System.out.println(user.getpassword());
        System.out.println(user);
        //System.out.println(user.getAccount().getMoney());
        return "success";
    }

    /**
     * 模拟从数据库中查询的数据
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/cc")
    public String addHello(Model model) {
// 模拟从数据库中查询的数据
        User user = new User();
        user.setUsername("张三");
        user.setpassword("123");
        user.setAge(34);
        //user.setBirthday(new Date());
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/voidHello")
    public void voidHello(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(request.getContextPath());
        //request.getRequestDispatcher("WEB-INF/pages/servlet.jsp").forward(request,response);
        //response.sendRedirect(request.getContextPath()+"/index.jsp");
        response.setContentType("text/html;charset=UTF-8");
        String contextPath = request.getContextPath();
        response.getWriter().print("hi好啊" + contextPath);


    }

    /**
     * 返回值是ModelAndView对象
     */
    @RequestMapping(value = "/getModelAndView")
    public ModelAndView getModelAndView() {
// 模拟从数据库中查询的数据
        ModelAndView ma = new ModelAndView();
        User user = new User();
        user.setUsername("张三");
        user.setpassword("123");
        user.setAge(34);
        //user.setBirthday(new Date());
        ma.addObject(user);

        return ma;
    }

    /**
     * 异步请求
     */
    @RequestMapping(value = "/getajax")
    public void getajax(@RequestBody String body,HttpServletResponse response) throws IOException {
        System.out.println(body);

        response.getWriter().print(body);
    }

    /**
     * 文件上传
     */
    @RequestMapping(value = "/uploadFile")
    public String uploadFile(HttpServletRequest request) throws Exception {
        // 先获取到要上传的文件目录???
        String path = request.getSession().getServletContext().getRealPath("/upload");
        // 创建File对象，一会向该路径下上传文件

        File file = new File(path);
        System.out.println(path);

        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()){
            file.mkdir();
        }
        // 创建磁盘文件项工厂???
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //factory.setRepository(new File("d:\\tem"));//设置临时目录
        //factory.setSizeThreshold(10*1024*1024*1024);//设置 缓冲区大小
        //获得文件解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(100*1024*1024);//单个文件大小
        upload.setSizeMax(1000*1024*1024);//总大小
        upload.setHeaderEncoding("utf-8");
        // 解析request对象
        List<FileItem> fileItems = upload.parseRequest(request);
        // 遍历
        for (FileItem fileItem : fileItems) {
            // 判断文件项是普通字段，还是上传的文件
            if (fileItem.isFormField()){

            }else {
                // 获取到上传文件的名称
                String name = fileItem.getName();
                System.out.println(name);
                String fname = UUID.randomUUID().toString().replaceAll("-", "");
                name =  fname+name;
                InputStream in =fileItem.getInputStream();
                // 上传文件项
                OutputStream out = new FileOutputStream(file+"/"+name);
                //读取和写入
                int len=0;
                byte[] b =new byte[1024];
                while ((len=in.read(b))!=-1){

                    //System.out.println((char)len);
                    out.write(b,0,len);
                }


                // 上传文件
                //fileItem.write(new File(file,name));
                //
                //删除临时文件
                out.close();
                in.close();
                //fileItem.write(new File(""));
                fileItem.delete();
            }
        }

        return "success";
    }

    /**
     *
     */
    @RequestMapping(value = "/geterror")
    public void geterror() {
        int i=9;
//        try {
//           int a=i/0;
//        }catch (ResourceIOException e){
//            //throw("");
//        }
    }

}
