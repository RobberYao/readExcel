package com.poi.readexcel;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;


// TODO: Auto-generated Javadoc
/**
 * Excel超大数据读取，抽象Excel2007读取器，excel2007的底层数据结构是xml文件，采用SAX的事件驱动的方法解析
 * xml，需要继承DefaultHandler，在遇到文件内容时，事件会触发，这种做法可以大大降低 内存的耗费，特别使用于大数据量的文件.
 *
 * @version 2014-9-2
 */
public abstract class ExcelReader extends DefaultHandler {

  /** The sst. */
  // 共享字符串表
  private SharedStringsTable sst;

  /** The last contents. */
  // 上一次的内容
  private String lastContents;

  /** The next is string. */
  private boolean nextIsString;

  /** The sheet index. */
  private int sheetIndex = -1;

  /** The row list. */
  private List<String> rowList = new ArrayList<String>();

  /** The cur row. */
  // 当前行
  private int curRow = 0;

  /** The cur col. */
  // 当前列
  private int curCol = 0;

  /** The date flag. */
  // 日期标志
  private boolean dateFlag;

  /** The number flag. */
  // 数字标志
  private boolean numberFlag;

  /** The is T element. */
  private boolean isTElement;

  /**
   * 测试.
   *
   * @param args the arguments
   * @throws Exception the exception
   */
  public static void main(String[] args) throws Exception {

    String file = "F:/table.xlsx";
    String file2 = "E:/simple.xlsx";
    ExcelReader reader = new ExcelReader() {
      public void getRows(int sheetIndex, int curRow, List<String> rowList) {

        //System.out.println("Sheet:" + sheetIndex + ", Row:" + curRow + ", Data:" + rowList);
        System.out.println("Data:" + rowList.get(0));
      }
    };

    reader.process(file2, 1);

  }

  /**
   * 遍历工作簿中所有的电子表格.
   *
   * @param filename the filename
   * @throws Exception the exception
   */
  public void process(String filename) throws Exception {
    OPCPackage pkg = OPCPackage.open(filename);
    XSSFReader r = new XSSFReader(pkg);
    SharedStringsTable sst = r.getSharedStringsTable();
    XMLReader parser = fetchSheetParser(sst);
    Iterator<InputStream> sheets = r.getSheetsData();
    while (sheets.hasNext()) {
      curRow = 0;
      sheetIndex++;
      InputStream sheet = sheets.next();
      InputSource sheetSource = new InputSource(sheet);
      parser.parse(sheetSource);
      sheet.close();
    }
  }

  /**
   * 只遍历一个电子表格，其中sheetId为要遍历的sheet索引，从1开始，1-3.
   *
   * @param filename the filename
   * @param sheetId the sheet id
   * @throws Exception the exception
   */
  public void process(String filename, int sheetId) throws Exception {
    OPCPackage pkg = OPCPackage.open(filename);
    XSSFReader r = new XSSFReader(pkg);
    SharedStringsTable sst = r.getSharedStringsTable();
    XMLReader parser = fetchSheetParser(sst);
    // 根据 rId# 或 rSheet# 查找sheet
    InputStream sheet2 = r.getSheet("rId" + sheetId);
    sheetIndex++;
    InputSource sheetSource = new InputSource(sheet2);
    parser.parse(sheetSource);
    sheet2.close();
  }

  /**
   * Fetch sheet parser.
   *
   * @param sst the sst
   * @return the XML reader
   * @throws SAXException the SAX exception
   */
  public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
    XMLReader parser = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
    this.sst = sst;
    parser.setContentHandler(this);
    return parser;
  }

  /**
   * Start element.
   *
   * @param uri the uri
   * @param localName the local name
   * @param name the name
   * @param attributes the attributes
   * @throws SAXException the SAX exception
   * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String,
   *      java.lang.String, org.xml.sax.Attributes)
   */
  public void startElement(String uri, String localName, String name, Attributes attributes)
      throws SAXException {

    // System.out.println("startElement: " + localName + ", " + name + ", "
    // + attributes);

    // c => 单元格
    if ("c".equals(name)) {
      // 如果下一个元素是 SST 的索引，则将nextIsString标记为true
      String cellType = attributes.getValue("t");
      if ("s".equals(cellType)) {
        nextIsString = true;
      } else {
        nextIsString = false;
      }
      // 日期格式
      String cellDateType = attributes.getValue("s");
      if ("1".equals(cellDateType)) {
        dateFlag = true;
      } else {
        dateFlag = false;
      }
      String cellNumberType = attributes.getValue("s");
      if ("2".equals(cellNumberType)) {
        numberFlag = true;
      } else {
        numberFlag = false;
      }

    }
    // 当元素为t时
    if ("t".equals(name)) {
      isTElement = true;
    } else {
      isTElement = false;
    }

    // 置空
    lastContents = "";
  }

  /**
   * End element.
   *
   * @param uri the uri
   * @param localName the local name
   * @param name the name
   * @throws SAXException the SAX exception
   * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String,
   *      java.lang.String)
   */
  public void endElement(String uri, String localName, String name) throws SAXException {

    // System.out.println("endElement: " + localName + ", " + name);

    // 根据SST的索引值的到单元格的真正要存储的字符串
    // 这时characters()方法可能会被调用多次
    if (nextIsString) {
      try {
        int idx = Integer.parseInt(lastContents);
        lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
      } catch (Exception e) {
        //
      }
    }
    // t元素也包含字符串
    if (isTElement) {
      String value = lastContents.trim();
      rowList.add(curCol, value);
      curCol++;
      isTElement = false;
      // v => 单元格的值，如果单元格是字符串则v标签的值为该字符串在SST中的索引
      // 将单元格内容加入rowlist中，在这之前先去掉字符串前后的空白符
    } else if ("v".equals(name)) {
      String value = lastContents.trim();
      value = value.equals("") ? " " : value;
      try {
        // 日期格式处理
        if (dateFlag) {
          Date date = HSSFDateUtil.getJavaDate(Double.valueOf(value));
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          value = dateFormat.format(date);
        }
        // 数字类型处理
        if (numberFlag) {
          BigDecimal bd = new BigDecimal(value);
          value = bd.setScale(3, BigDecimal.ROUND_UP).toString();
        }
      } catch (Exception e) {
        // 转换失败仍用读出来的值
      }
      rowList.add(curCol, value);
      curCol++;
    } else {
      // 如果标签名称为 row ，这说明已到行尾，调用 optRows() 方法
      if (name.equals("row")) {
        getRows(sheetIndex + 1, curRow, rowList);
        rowList.clear();
        curRow++;
        curCol = 0;
      }
    }

  }

  /**
   * Characters.
   *
   * @param ch the ch
   * @param start the start
   * @param length the length
   * @throws SAXException the SAX exception
   * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
   */
  public void characters(char[] ch, int start, int length) throws SAXException {
    // 得到单元格内容的值
    lastContents += new String(ch, start, length);
  }

  /**
   * 获取行数据回调.
   *
   * @param sheetIndex the sheet index
   * @param curRow the cur row
   * @param rowList the row list
   * @return the rows
   */
  public abstract void getRows(int sheetIndex, int curRow, List<String> rowList);

}
