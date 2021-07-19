package com.swap.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLUtils {

	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlFile, String xlSheet) {

		
		try {
			fis = new FileInputStream(xlFile);
			workbook = new XSSFWorkbook(fis);
			
		} catch (EncryptedDocumentException | IOException e) {
			System.out.println(e.getMessage());
		} 
		sheet = workbook.getSheet(xlSheet);
		int rowCount = sheet.getLastRowNum();
		try {
			workbook.close();
			fis.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return rowCount;
	}

	public static int getCellCount(String xlFile, String xlSheet,int rowNum) {
	
		try {
			fis = new FileInputStream(xlFile);
			workbook = new XSSFWorkbook(fis);
			
		} catch (EncryptedDocumentException | IOException e) {
			System.out.println(e.getMessage());
		} 
		sheet = workbook.getSheet(xlSheet);
		int cellCount = sheet.getRow(rowNum).getLastCellNum();
		try {
			workbook.close();
			fis.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return cellCount;
	}

	public static String getCellData(String xlFile, String xlSheet, int rowNum, int cellNum) {
		String data = "";
		try {
			fis = new FileInputStream(xlFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(xlSheet);
			row = sheet.getRow(rowNum);
			cell = row.getCell(cellNum);

			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		} catch (EncryptedDocumentException | IOException e) {
			data = "";
			System.out.println(e.getMessage());
		} finally {
			try {
				workbook.close();
				fis.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return data;
	}

	public static void setCellData(String xlFile, String xlSheet, int rowNum, int cellNum, String data) {
		try {
			fis = new FileInputStream(xlFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(xlSheet);
			row = sheet.getRow(rowNum);
			cell = row.createCell(cellNum);
			cell.setCellValue(data);
			fos = new FileOutputStream(xlFile);
			workbook.write(fos);

		} catch (EncryptedDocumentException | IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				workbook.close();
				fis.close();
				fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
