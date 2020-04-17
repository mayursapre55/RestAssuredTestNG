/**
 * 
 */
package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author gslab
 *
 */
public class ExcelUtility {

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowcount(String xlfile,String xlsheet) throws IOException {
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
		
	}
	
	public static int getCellcount(String xlfile,String xlsheet,int rownum) throws IOException {
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fis.close();
		return cellcount;
	}
	
	public static String getCelldata(String xlfile,String xlsheet,int rownum,int cellnum) throws IOException {
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(cellnum);
		String data;
		try {
			DataFormatter format=new DataFormatter();
			String celldata=format.formatCellValue(cell);
			return celldata;
		}
		catch(Exception e) {
			data="";
		}
		wb.close();
		fis.close();
		return data;
	}
	
	public static void setCelldata(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException {
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		
		fos=new FileOutputStream(xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		
		
		
		
		
	}
}
