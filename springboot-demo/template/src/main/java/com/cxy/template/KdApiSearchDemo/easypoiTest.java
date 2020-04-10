package com.cxy.template.KdApiSearchDemo;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: template
 * @description: easypoi
 * @author: cuixy
 * @create: 2020-03-14 09:58
 **/
public class easypoiTest {


    public static void main(String[] args) throws Exception {

        TemplateExportParams params = new TemplateExportParams(
                "/Users/cuixiaoyan/Downloads/a.xls");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", "2014-12-25");


        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 4; i++) {
            Map<String, String> lm = new HashMap<String, String>();
            lm.put("id", i + 1 + "");
            lm.put("mingcheng", "设计");
            lm.put("bianma", "A001");
            lm.put("zijin", i * 10000 + "");
//            lm.put("bianma", "A001");
//            lm.put("mingcheng", "设计");
//            lm.put("xiangmumingcheng", "EasyPoi " + i + "期");
//            lm.put("quancheng", "开源项目");
//            lm.put("sqje", i * 10000 + "");
//            lm.put("hdje", i * 10000 + "");

            listMap.add(lm);
        }
        map.put("maplist", listMap);


        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        File savefile = new File("/Users/cuixiaoyan/Downloads/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("/Users/cuixiaoyan/Downloads/b.xls");
        workbook.write(fos);
        fos.close();


    }


}