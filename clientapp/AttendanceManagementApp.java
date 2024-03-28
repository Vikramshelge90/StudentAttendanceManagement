package org.attendance.clientapp;
import java.util.*;
import org.attendance.model.AddNewStudent;
import org.attendance.service.StudentService;
public class AttendanceManagementApp {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AddNewStudent student;
		StudentService st=new StudentService();
		int choice;
		ArrayList<AddNewStudent> al;
		do
		{
			System.out.println("---------------------------------------");
			System.out.println("===========WEL-COME====================");
			System.out.println("1.Add New Student For Attendance.");
			System.out.println("2.Display All Student Data By In The Class.");
			System.out.println("3.Take Attendance By ID.");
			System.out.println("4.Search Student By Name And Display All the information.");
			System.out.println("5.Update Student With Name.");
			System.out.println("6.Delete Student By Id.");
			System.out.println("7.If Student Attendance is greater than 75% Then It Will Eligible For Placement.");
			System.out.println("8.Show the Student Batch Wise.");
			System.out.println("9.Show Attendance.");
			System.out.println("10.For Exit 0");
			System.out.println("---------------------------------------");
			System.out.println("\nEnter The Choice:");
			choice=sc.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.println("Enter The student name:");
					sc.nextLine();
					String name=sc.nextLine();
//					System.out.println("Enetr The student contact:");
//					String contact=sc.nextLine();
//					System.out.println("Enetr The student Email:");
//					String email=sc.nextLine();
					System.out.println("Enter The Student Batch With Year");
					String batch=sc.nextLine();
//					System.out.println("Enter The Student Course");
//					String course=sc.nextLine();
					
					student=new AddNewStudent(name,batch);
					boolean b=st.StudentAdd(student);
					if(b)
					{
						System.out.println("Student Added Succesfully....");
					}
					else
					{
						System.out.println("Some Error");
					}
					break;
					
				case 2:
					st.ShowDetail();
					break;
					
				case 3:
					st.Takeattendance();
					break;
					
				case 4:				
					st.SerchStudent();
					break;
					
				case 5:
					st.updatestudent();
					break;
					
				case 6:
					st.deletestudent();
					break;
					
				case 7:
					st.getattendance();
					break;

				case 8:
					st.getbatchwise();
					break;
					
				case 9:
					st.ShowAttendance();
					break;
					
					default:
						System.out.println("Wrong Choice....");
			}
		}while(choice!=0);
	}

}
