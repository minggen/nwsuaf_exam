/**
 * 
 */
package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.entity.ExamInformation;
import com.entity.ExamMultiChoice;
import com.entity.ExamRecord;
import com.entity.ExamSingleChoice;
import com.entity.ExamTofChoice;

/**
 * @author Hongten
 * @created 2014-5-20
 */
public class ReadExcelUtils {

    public static List<ExamRecord> readStuXlsx(File file,String examId) throws IOException {
    	//System.out.println(file.toString());
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        ExamRecord examRecord = null;
        List<ExamRecord> list = new ArrayList<ExamRecord>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    examRecord = new ExamRecord();
                    XSSFCell no = xssfRow.getCell(0);
                    XSSFCell name = xssfRow.getCell(1);
                    XSSFCell password = xssfRow.getCell(2);
                    
                    //world
                    examRecord.setStudentNo((Integer.valueOf(getValue(no)))+"");
                    examRecord.setStudentName(getValue(name));
                    examRecord.setStudentPassword(getValue(password));
                    examRecord.setExamId(examId);
                    examRecord.setScoreSubmit(-1.0);
                    
                    list.add(examRecord);
                }
            }
        }
        return list;
    }

    public static List<ExamRecord> readStuXls(File file,String examId) throws IOException {
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        ExamRecord examRecord = null;
        List<ExamRecord> list = new ArrayList<ExamRecord>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    examRecord = new ExamRecord();
                    HSSFCell no = hssfRow.getCell(0);
                    HSSFCell name = hssfRow.getCell(1);
                    HSSFCell password = hssfRow.getCell(2);

                    examRecord.setStudentNo(getValue(no));
                    examRecord.setStudentName(getValue(name));
                    examRecord.setStudentPassword(getValue(password));
                    examRecord.setExamId(examId);
                    examRecord.setScoreSubmit(-1.0);
                    
                    list.add(examRecord);
                }
            }
        }
        return list;
    }
    
   
    public static List<ExamTofChoice> readTofXlsx(File file,String teacherId) throws IOException {
    	//System.out.println(file.toString());
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        ExamTofChoice examTofChoice = null;
        List<ExamTofChoice> list = new ArrayList<ExamTofChoice>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                	examTofChoice = new ExamTofChoice();
                	XSSFCell subjectName = xssfRow.getCell(0);
                    XSSFCell question = xssfRow.getCell(1);
                    XSSFCell answer = xssfRow.getCell(2);
                    XSSFCell analysis = xssfRow.getCell(3);
                    
                    
                    //获取该老师所有题目个数
                    examTofChoice.setTeacherId(teacherId);
                    examTofChoice.setTcQuestion(getValue(question));
                    examTofChoice.setTcAnswerCorrect(getValue(answer));
                    examTofChoice.setTcAnalysis(getValue(analysis));
                    examTofChoice.setSubjectName(getValue(subjectName));
                    
                    list.add(examTofChoice);
                }
            }
        }
        return list;
    }

    public static List<ExamTofChoice> readTofXls(File file,String teacherId) throws IOException {
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        ExamTofChoice examTofChoice = null;
        List<ExamTofChoice> list = new ArrayList<ExamTofChoice>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                	examTofChoice = new ExamTofChoice();
                    HSSFCell question = hssfRow.getCell(0);
                    HSSFCell answer = hssfRow.getCell(1);
                    HSSFCell analysis = hssfRow.getCell(2);
                    HSSFCell subjectName = hssfRow.getCell(3);
                    
                    examTofChoice.setTeacherId(teacherId);
                    examTofChoice.setTcQuestion(getValue(question));
                    examTofChoice.setTcAnswerCorrect(getValue(answer));
                    examTofChoice.setTcAnalysis(getValue(analysis));
                    examTofChoice.setSubjectName(getValue(subjectName));
                    
                    list.add(examTofChoice);
                }
            }
        }
        return list;
    }
    
    
    public static List<ExamMultiChoice> readMulXlsx(File file,String teacherId) throws IOException {
    	//System.out.println(file.toString());
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        ExamMultiChoice examMultiChoice = null;
        List<ExamMultiChoice> list = new ArrayList<ExamMultiChoice>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                	examMultiChoice = new ExamMultiChoice();
                    
                    XSSFCell subjectName = xssfRow.getCell(0);
                    XSSFCell question = xssfRow.getCell(1);
                    XSSFCell answerA = xssfRow.getCell(2);
                    XSSFCell answerB = xssfRow.getCell(3);
                    XSSFCell answerC = xssfRow.getCell(4);
                    XSSFCell answerD = xssfRow.getCell(5);
                    XSSFCell answerE = xssfRow.getCell(6);
                    XSSFCell answer = xssfRow.getCell(7);
                    XSSFCell analysis = xssfRow.getCell(8);
                    
                    //获取该老师所有题目个数
                    examMultiChoice.setTeacherId(teacherId);
                    examMultiChoice.setMcQuestion(getValue(question));
                    examMultiChoice.setMcAnswerA(getValue(answerA));
                    examMultiChoice.setMcAnswerB(getValue(answerB));
                    examMultiChoice.setMcAnswerC(getValue(answerC));
                    examMultiChoice.setMcAnswerD(getValue(answerD));
                    examMultiChoice.setMcAnswerE(getValue(answerE));
                    examMultiChoice.setMcAnswerCorrect(getValue(answer));
                    examMultiChoice.setMcAnalysis(getValue(analysis));
                    examMultiChoice.setSubjectName(getValue(subjectName));
                    
                    list.add(examMultiChoice);
                }
            }
        }
        return list;
    }

    public static List<ExamMultiChoice> readMulXls(File file,String teacherId) throws IOException {
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        ExamMultiChoice examMultiChoice = null;
        List<ExamMultiChoice> list = new ArrayList<ExamMultiChoice>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                	examMultiChoice = new ExamMultiChoice();
                    
                    HSSFCell subjectName = hssfRow.getCell(0);
                    HSSFCell question = hssfRow.getCell(1);
                    HSSFCell answerA = hssfRow.getCell(2);
                    HSSFCell answerB = hssfRow.getCell(3);
                    HSSFCell answerC = hssfRow.getCell(4);
                    HSSFCell answerD = hssfRow.getCell(5);
                    HSSFCell answerE = hssfRow.getCell(6);
                    HSSFCell answer = hssfRow.getCell(7);
                    HSSFCell analysis = hssfRow.getCell(8);
                    
                    //获取该老师所有题目个数
                    examMultiChoice.setTeacherId(teacherId);
                    examMultiChoice.setMcQuestion(getValue(question));
                    examMultiChoice.setMcAnswerA(getValue(answerA));
                    examMultiChoice.setMcAnswerB(getValue(answerB));
                    examMultiChoice.setMcAnswerC(getValue(answerC));
                    examMultiChoice.setMcAnswerD(getValue(answerD));
                    examMultiChoice.setMcAnswerE(getValue(answerE));
                    examMultiChoice.setMcAnswerCorrect(getValue(answer));
                    examMultiChoice.setMcAnalysis(getValue(analysis));
                    examMultiChoice.setSubjectName(getValue(subjectName));
                    
                    list.add(examMultiChoice);
                }
            }
        }
        return list;
    }
    
    
    public static List<ExamSingleChoice> readSinXlsx(File file,String teacherId) throws IOException {
    	//System.out.println(file.toString());
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        ExamSingleChoice examMultiChoice = null;
        List<ExamSingleChoice> list = new ArrayList<ExamSingleChoice>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                	examMultiChoice = new ExamSingleChoice();
                    
                    XSSFCell subjectName = xssfRow.getCell(0);
                    XSSFCell question = xssfRow.getCell(1);
                    XSSFCell answerA = xssfRow.getCell(2);
                    XSSFCell answerB = xssfRow.getCell(3);
                    XSSFCell answerC = xssfRow.getCell(4);
                    XSSFCell answerD = xssfRow.getCell(5);
                    XSSFCell answer = xssfRow.getCell(6);
                    XSSFCell analysis = xssfRow.getCell(7);
                    
                    //获取该老师所有题目个数
                    examMultiChoice.setTeacherId(teacherId);
                    examMultiChoice.setScQuestion(getValue(question));
                    examMultiChoice.setScAnswerA(getValue(answerA));
                    examMultiChoice.setScAnswerB(getValue(answerB));
                    examMultiChoice.setScAnswerC(getValue(answerC));
                    examMultiChoice.setScAnswerD(getValue(answerD));
                    examMultiChoice.setScAnswerCorrect(getValue(answer));
                    examMultiChoice.setScAnalysis(getValue(analysis));
                    examMultiChoice.setSubjectName(getValue(subjectName));
                    
                    list.add(examMultiChoice);
                }
            }
        }
        return list;
    }

    public static List<ExamSingleChoice> readSinXls(File file,String teacherId) throws IOException {
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        ExamSingleChoice examMultiChoice = null;
        List<ExamSingleChoice> list = new ArrayList<ExamSingleChoice>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                	examMultiChoice = new ExamSingleChoice();
                    
                    HSSFCell subjectName = hssfRow.getCell(0);
                    HSSFCell question = hssfRow.getCell(1);
                    HSSFCell answerA = hssfRow.getCell(2);
                    HSSFCell answerB = hssfRow.getCell(3);
                    HSSFCell answerC = hssfRow.getCell(4);
                    HSSFCell answerD = hssfRow.getCell(5);
                    HSSFCell answer = hssfRow.getCell(6);
                    HSSFCell analysis = hssfRow.getCell(7);
                    
                    //获取该老师所有题目个数
                    examMultiChoice.setTeacherId(teacherId);
                    examMultiChoice.setScQuestion(getValue(question));
                    examMultiChoice.setScAnswerA(getValue(answerA));
                    examMultiChoice.setScAnswerB(getValue(answerB));
                    examMultiChoice.setScAnswerC(getValue(answerC));
                    examMultiChoice.setScAnswerD(getValue(answerD));
                    examMultiChoice.setScAnswerCorrect(getValue(answer));
                    examMultiChoice.setScAnalysis(getValue(analysis));
                    examMultiChoice.setSubjectName(getValue(subjectName));
                    
                    list.add(examMultiChoice);
                }
            }
        }
        return list;
    }
    
    @SuppressWarnings("static-access")
    private static String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
        	String str =  String.valueOf(xssfRow.getNumericCellValue());
            if(str.endsWith(".0")) {
            	return str.substring(0, str.length()-2);
            }
            return str;
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    @SuppressWarnings("static-access")
    private static String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            String str =  String.valueOf(hssfCell.getNumericCellValue());
            if(str.endsWith(".0")) {
            	return str.substring(0, str.length()-2);
            }
            return str;
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}