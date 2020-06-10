package com.yang.text;

import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.RomanList;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Text07.
 * 文档小标题
 * @author Yang 2020-06-04 17:00
 */
public class Text07 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Text07.pdf"));
        document.open();
        // 有序的, 20为字与符号之间的距离
        List list1 = new List(List.ORDERED, 20);
        list1.add(new ListItem("the lazy dog"));
        document.add(list1);

        // 无序的
        List list2 = new List(List.UNORDERED, 10);
        document.add(list2);

        // 设置特殊符号， 这个是字母， 有序
        List list3 = new List(List.ORDERED, List.ALPHABETICAL,10);
        list3.add(new ListItem("the fence1"));
        list3.add(new ListItem("the fence2"));
        list3.add(new ListItem("the fence3"));
        document.add(list3);

        // 设置特殊符号
        List list4 = new List(List.UNORDERED, 30);
        list4.setListSymbol("----->");
        // 缩进
        list4.setIndentationLeft(10);
        list4.add(new ListItem("the lazy dog"));
        document.add(list4);

        List list5 = new List(List.ORDERED, 20);
        // 以11开始， 12，13，14。。。
        list5.setFirst(11);
        document.add(list5);

        List list = new List(List.UNORDERED, 10);
        list.setListSymbol(new Chunk("*"));
        list.add(list1);
        list.add(list3);
        list.add(list5);
        document.add(list);

        RomanList romanList = new RomanList(20);
        romanList.add(new ListItem("the lazy dog"));
        romanList.add(new ListItem("the lazy dog"));
        document.add(romanList);
        document.close();
    }
}
