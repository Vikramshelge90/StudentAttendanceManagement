package org.attendance.repository;
import java.util.*;

import org.attendance.model.AddNewStudent;
public class StudentRepo {
	ArrayList al=new ArrayList();
	
	public int getid()
	{
		return al.size();
	}
	
	public boolean isAddStudent(AddNewStudent stud)
	{
		if(al.size()>0)
		{
			for(Object ob:al)
			{
				AddNewStudent s=(AddNewStudent)ob;
				if(s.getName().equals(stud.getName()))
				{
					System.out.println("Student Already Present in the App");
					return false;
				}
			}
		}
		boolean b = al.add(stud);
		return b;
	}
	
	/*--------2-------*/
	
	public ArrayList getallstudent()
	{
		return al;
	}
}
