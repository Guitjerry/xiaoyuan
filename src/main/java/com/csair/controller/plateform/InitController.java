package com.csair.controller.plateform;
import com.csair.good.entity.TbAttr;
import com.csair.good.repository.TbAttrRepository;
import com.csair.util.ExcelConfig;
import com.csair.util.JsonUtilTemp;
import com.csair.util.JxlExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * 初始化controller
 */
@Controller
@RequestMapping(value="/pc")
public class InitController {
    @Autowired
    private TbAttrRepository tbAttrRepository;
    @RequestMapping(value="/index")
    public String index(){
        return "pc/index";

    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        return "pc/login";
    }
    @RequestMapping(value = "/loginsure",method = RequestMethod.POST)
    public void loginsure(HttpServletRequest request, HttpServletResponse response, String username, String password, String requesturi){
        if(StringUtils.isEmpty(username)){
            JsonUtilTemp.returnFailJson(response,"账户不能为空!");
            return;
        }
        if(StringUtils.isEmpty(password)){
            JsonUtilTemp.returnFailJson(response,"密码不能为空!");
            return;
        }
        //测试账户
//        if("admin".equals(username)&&"123".equals(password)){
//            //保存到session
//            request.getSession().setAttribute("username","admin");
//            JsonUtilTemp.returnSucessJson(response,"成功登录系统");
//            return;
//        }

        if(username.equals("admin")&&password.equals("123")){
            //保存到session
            request.getSession().setAttribute("username","admin");
            JsonUtilTemp.returnSucessJson(response,"成功登录系统");
        }else{
            JsonUtilTemp.returnFailJson(response,"账户或者密码错误!");
        }
    }
    /**
     * 初始化导入
     */
    @RequestMapping("/initData")
    public void initData(HttpServletRequest request,HttpServletResponse response){
        //解析对应配置文件，封装到对象
        String filePath = InitController.class.getClassLoader().getResource("init.xls").getPath();
        List<List<Object>> listob = null;
        File file = new File(filePath);
        try {
            InputStream in = new FileInputStream(file);
            List<Object> objects = commonImportBack(in,"upfile","excelConfig.xml","tb_attr",new TbAttr());
            for(Object object:objects){
                TbAttr tbAttr = (TbAttr) object;
                List<TbAttr> tbAttrs = tbAttrRepository.findAllByCode(tbAttr.getCode());
                //更新
                if(tbAttrs!=null&&tbAttrs.size()>0){
                    TbAttr tbAttrRe = tbAttrs.get(0);
                    tbAttr.setId(tbAttrRe.getId());
                    tbAttrRepository.saveAndFlush(tbAttr);
                }else{
                    //插入
                    tbAttrRepository.save(tbAttr);
                }


            }
            JsonUtilTemp.returnSucessJson(response,"导入数据成功");

        } catch (Exception e) {
            e.printStackTrace();
            JsonUtilTemp.returnExceptionJson(response,e.getMessage());
        }



    }
    public List<Object> commonImportBack(InputStream in,String filename,String configxml,String tablename,Object target){
        List<Object> reportExcelDatas = new ArrayList<Object>();

        //反射解析得到相应的对象集合
        try{
            //解析对应配置文件，封装到对象
            String filePath = InitController.class.getClassLoader().getResource(configxml).getPath();

            ExcelConfig excelConfig = new JxlExcelUtil().combineExcelConfig(filePath,tablename);
            //反射解析得到相应的对象集合
            List<List<Object>> listob = new JxlExcelUtil().getBankListByJXLExcel(in,null, target,filePath,excelConfig);
            if(listob!=null&&listob.size()>0){
                for(List<Object> mainobj:listob){
                    for(Object obj:mainobj){
                        reportExcelDatas.add( target.getClass().cast(obj));
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return reportExcelDatas;
    }
    public List<Object> commonImport(HttpServletRequest request,String filename,String configxml,String tablename,Object target){
        MultipartFile file = null;
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        file = multipartHttpServletRequest.getFile(filename);
        List<Object> reportExcelDatas = new ArrayList<Object>();
        //反射解析得到相应的对象集合
        try{
            //解析对应配置文件，封装到对象
            String filePath = InitController.class.getClassLoader().getResource(configxml).getPath();

            ExcelConfig excelConfig = new JxlExcelUtil().combineExcelConfig(filePath,tablename);
            //反射解析得到相应的对象集合
            List<List<Object>> listob = new JxlExcelUtil().getBankListByJXLExcel(file.getInputStream(),file.getOriginalFilename(), target,filePath,excelConfig);
            if(listob!=null&&listob.size()>0){
                for(List<Object> mainobj:listob){
                    for(Object obj:mainobj){
                        reportExcelDatas.add( target.getClass().cast(obj));
                    }
                }
                request.setAttribute("flows",reportExcelDatas);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return reportExcelDatas;
    }
}
