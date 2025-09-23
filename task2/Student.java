package task2;

import java.util.ArrayList;

import java.util.Scanner;

public class Student {
   private int studentid;
    private String studentname;
   private  int studentmark;
    
    Student(int id,String name,int mark){
        this.studentid=id;
        this.studentname=name;
        this.studentmark=mark;
     }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public int getStudentmark() {
        return studentmark;
    }

    public void setStudentmark(int studentmark) {
        this.studentmark = studentmark;
    }

    
    @Override
    public String toString() {
        return "Student [studentid=" + studentid + ", studentname=" + studentname + ", studentmark=" + studentmark
                + "]";
    }

    public static void main(String[]args){
        ArrayList<Student> student = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Student managment system");
            System.out.println("1. Add student");
            System.out.println("2. View student");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                //Add student
                System.out.print("Enter Id:");
                int studentid = sc.nextInt();
                System.out.print("Enter a Studentname:");
                String studentname = sc.nextLine();
                System.out.print("Enter a Studentmark:");
                int studentmark=sc.nextInt();
                student.add(new Student(studentid,studentname,studentmark));
                System.out.println("Student Added successfully");
                break;

                case 2:
                //view Student
                if(student.isEmpty()){
                    System.out.println("No student List");
                }
                else{
                  for(Student s:student){
                    System.out.println(s);
                  }  
                }
                break;

                case 3:
                //update student
                System.out.print("Enter your student id Update:");
                int Ustudentid = sc.nextInt();
                boolean foundupdate = false;
                for(Student s: student){
                    if(s.getStudentid()==Ustudentid){
                        System.out.print("Enter New Name:");
                        s.setStudentname(sc.nextLine());
                        System.out.print("Enter New Mark:");
                        s.setStudentmark(sc.nextInt());
                        System.out.println("Student updated successfully");
                        foundupdate=true;
                        break;
                    }
                }
                        if(!foundupdate){
                            System.out.println("student not found");
                        }
                        break;
                   
                   case 4:
                   //Delete student
                   int deletestudentid=sc.nextInt();
                   boolean removed = false;
                   for(int i =0;i<student.size();i++){
                    if(student.get(i).getStudentid()==deletestudentid){
                       student.remove(i);
                       System.out.println("student id removed successfully");
                       removed=true;
                       break;
                    }
                   }
                   if(!removed){
                    System.out.println("students not found");
                   }
                   break;

                   case 6:
                   System.out.println("Exiting.....");
                   sc.close();
                   return;

                   default:
                   System.out.println("Invalid choice please try again");
            }

            }
        }
        

}


