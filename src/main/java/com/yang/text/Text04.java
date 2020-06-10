package com.yang.text;

import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Text04.
 * 实现外部链接
 * @author Yang 2020-06-04 16:41
 */
public class Text04 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Text04.pdf"));
        document.open();
        // 链接的内容
        Chunk chunk = new Chunk("Quick brown fox jumps over the lazy dog.");
        chunk.setAnchor("www.baidu.com");

        document.add(chunk);
        document.close();
    }
}
