
package medical_record;

import java.util.Scanner;

public class Medical_Record {

        public void createMedical(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("\nAdd Record ID: ");
        int id = sc.nextInt();
       
        System.out.print("Visit Date: ");
        String vdate = sc.next();
        sc.nextLine();
        
        System.out.print("Diagnosis: ");
        String diag = sc.next();
        
        System.out.print("Treatment Plan: ");
        String tp = sc.next();
        
            
        String sql = "INSERT INTO tbl_med (m_record_id, m_visit_date, m_diagnosis, m_treatment_plan) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, id, vdate, diag, tp);


    }
    
    private void readMedical() {
        config conf = new config();

        String qry = "SELECT * FROM tbl_med";
        String[] header = {"ID", "Visit Date", "Diagnosis", "Treatment Plan"};
        String[] column = {"m_record_id", "m_visit_date", "m_diagnosis", "m_treatment_plan"};

        conf.viewRecords(qry, header, column);
        
    }
    
    public void updateMedical() {
       Scanner s = new Scanner(System.in);
       
        System.out.print("Enter ID to Update: ");
        int id = s.nextInt();
       
        System.out.print("Visit Date: ");
        String vdate = s.next();
        s.nextLine();

        
        System.out.print("Diagnosis: ");
        String diag = s.next();
        
        System.out.print("Treatment Plan: ");
        String tp = s.next();
        
        
        String qry = "UPDATE tbl_med SET m_visit_date = ?, m_diagnosis = ?, m_treatment_plan = ? WHERE m_record_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, vdate, diag, tp, id );
        
    }
       
    public void deleteMedical(){
        Scanner s = new Scanner(System.in);
       
        System.out.print("Enter ID to Delete: ");
        int id = s.nextInt();
        
        String qry = "DELETE FROM tbl_med WHERE m_record_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
                
    }
  
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String response;

        do{
        System.out.println("1. CREATE");
        System.out.println("2. READ");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        
        System.out.print("\nEnter option: ");
        int opt = sc.nextInt();
        sc.nextLine();
        
        Medical_Record client = new Medical_Record();

        
        switch(opt){
            case 1:
                client.createMedical();
                break;
                
            case 2:
                client.readMedical();
                break;
            
            case 3:
                client.readMedical();
                client.updateMedical();
                break;
                
            case 4:
                client.readMedical();
                client.deleteMedical();
                client.readMedical();
                
            case 5:
                System.out.println("Exiting....");
                break;
                
            default:
                System.out.println("Invalid Action!");
               
        }
        
            System.out.print("Want to add another transactions? (yes/no): ");
            response = sc.nextLine();

        }while (response.equalsIgnoreCase("yes"));
        
        sc.close();
    }
}

    

