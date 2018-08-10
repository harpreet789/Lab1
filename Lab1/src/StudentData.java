import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StudentData {

	public static void main(String[] args) {
		BufferedReader br=null;
		try
		{
			int countA=0,countB=0,countC=0,countD=0,countE=0,max_pnt=0,avg_perc=0,total_student=0;
			br=new BufferedReader(new FileReader("C:\\Users\\hp\\Desktop\\HW1\\HW1-data.txt"));
			String line=br.readLine();
			String first_line="Stdnt Id Ex -------Assignments----------- Tot  Mi Fin  CL Pts Pct Gr\n";
			String second_line="-------- -- ----------------------------- --- --  ---  -- --- --- --\n";
			 BufferedWriter output = null;
		        File file = new File("C:\\Users\\hp\\Desktop\\HW1\\CSX-358-HW1-16103032.txt");
		        output = new BufferedWriter(new FileWriter(file));
		        output.write(first_line);  output.write(second_line);
			while(line!=null)
			{
				total_student++;
				String [] splitStr=line.trim().split("\\s+");//for ignore spacing
				String outLine=""; outLine+=splitStr[0];outLine+=" ";
				int tot=0,ex=0;
				ex=Integer.parseInt(splitStr[1]);
				for(int i=1;i<=11;i++)
				{ if(splitStr[i].length()<2)
						outLine+=" ";
					outLine+=splitStr[i];
					outLine+=" ";
					int marks=Integer.parseInt(splitStr[i]);
					tot+=marks;}//till now we add marks of all assignments and extra marks
				String total=Integer.toString((tot-ex));//getting total marks
				outLine+=total;outLine+=" ";
				for(int i=12;i<=14;i++)
				{
					if(splitStr[i].length()<3)
						outLine+=" ";
					if(splitStr[i].length()<2)
						outLine+=" ";
					outLine+=splitStr[i];
					outLine+=" ";
					int marks=Integer.parseInt(splitStr[i]);
					tot+=marks;}//calculate total marks including extra marks
				String pts=Integer.toString(tot);
				outLine+=pts;outLine+=" ";
				if(tot>max_pnt)
					max_pnt=tot;//calculate max. points 
				int perc=calcu_perc(tot,420);//calculate percentage
				avg_perc+=perc;//calculate average percentage
				String percent=Integer.toString(perc);
				outLine+=percent;
				outLine+="   ";
				char grade=calcu_grade(perc);//calculate grade
			    if(grade=='A')//no. of students getting A grade
			    	countA++;
			    else if(grade=='B')//no. of students getting B grade
			    	countB++;
			    else if(grade=='C')//no. of students getting c grade
			    	countC++;
			    else if(grade=='D')//no. of students getting D grade
			    	countD++;
			    else
			    	countE++;//no. of students getting E grade
				outLine+=Character.toString(grade);//converting character to string 
				outLine+="\n";
				System.out.println(line);	
				output.write(outLine);
				System.out.println(outLine);
				line=br.readLine();
			}
			for(int i=0;i<3;i++)
			output.write("\n");
			int average=calcu_perc(avg_perc,total_student);
			String temp="Average total point percent of all students::";
			average=average/100;//calculate average
			temp+=Integer.toString(average);//converting integer to string
			temp+="\n";
            output.write(temp);
            temp="";
			temp="Number of A's:  ";
			temp+=Integer.toString(countA);
			temp+="\n";
			output.write(temp);
			temp="Number of B's:  ";
			temp+=Integer.toString(countB);
			temp+="\n";
			output.write(temp);
			temp="Number of C's:  ";
			temp+=Integer.toString(countC);
			temp+="\n";
			output.write(temp);
			temp="Number of D's:  ";
			temp+=Integer.toString(countD);
			temp+="\n";
			output.write(temp);
			temp="Number of E's:  ";
			temp+=Integer.toString(countE);
			temp+="\n";
			output.write(temp);
			temp="";
			temp+="Maximum points: ";
			temp+=Integer.toString(max_pnt);//displaying maximum points
			temp+="\n";
			output.write(temp);output.close();
		}
		catch (IOException ioe) 
	       {ioe.printStackTrace();} 
	       finally 
	       {
	    	   try {
	    		   if (br != null)
	    			   br.close();
		   } 
		   catch (IOException ioe) 
	           { System.out.println("Error in closing the BufferedReader");}
		}
	}
   public static int calcu_perc(int total,int divis)
   {
	  total*=100;
	  float perc=(total)/divis;
	  int ans=Math.round(perc);
	  return ans;
   }
   public static char calcu_grade(int perc)
   {
      char grade;
	   if(perc>=90)
		   grade='A';
	   else if(perc>=78 && perc<=89)
		   grade='B';
	   else if(perc>=62 && perc<=77)
		   grade='C';
	   else if(perc>=46 && perc <=61)
		   grade='D';
	   else
		   grade='E';
	   return grade;
	}
}

