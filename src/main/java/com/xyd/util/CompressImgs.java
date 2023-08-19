package com.xyd.util;

import com.spire.xls.ExcelPicture;
import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CompressImgs {
    public static void main(String[] args) {
        String srcFilePath = "E:\\project\\wj\\HT3533-HACCIVEE-312896-313000-312897-尾查报告.xlsx";
        com.spire.xls.Workbook wb = new Workbook();
        //加载Excel测试文档
        wb.loadFromFile(srcFilePath);
        //遍历工作表
        for (int s = 0; s < wb.getWorksheets().getCount(); s++) {
            Worksheet sheet = wb.getWorksheets().get(s);
            //遍历工作表中的图片
            for (int p = 0; p < sheet.getPictures().getCount(); p++) {
                ExcelPicture pic = sheet.getPictures().get(p);
                pic.compress(40);//压缩图片
            }
        }
        Date  date = new Date();
        //保存文档
        wb.saveToFile("E:\\project\\wj\\CompressExecl"+date.getTime()+".xlsx", FileFormat.Version2013);
        }
    }




