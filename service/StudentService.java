package org.attendance.service;
import org.attendance.model.AddNewStudent;
import org.attendance.repository.StudentRepo;
import java.util.*;

public class StudentService {
	Scanner sc=new Scanner(System.in);
	ArrayList<AddNewStudent>al;
	AddNewStudent student=new AddNewStudent();
	StudentRepo st=new StudentRepo();
	
	public boolean StudentAdd(AddNewStudent stud)
	{
		int sid=st.getid();
		sid+=1;
		stud.setId(sid);
		boolean b=st.isAddStudent(stud);
		return b;
		
	}
	
	/*----------2-----------*/
	
	public ArrayList getallstudent()
	{
		ArrayList al=st.getallstudent();
		return al.size()>0?al:null;
		
	}
	
//	----------------------case 1----------------------------
	
/*-----------------------case 2------------------*/
	public void ShowDetail()
	{
		al=st.getallstudent();
		if(al!=null)
		{
			System.out.println("----------------------------------");
			System.out.println("Sid\tSname\tSbatch\tSAttendance");
			for(Object ob:al)
			{
				student=(AddNewStudent)ob;
				System.out.println(student.getId()+"\t"+student.getName()+"\t"+student.getBatch()+"\t"+student.getAttendance());
			}
		}
		else
		{
			System.out.println("There is No Student present in The Student.");
		}
	}
	
	/*-----------------------------------Case 3---------------------------------*/
	
	public void Takeattendance()
	{
		int choice1;
		do
		{
			System.out.println("--------------------------------------");
			System.out.println("1.Take Todays Attendance.");
			System.out.println("2.today present student.");
			System.out.println("3.Today absent student.");
			System.out.println("Enter 0 for Main Menu.");
			
			System.out.println("--------------------------------------");
			System.out.println("Enter the choice:");
			choice1=sc.nextInt();
			
			switch(choice1) 
			{
			case 1:
				System.out.println("Enter The Student name:");
				sc.nextLine();
				String name1=sc.nextLine();
				al=st.getallstudent();
				if(al!=null)
				{
					int flag=0;
					for(AddNewStudent stud:al)
					{
						if(name1.equals(stud.getName())&&stud.isA()==false)
						{							
							stud.setAttendance(stud.getAttendance()+1);
							flag=1;
							stud.setA(true);
//							System.out.println("success");
						}
//						else
//						{
//							System.out.println("Already taken Attendance");
//						}
					}
					if(flag==1)
					{
						System.out.println("Success..");
					}
					else
					{
						System.out.println("Student Taken Alredy attendance.");
					}
					
					
				}
				else
				{
					System.out.println("There Will be no student in the class.");

				}
				break;
				
			case 2:
				al=st.getallstudent();
				int flag=0;
				System.out.println("Todays Present Student\n");
				System.out.println("Sname\tsbatch");
				for(AddNewStudent stud:al)
				{
					if(stud.isA()==true)
					{
						System.out.println(stud.getName()+"\t"+stud.getBatch());
						flag=1;
					}
				}
				if(flag==0)
				{
					System.out.println("Today There will No Present Student.");
				}
				break;
				
			case 3:
				al=st.getallstudent();
				int flag1=0;
				System.out.println("Todays absent Student");
				System.out.println("Sname\tsbatch");
				for(AddNewStudent stud:al)
				{
					if(stud.isA()!=true)
					{
						System.out.println(stud.getName()+"\t"+stud.getBatch());
						flag1=1;
					}
				}
				
				if(flag1==0)
				{
					System.out.println("Today There will No absent Student.");
				}
				break;
				
			}
		
		}while(choice1!=0);
		
		al=st.getallstudent();
		for(AddNewStudent stud:al)
		{
			stud.setA(false);
		}
	}
	
//	--------------------------case 4------------------------------------
	
	public void SerchStudent()
	{
		System.out.println("Enter The student name Which one Serch:");
		sc.nextLine();
		int flag1=0;
		String name2=sc.nextLine();
		al=st.getallstudent();
		if(al!=null)
		{
			
			for(AddNewStudent stud:al)
			{
				if(name2.equals(stud.getName()))
				{
					flag1=1;
					System.out.println("Student Detail:");
					System.out.println("Sname\tsbatch\tAttendance_per");
					float per=(float)((stud.getAttendance()*100f)/1);
					
					System.out.println(stud.getName()+"\t"+stud.getBatch()+"\t"+per);
				}
			}
			if(flag1==0)
			{
				System.out.println("Student Is Not  Present..");
			}
		}
		else
		{
			System.out.println("No One is Not present in the Class");
		}
	}
	
//	-----------------------------------case-4-----------------------------
	
