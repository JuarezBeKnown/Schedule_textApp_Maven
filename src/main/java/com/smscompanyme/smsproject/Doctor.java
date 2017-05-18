package com.smscompanyme.smsproject;

import java.util.ArrayList;

/**
 *
 * @author Juarez
 */
public class Doctor {   
    public String name;// Doctor info
    private String licenseNumber;
    private String[] arrayDays; // Doctor Work Days
    static int arrayDayCount=0;
    ArrayList<Patient> patientArray = new ArrayList<Patient>();// Doctor Patient List
    static int patientCount =0;
    private int column; // used to set mySchedule
    private int row; // used to set mySchedule
    Schedule[ ][ ] mySchedule = new Schedule[10][5]; // 5 rows and 8 columns
    // row = time     ;   column = day
    
    // constructors
    public Doctor(){
        this.name="n/a";
        this.licenseNumber="Tx###";
    }
    
    public Doctor(String n){
        this.name=n;
        this.licenseNumber="Tx###";
    }
    
    public Doctor(String n, String txNum){
        this.name=n;
        this.licenseNumber=txNum;      
    }
       
    public Doctor(String n, String txNum, String[] days){
        this.name=n;
        this.licenseNumber=txNum;
        this.arrayDays=days;
    }
    //end of constructors
    
    // set method for values [name, ssn, workDays] 
    public void setName(String n){
        this.name =n;
    }
    
    public void setTxLicenseNum(String txNum){
        this.licenseNumber =txNum;
    }
    // accepts array of days only
    public void setWorkDayArray(String[] days){
        this.arrayDays = days;
    }
    
    // Add a patient List []
    public void addPatientList(ArrayList arrayPat){
        patientArray = arrayPat;        
        
    }
    // Add one patient to List[] through class static 
    public void addPatientToList(Patient obj,ArrayList pat){
        pat.add(obj);
        
        System.out.println("Added Patient " + obj.name + "To Dr. " +getName());
    }
    
    // 
    
    // Add Schedule to Schedule[]
    public void addSchduleToCalendar(Schedule obj){
        int tempColumn,tempRow,time;
        String tempDay;
        
        tempDay = obj.getDay();
        time = obj.getStartTime();
        tempColumn = getDayOfWeekIndex(tempDay);
        tempRow = getTimeIndex(time);
        
        mySchedule[tempRow][tempColumn] = obj;
    }
    
    // get methods [name, ssn, workDay[],
    public String getName(){
        return this.name;
    }

    public String geTxLicense(){
        return licenseNumber;
    }
    
    // return arrayDays = array[]
    public String[] getWorkDays(){
        return arrayDays;
    }  
    // return pat = 
    public ArrayList getPatientList(){
        return patientArray;
    }
    
    // get column index
    public int getDayOfWeekIndex(String day){
        if(day.equalsIgnoreCase("Monday")){
            column =0;
        }
        else if(day.equalsIgnoreCase("Tuesday")){
            column =1;
        }
        else if(day.equalsIgnoreCase("Wendsday")){
            column =2;
        }
        else if(day.equalsIgnoreCase("Thursday")){
            column =3;
        }
        else if(day.equalsIgnoreCase("Friday")){
            column =4;
        }
        else {
            System.out.println("!!!!!!!!ERROR DAY NOT FOUND");
        }
        return column;       
    }
    
    // get index of time of appointment
    public int getTimeIndex(int time){
        if(time == 800){
            row = 0;
        }
        else if(time == 900){
            row = 1;
        }
        else if(time == 1000){
            row = 2;
        }
        else if(time == 1100){
            row = 3;
        }
        else if(time == 1200){
            row = 4;
        }
        else if(time == 1300){
            row = 5;
        }
        else if(time == 1400){
            row = 6;
        }
        else if(time == 1500){
            row = 7;
        }
        else if(time == 1600){
            row = 8;
        }
        else if(time == 1700){
            row = 9;
        }
        else{
            System.out.println("ERROR : time index");
        }
        return row;
    }
    
    
    
    
    // ***************  Print Methods ******************** //
    // print list patientArray[] names only!
    public void printPatientList(){
        System.out.println("----------------Patient List for " + getName() + "---------------");
        for (Patient patient: patientArray) {
            System.out.println(patient.getName());
        }
        System.out.println("");     
    }
        
    // print list patientArray[] all information!
    public void printPatientListInfo(){
        System.out.println("----------------Patient List for " + getName() + "---------------");
        for (Patient patient: patientArray) {
            patient.printPatientInfo();
            System.out.println("");
        }
        System.out.println("");     
    }
    // print Doctor Work
    public void printWorkDays(){
        System.out.println("----------------Scheduled Work Days------------------");
        System.out.println("Doctor : " + getName() + "\n");
        
        for (String day: arrayDays) {
            System.out.print(day + "   ");
        }
        System.out.println("");
        
        System.out.println("------------------------------------------------------\n");
    }
    // Print Schedule array[] 
    public void printCalendar(){
        System.out.println("--------------Calendar for " + getName() + "---------------------\n\n");
        for(int i = 0; i < mySchedule.length; i++){
                for(int j = 0; j <mySchedule[i].length; j++){    
                    if(mySchedule[i][j]!=null){
                       mySchedule[i][j].printAppointment(); 
                       System.out.println(" ");
                    }
                    else 
                      printEmptyCalendarSlot(i,j);
                 
            }
            System.out.println();
        }      
    }
    
    // help the print calendar
    public void printEmptyCalendarSlot(int i, int j){
        String dayOfWeek;
        int timeSlot;
        switch (j) {
            case 0:  dayOfWeek="Monday";
                     break;
            case 1:  dayOfWeek= "Tuesday";
                     break;
            case 2:  dayOfWeek = "Wednesday";
                     break;
            case 3:  dayOfWeek = "Thursday";
                     break;
            case 4:  dayOfWeek = "Friday";
                     break;
            default: dayOfWeek = "Invalid month";
                     break;
        }
        switch(i){
            case 0:  timeSlot = 800;
                     break;
            case 1:  timeSlot = 900;
                     break;
            case 2:  timeSlot = 1000;
                     break;
            case 3:  timeSlot = 1100;
                     break;
            case 4:  timeSlot = 1200;
                     break;
            case 5:  timeSlot = 1300;
                     break;
            case 6:  timeSlot = 1400;
                     break;
            case 7:  timeSlot = 1500;
                     break;
            case 8:  timeSlot = 1600;
                     break;
            case 9:  timeSlot = 1700;
                     break;
            default: timeSlot = 0000;
                     break;
        } // end of switch
        System.out.println("OPEN "+dayOfWeek + " " + timeSlot + "hrs");
        
    } // end of printEmptyCalendar method
    
} // end of class
