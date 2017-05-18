package com.smscompanyme.smsproject;

/**
 *
 * @author Ernesto Juarez
 */
public class Schedule {
    private String day;
    private int timeStart,timeEnd;
    private Doctor doctor = new Doctor();
    private Patient patient = new Patient();
     
    Schedule(){
        
    }
    
    Schedule(Doctor doc){
        setDoctor(doc);
    }
    
    Schedule(Doctor doc, Patient pat){
        setDoctor(doc);
        setPatient(pat);
    }
    
    Schedule(Doctor doc, Patient pat, String day,
            int timein){
        this.doctor = doc;
        this.patient =pat;
        this.day =day;
        this.timeStart = timein;
    }
    
       
   Schedule(Doctor doc, Patient pat, String day,
            int timein, int timeout){
        setAppointment(doc,pat,day,timein,timeout);
    }
    
    public void setAppointment(Doctor doc, Patient pat,String day, int timein,int timeout){
        this.doctor=doc;
        this.patient=pat;
        this.day=day;
        this.timeStart=timein;
        this.timeEnd=timeout;
    }
    public void setAppointmentDateTime(String d, int t, int to){
        this.day = d;
        this.timeStart =t;
        this.timeEnd=to;
    }
    
    public void setDoctor(Doctor obj){
        doctor=obj;
    }
    public void setPatient(Patient obj){
        patient=obj;
    }
    public void setTime(int timein,int timeout){
        this.timeStart=timein;
        this.timeEnd=timeout;
    }
    public void setDay(String day){
        this.day =day;
    }
    
    // Get methods    
    public int getStartTime(){
        return timeStart;
    }

    public int getEndTime(){
        return this.timeEnd;
    }
    public String getDay(){
        return this.day;
    }
    
    public String getDoctorName(Doctor obj){
        return obj.getName();
    }
    
    public String getPatientName(Patient obj){
        return obj.getName();
    }
    
    
    //***************** Print methods 
    public void printAppointment(){
        System.out.println("----------------Appointment Information------------------");
        System.out.println("Doctor : " + doctor.getName()
                + "  " +  " Patient : " + patient.getName()+"\n");
        System.out.println("Appointment Time :\t  " + getDay()  + "  " +
                getStartTime() + " - " + getEndTime()+" hrs");
        
        System.out.println("---------------------------------------------------------");        
    }
    public String printAppointmentString(){
        String str = "----------------Appointment Information------------------\n"
                + "Doctor : " + doctor.getName() + "   " +  " Patient : " + patient.getName()
                + "\n" + "Appointment Time :\t  " + getDay()  + "  " +
                getStartTime() + " - " + getEndTime()+" hrs";
        
        return str;
    }   
        
}  // end of class

