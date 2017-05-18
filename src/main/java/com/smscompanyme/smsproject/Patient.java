
package com.smscompanyme.smsproject;

/**
 *
 * @author Juarez
 */
public class Patient {
    public String name;
    private String phone;
    private String ssn;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String insurance;
    private String insuranceDate;
    
    // constructors
    public Patient(){
        this.name ="n/a";
        this.ssn ="n/a";
        this.phone="empty";
        this.street="n/a";
        this.city="n/a";
        this.state="n/a";
        this.zip="n/a";
    }
    
    public Patient(String nam, String sn){
        this.name=nam;
        this.ssn=sn;
    }
    
    public Patient(String nam, String sn,String phon,String str,String cit,
        String st,String zp){
           this.name=nam;
           this.ssn=sn;
           this.phone=phon;
           this.street=str;
           this.city=cit;
           this.state=st;
           this.zip=zp;
    }
    public Patient(String nam, String sn,String phon,String str,String cit,
        String st,String zp,String insurance,String expDate){
           setName(nam);
           setSSN(sn);
           setPhone(phon);
           setAddress(str,cit,st,zp);
           setInsurance(insurance);
           setInsuranceExpDate(expDate);
    }
    // end of contsructors
    
    //set methods for each attribute in order
    
    public void setName(String nam){
        this.name=nam;
    }
    public void setSSN(String sn){
        this.ssn=sn;
    }
    public void setPhone(String ph){
        this.phone=ph;
    }    
    public void setAddress(String str, String cit, String st, String zp){
        this.street=str;
        this.city=cit;
        this.state=st;
        this.zip=zp;
    }
    public void setInsurance(String ins){
        this.insurance=ins;
    }
    public void setInsuranceExpDate(String insD){
        this.insuranceDate=insD;
    }
    
    // get methods for attributes
    public String getName(){
        return this.name;
    }
    public String getSSN(){
        return this.ssn;
    }
    public String getStringSSN(){
        String temp;
        String f3Soc; //first three of social
        String n2Soc; //Second two of social
        String l3Soc; //last three of social
        temp = this.ssn;
        f3Soc = temp.substring(0, 3);
        n2Soc = temp.substring(3, 5);
        l3Soc = temp.substring(5, 9);
        // reset temp to format ###-##-####
        temp = f3Soc + "-" + n2Soc + "-" + l3Soc;
        return temp;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getStreet(){
        return this.street;
    }
    public String getCity(){
        return this.city;
    }
    public String getState(){
        return this.state;
    }
    public String getZip(){
        return this.zip;
    }
    
    // like this because it does it all in one string
    public String getFullAddress(){
        String temp;
        temp = getStreet()+","+getCity()+","+getState()+","+getZip();
        return temp;
    }
    public String getInsuranceName(){
        return this.insurance;
    }
    public String getInsuranceDate(){
        return this.insuranceDate;
    }
    
    // print functions    
    public void printPatientInfo(){
        System.out.println("--Patient Information "+getName()+"--");
        System.out.println("Patient : " + getName());
        System.out.println("Phone : " + getPhone());
        System.out.println("Address : " + getFullAddress()+ "\n");
        
        System.out.println("Insurance Name : " + getInsuranceName());
        System.out.println("Experation Date : " + getInsuranceDate());
        System.out.println("------------------------------------------------------");
    }
    
    
}

