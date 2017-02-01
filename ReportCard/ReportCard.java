package com.example.rishabhgoyal.reportcard;

/**
 * Created by Rishabh Goyal on 01-02-2017.
 */

public class ReportCard {

    private char Section;
    private String Name;
    private int OS_Marks;
    private int CSA_Marks;
    private int ADBMS_marks;
    private int DS_marks;
    private int Sum;
    public ReportCard(char section,String name,int Marks1,int Marks2,
                      int Marks3,int Marks4){
        Name= name;
        Section=section;
        OS_Marks=Marks1;
        CSA_Marks=Marks2;
        ADBMS_marks=Marks3;
        DS_marks=Marks4;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name){
        Name=name;
    }

    public char getSection(){
        return Section;
    }

    public void setSection(char section){
        Section=section;
    }

    public int getOS_Marks(){
        return OS_Marks;
    }

    public void setOS_Marks(int marks){
        OS_Marks=marks;
    }

    public int getCSA_Marks(){
        return CSA_Marks;
    }

    public void setCSA_Marks(int marks){
        CSA_Marks=marks;
    }

    public int getADBMS_marks(){
        return ADBMS_marks;
    }

    public void setADBMS_marks(int marks){
        ADBMS_marks=marks;
    }

    public int getDS_Marks(){
        return DS_marks;
    }

    public void setDS_marks(int marks){
        DS_marks=marks;
    }

    public int getSum(){
        Sum=OS_Marks+CSA_Marks+ADBMS_marks+DS_marks;
        return Sum;
    }

    public double getpercentage(){
        return Sum/4;
    }

    @Override
    public String toString() {
        return "Result { " +
                "OS = " + OS_Marks +
                " CSA = " + CSA_Marks +
                " ADBMS = " + ADBMS_marks +
                " DS = " + DS_marks +
                " SUM = " + Sum +
                " }";
    }
}
