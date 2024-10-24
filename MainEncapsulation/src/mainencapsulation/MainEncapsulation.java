
package mainencapsulation;


public class MainEncapsulation {

    
    public static void main(String[] args) {
        
        StudentGrade clStudentGrade= new StudentGrade();
        
        System.out.println(clStudentGrade.getLastName());
        clStudentGrade.setLastName("Abundo");
        
        System.out.println(clStudentGrade.getFirstName());
        clStudentGrade.setFirstName("Jonalene");
        
        System.out.println(clStudentGrade.getStudentNo());
        clStudentGrade.setStudentNo("202334050");
        
        System.out.println(clStudentGrade.getEmailAddress());
        clStudentGrade.setEmailAddress("abundojonalene@gmail.com");
        
        System.out.println(clStudentGrade.getCellPhoneNo());
        clStudentGrade.setCellPhoneNo("09995778937");
        
        System.out.println(clStudentGrade.getCourseGrade());
        clStudentGrade.setCourseGrade("BSCS 2-1");
        
        System.out.println(clStudentGrade.getSubjectCode());
        clStudentGrade.setSubjectCode("CSC 0101-1"); 
        
    }
        
}
