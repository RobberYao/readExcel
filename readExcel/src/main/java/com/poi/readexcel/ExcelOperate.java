package com.poi.readexcel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


// TODO: Auto-generated Javadoc
/**
 * The Class ExcelOperate.
 */
public class ExcelOperate {

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    Sheet sheet;
    Workbook book;
    Cell cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, cell10, cell11, cell12, cell13;
    JSONArray array = new JSONArray();
    try {
      // 为要读取的excel文件名
      book = Workbook.getWorkbook(new File("F:\\table1.xls"));

      // 获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
      sheet = book.getSheet(0);

      for (int i = 1; i < sheet.getRows(); i++) {
        // 获取每一行的单元格
        cell1 = sheet.getCell(0, i);// （列，行）
        cell2 = sheet.getCell(1, i);
        cell3 = sheet.getCell(2, i);
        cell4 = sheet.getCell(3, i);
        cell5 = sheet.getCell(4, i);
        cell6 = sheet.getCell(5, i);
        cell7 = sheet.getCell(6, i);
        cell8 = sheet.getCell(7, i);
        cell9 = sheet.getCell(8, i);
        cell10 = sheet.getCell(9, i);
        cell11 = sheet.getCell(10, i);
        cell12 = sheet.getCell(11, i);
        cell13 = sheet.getCell(12, i);
        if ("".equals(cell1.getContents())) {
          break;
        }
        JSONObject object = new JSONObject();
        object.put("保联产品ID", cell1.getContents());
        object.put("险种名称", cell2.getContents());
        object.put("代理人代码", cell3.getContents());
        object.put("保单号", cell4.getContents());
        object.put("保险费", cell5.getContents());
        object.put("保险金额", cell5.getContents());
        object.put("交费期间", cell5.getContents());
        object.put("保单状态", cell5.getContents());
        object.put("投保日期", cell5.getContents());
        object.put("保险起期", cell5.getContents());
        object.put("保险止期", cell5.getContents());
        object.put("投保人姓名", cell5.getContents());
        object.put("被保险人姓名", cell5.getContents());
        array.add(object);
      }
      for (int i = 1; i < array.size(); i++) {
        
        System.out.println(array.get(i));
      }
      System.out.println(array.size());
      System.out.println("over");
      book.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
