package com.smscompanyme.smsproject;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class NewMain {
  // Variables Global
  private static String docName,textMessage;
  private static String name,ssn,phone,street,city,state,zip,insurance,expDate;
  //For Input from Menu For Date and Time for Menue
  private static int option;
  private static final Date date = new Date();
  private static final DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
  
  
  // !!!!!!DONT SHOW Find your Account Sid and Token at twilio.com/user/account
  private static final String ACCOUNT_SID = "";
  private static final String AUTH_TOKEN = "";

  // Clinic Has # Doctors On Staff
  // Clinic is Open 5 Days A week
  static String[] workDays = { "Monday", "Tuesday" ,"Wendsday","Thursday","Friday"};
  private static final Doctor doctor1 = new Doctor("Dr Juarez", "Tx423",workDays);
  private static final Doctor doctor2 = new Doctor("Dr Hanley", "Tx455",workDays);
  
  // Clinic has 10 Patients On File
    static Patient patient1 = new Patient("Patrick Juarez","637031267","210-438-7231",
                "1702 Farley","Harlingen","Tx","7550","Blue Cross and Blue Shield","01/2018");
    static Patient patient2 = new Patient("Chris Peterson","637032211","210-432-7000",
                "2000 Saint Bernard","Brownsville","Tx","7550","FirstCare","02/2018");
    static Patient patient3 = new Patient("Mona Peterson","637038888","210-324-5432",
                "4893 N Hwy 80","Nixon","Tx","78140","Blue Cross and Blue Shield","03/2017");
    static Patient patient4 = new Patient("Pete Conor","637034321","956-438-7231",
                "1800 Broadway","San Antonio","Tx","78249","Blue Cross and Blue Shield","05/2018");
    static Patient patient5 = new Patient("Patricia Rodriguez","637031234","956-438-7399",
                "1801 S France","Harlingen","Tx","78550","n/a","n/a");
    static Patient patient6 = new Patient("Daniel Palm","637039876","956-324-2311",
                "1804 Water Leaf","Harlingen","Tx","78551","Blue Cross and Blue Shield","05/2018");
    static Patient patient7 = new Patient("Michelle Palm","637036789","956-324-4567",
                "1908 16th Street","Harlingen","Tx","78553","FirstCare","05/2018");
    static Patient patient8 = new Patient("Rodger Puentes","637034567","956-456-8766",
                "1910 El Paso Dr","Harlingen","Tx","78550","Blue Cross and Blue Shield","02/2018");
    static Patient patient9 = new Patient("Victoria Puentes","6377654","210-202-7231",
                "2104 E Hail","Brownsville","Tx","78558","Oscar Insurance","02/2018");
    static Patient patient10 = new Patient("Victoria Puentes","637031029","210-567-1254",
                "421 Pierre Rd","San Benito","Tx","78456","Oscar Insurance","02/2018");
    // add Patient List to Doctor -> Doctor class
    // Patient list distrubted amoungst the two doctors
    static    ArrayList<Patient> drJuarezPatients = new ArrayList(){{
            add(patient1);
            add(patient2);
            add(patient3);
            add(patient4);
            add(patient5);
        }};;
        
    static     ArrayList<Patient> drHanleyPatients = new ArrayList(){{
            add(patient6);
            add(patient7);
            add(patient8);
            add(patient9);
            add(patient10);
        }};;

 
            
   
  public static void textReminder(String mess){
      Message message = Message.creator
        (new PhoneNumber("+12104387231"),new PhoneNumber("+12108803063"),mess).create();
    
      System.out.println(message.getSid());
  }

  public static int mainMenu(){    
      String[] buttons =  { "exit","+ Patient", "+ Appointment", "Schedule","Send Text"};
      String welcome = "Welcome To Schedule APP  | Make Scheduling Easy | " + sdf.format(date);
      option = JOptionPane.showOptionDialog(null,
            welcome,
            "MySchedule.com",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.DEFAULT_OPTION,
            null,
            buttons,
            buttons[2]);  

    System.out.println(option); 
    return option; 
  }

  public static void createPatientMenu(){    
    // fill the variables
    String insList [] = {"Aetna","AARP","Assurant","Blue Cross Blue Shield",
    "Celtic","Cigna","Companion","Humana","John Alden","Scott White",
    "Standard Security","Time Health Ins","Time Short Health","Unicare",
    "United Health Insurance","WorldIns Express Meds"};
    
    name =  JOptionPane.showInputDialog(null,"Enter Name: ");
    ssn = JOptionPane.showInputDialog(null,"Enter Social \n "
            + "Format 9 Numbers : 111223333");
    phone = JOptionPane.showInputDialog(null,"Enter Phone: \n" 
            + "Format 10 Numbers: 2101112222");
    street = JOptionPane.showInputDialog(null,"Enter Street Name: ");
    city = JOptionPane.showInputDialog(null,"Enter City: ");
    state = JOptionPane.showInputDialog(null,"Enter State: ");
    zip = JOptionPane.showInputDialog(null,"Enter Zip: ");
    insurance = (String)JOptionPane.showInputDialog(null,"Choose Provider","Insurance List",
            JOptionPane.INFORMATION_MESSAGE,null,insList,insList[0]);
    expDate = JOptionPane.showInputDialog(null,"Enter Expiration Date \n"
            + "Format : MM/YY");
  }
  public static void chooseDoctor(){
    // Create Doctor Option
    String [] staff = {"Dr. Juarez", "Dr. Hanley"};
    // Create Schedule 
    docName = (String)JOptionPane.showInputDialog(null,"Choose one", "Doctor on Staff",
    JOptionPane.INFORMATION_MESSAGE, null,
    staff, staff[0]);
    System.out.println("Choose Doctor Method "+ docName);
  }
  
  public static void main(String[] args) {
    // IMPORTANT!!
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    // local app variables 
    int userchoice;
    //set Primary Doctors
    // Doctor is now the primary physician
    doctor1.addPatientList(drJuarezPatients);
    doctor2.addPatientList(drHanleyPatients);
    //Pre set Schedule / Data Base 
     //Schedule Dr. Juarez
        // Now make two Schedule Objects for Monday Morning Manually
        Schedule s1 = new Schedule(doctor1,patient1,"Monday",800,900);
        Schedule s2 = new Schedule(doctor1,patient2,"Monday",900,1000);
        Schedule s3 = new Schedule(doctor1,patient3,"Monday",1000,1100);    
        // Now Schedule Objects 4-5 to Monday Evening Manually
        Schedule s4 = new Schedule(doctor1,patient4,"Monday",1300,1400);
        Schedule s5 = new Schedule(doctor1,patient5,"Monday",1400,1500);
        
        //Schedule Dr. Hanley
        // Doctor Hanley patients now need to put into calendar Monday and Tue
        Schedule sh1 = new Schedule(doctor2,patient6,"Monday",800,900);
        Schedule sh2 = new Schedule(doctor2,patient7,"Monday",900,1000);
        Schedule sh3 = new Schedule(doctor2,patient8,"Monday",1000,1100);    
        // Now Schedule Objects 4-5 to Tuesday Morning Manually
        Schedule sh4 = new Schedule(doctor2,patient9,"Tuesday",800,900);
        Schedule sh5 = new Schedule(doctor2,patient10,"Tuesday",900,1000);
    
         //add Schedule object to doctor class
        doctor1.addSchduleToCalendar(s1);
        doctor1.addSchduleToCalendar(s2);
        doctor1.addSchduleToCalendar(s3);
        doctor1.addSchduleToCalendar(s4);
        doctor1.addSchduleToCalendar(s5);
        // add Schedule to doctor Handley
        doctor2.addSchduleToCalendar(sh1);
        doctor2.addSchduleToCalendar(sh2);
        doctor2.addSchduleToCalendar(sh3);
        doctor2.addSchduleToCalendar(sh4);
        doctor2.addSchduleToCalendar(sh5); 
        
        // Menu Start
    
    do{
        userchoice = mainMenu(); 
        // create patient
        if(option==1){
            Doctor temp;
            Patient[] pat;
            String compareDoctor = "Dr. Juarez";
            System.out.print("Create Patient Option [1]");
            createPatientMenu();
            Patient obj = new Patient(name,ssn,phone,street,city,state,zip,insurance,expDate);
            obj.printPatientInfo();
            // choose doctor String name
            chooseDoctor();
            // add patient to list
            if(docName.equals(compareDoctor)){
                temp = doctor1;
                System.out.println("In Doctor Juarez List");
                temp.addPatientToList(obj, drJuarezPatients);
                temp.printPatientList();
            }
            else{
                temp = doctor2;
                System.out.println("In Doctor Hanley List");
                //pat = doctor2.getPatientList();
                temp.addPatientToList(obj, drHanleyPatients);
                temp.printPatientList();
            }

            
            //revert back to main menu
            userchoice = mainMenu(); 
        }
        // create appointment
        if(option==2){
            System.out.print("Appointment Option 2");
            Doctor tempDoc;
            Patient tempPat = new Patient();
            String day = JOptionPane.showInputDialog(null,"Enter Day of Appointment: ");
            String soc = JOptionPane.showInputDialog(null,"Enter Social Of Patient: ");
            String time = JOptionPane.showInputDialog(null,"Enter Time: ");
            // walk in 30 minute   and full patient check up 1hr
            String endTime = JOptionPane.showInputDialog(null,"Enter End Time: ");
            
            // time is a string conver to int
            int resultTime = Integer.parseInt(time);
            int resultTimeEnd = Integer.parseInt(endTime);
            String compareDoctor = "Dr. Juarez";
            chooseDoctor();
            
            // pick doctor
            if(docName.equals(compareDoctor)){
                tempDoc = doctor1;
                System.out.println("In Doctor object1");
            }
            else{
                tempDoc = doctor2;
                System.out.println("In Doctor object2");
            }
            
            // check list and match social to patient 
            
            for(int i=0;i<drHanleyPatients.size();i++){
                if(soc.equals(drHanleyPatients.get(i).getSSN())){
                    tempPat = drHanleyPatients.get(i);
                }
            }
            for(int i=0;i<drJuarezPatients.size();i++){
                if(soc.equals(drJuarezPatients.get(i).getSSN())){
                    tempPat = drHanleyPatients.get(i);
                }
            }
            
            //Schedule Appointment
            Schedule sch = new Schedule(tempDoc,tempPat,day,resultTime,resultTimeEnd);
            tempDoc.addSchduleToCalendar(sch);
            // print schedule
            sch.printAppointment();
            JOptionPane.showMessageDialog(null, sch.printAppointmentString());
            
            // turn into a string to submit
            // ERASE String submit = "Appointment : " + "Dr. " + tempPat.getName();
            
            // text reminder
            textReminder(sch.printAppointmentString());
            //restart menu
            userchoice = mainMenu(); 
        }
        // print schedule
        if(option==3){
            System.out.print("Schedule print out 3");
            String compareDoctor = "Dr. Juarez";
            Doctor temp = new Doctor();
            // reset doctorName with ChooseDoctor
            chooseDoctor();  
                  
            if(docName.equals(compareDoctor)){
                temp = doctor1;
                System.out.println("In Doctor object1");
            }
            else{
                temp = doctor2;
                System.out.println("In Doctor object2");
            }
            
            // Print calendar of chosen doctor
            temp.printCalendar();           
        }
        
        if(option == 4){
            System.out.print("Text Message 4");
            JOptionPane.showMessageDialog(null, "Send a Text \n"+
                    "Caution: message cannot contain any Sensitive Patient Information \n"+
                    "Social Number,Illness, Test Result and the like"); 
            String text = JOptionPane.showInputDialog(null, "Enter Message to Patient ");
            textReminder(text);
            System.out.print("Sent Text Out to patient");
        }
    } // end of do
    while(userchoice !=0);
    
    if(option==0){
            System.out.print("Hello Option Exit");
            System.exit(0);
        }
    
   

  } // end of main
} // endo of mainclass