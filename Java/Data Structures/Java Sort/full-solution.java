import java.util.*;

// First option is to use Comparable interface
class Student implements Comparable<Student> {
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
    
   
    // Overriding compareTo method
    @Override
    public int compareTo(Student o) {   
        if (this.getCgpa() == o.getCgpa()) {
            if (this.getFname().equals(o.getFname())) 
                return this.getId() - o.getId();        
            else 
                return this.getFname().compareTo(o.getFname());            
        }
        else {
            if (o.getCgpa() - this.getCgpa() > 0) 
                return 1; 
            else
                return -1;
        }
    }
      
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

// Second option is to use Comparator interface
class CgpaComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getCgpa() == o2.getCgpa()) {
            if (o1.getFname().equals(o2.getFname())) 
                return o1.getId() - o2.getId();        
            else 
                return o1.getFname().compareTo(o2.getFname());            
        }
        else {
            if (o2.getCgpa() - o1.getCgpa() > 0) 
                return 1; 
            else
                return -1;
        }    
    }    
}

//Complete the code
public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
      
        // We can use Comparable interface
        Collections.sort(studentList);
        //Or we can use Comparator interface
        //Comparator cgpaComp = new CgpaComparator();
        //Collections.sort(studentList, cgpaComp);
      
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}