	public void updatestudent()
	{
		al=st.getallstudent();
		System.out.println("Enter The Student Name Which one Update:");
//		sc.nextLine();
		String name3=sc.nextLine();
		int flag=0;
		
		for(AddNewStudent sd:al)
		{
			if(name3.equals(sd.getName()))
			{
				System.out.println("Enter The New Name");
				String name4=sc.nextLine();
				System.out.println("Enter The New contact");
				String contact=sc.nextLine();
				System.out.println("Enter The New Email");
				String email=sc.nextLine();
				System.out.println("Enter The New Batch");
				String batch1=sc.nextLine();
				
				sd.setName(name4);
				sd.setContact(contact);
				sd.setEmail(email);
				sd.setBatch(batch1);
				flag=1;
				
			}
		}
		
		if(flag==1)
		{
			System.out.println("Student Detail Updated Success..");
		}
		else
		{
			System.out.println("Some problem from update Student.");
		}
	}
	
	
	/*----------------------------case-6-----------------------*/
	public void deletestudent()
	{
		al=st.getallstudent();
		System.out.println("Enter The student name which one delete");
//		sc.nextLine();
		String name5=sc.nextLine();
		int flag2=0;
		Iterator <AddNewStudent> itr=al.iterator();
		while(itr.hasNext())
		{
			AddNewStudent obj=itr.next();
			if(name5.equals(obj.getName()))
			{
				itr.remove();
				flag2=1;
			}
		}
		
		if(flag2==1)
		{
			System.out.println("Student Removed Succesfully...");
		}
		else
		{
			System.out.println("failed to remove student.");
		}
	}
	
//	---------------------------case 7-------------------------------
	
	public void getattendance()
	{
		al=st.getallstudent();
//		for(AddNewStudent stud:al)
//		{
//			int per=((stud.getAttendance()*100)/1);
//			stud.setAttendance(per);
//
//		}
		int flag6=0;
			System.out.println("Sname\tsbatch");
			for(AddNewStudent stud:al)
			{
				float per=(float)((stud.getAttendance()*100f)/1);

				if(per>=75)
				{
					flag6=1;
					System.out.println(stud.getName()+"\t"+stud.getBatch());

				}
			}
		if(flag6==0)
		{
			System.out.println("There Will be No Student in the 75% Attendance");
		}
	}
	
//	----------------------------------case-8----------------------
	
	public void getbatchwise()
	{
		if(al!=null)
		{
			al=st.getallstudent();
			System.out.println("Ener The batch which one Search:");
	//		sc.nextLine();
			String batch1=sc.nextLine();
			int flag7=0;
			System.out.println("Sname\tsbatch");
			for(AddNewStudent ob:al)
			{
				if(batch1.equals(ob.getBatch()))
				{
					System.out.println(ob.getName()+"\t"+ob.getBatch());
					flag7=1;
				}
			}
			
			if(flag7==0)
			{
				System.out.println("There Is No Student Present In the batch..");
			}
		}
		else
		{
			System.out.println("There Will be No student In The App....");
		}
	}
	
	public void ShowAttendance() {
		if(al!=null)
		{
			int choice;
			do
			{
				System.out.println("-------------------------------");
				System.out.println("1.1 Month Attendance:");
				System.out.println("2.3 Month Attendance:");
				System.out.println("3.6 Month Attendance:");
				System.out.println("4.Enter 0 for Main Menu:");
				System.out.println("-------------------------------");
				
				System.out.println("Enter the Choice:");
				choice=sc.nextInt();
				
				switch(choice)
				{
					case 1:
						al=st.getallstudent();
						System.out.println("Enter The Student Batch Name:");
						sc.nextLine();
						String name=sc.nextLine();
						int flag=0;
						System.out.println("Sname\tSname\tAttendancr_per");
						for(AddNewStudent st:al)
						{
							float per=(float)((st.getAttendance()*100f)*30);
							
							if(name.equals(st.getBatch()))
							{
								System.out.println(st.getName()+"\t"+st.getBatch()+"\t"+per);
								flag=1;
							}
						}
						
						if(flag==0)
						{
							System.out.println("There Will be No Student in Batch");
						}
						break;
						
					case 2:
						al=st.getallstudent();
						System.out.println("Enter The Student Batch Name:");
						sc.nextLine();
						String name1=sc.nextLine();
						int flag1=0;
						System.out.println("Sname\tSname\tAttendancr_per");
						for(AddNewStudent st:al)
						{
							float per=(float)((st.getAttendance()*100f)*120);
							
							if(name1.equals(st.getBatch()))
							{
								System.out.println(st.getName()+"\t"+st.getBatch()+"\t"+per);
								flag=1;
							}
						}
						if(flag1==0)
						{
							System.out.println("There Will be No Student in Batch");
						}
						break;
						
					case 3:
						al=st.getallstudent();
						System.out.println("Enter The Student Batch Name:");
						sc.nextLine();
						String name3=sc.nextLine();
						int flag2=0;
						System.out.println("Sname\tSname\tAttendancr_per");
						for(AddNewStudent st:al)
						{
							float per=(float)((st.getAttendance()*100f)*180);
							
							if(name3.equals(st.getBatch()))
							{
								System.out.println(st.getName()+"\t"+st.getBatch()+"\t"+per);
								flag=1;
							}
						}
						
						if(flag2==0)
						{
							System.out.println("There Will be No Student in Batch");
						}
						break;
				}
			}
			while(choice!=0);
		}
		else
		{
			System.out.println("There Will be No student In The App....");
		}
	}
	
	
}
