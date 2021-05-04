import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*; // needed for Priority queue

// Comparable objects needed for Priority Queue
 class Student implements Comparable<Student> {
     private int id;
     private String name;
     private double cgpa;
     
     public Student(int id, String name, double cgpa) {
         this.id = id;
         this.name = name;
         this.cgpa = cgpa;
     }
     
     public int getID() {
         return this.id;
     }
     
     public String getName() {
         return this.name;
     }
     
     public double getCGPA() {
         return this.cgpa;
     }
     
     // Comparing Student objects
     public int compareTo(Student s) {
         if (this.cgpa > s.getCGPA()) {
             return -1;
         } 
         else if (this.cgpa < s.getCGPA()) {
             return 1;
         }
         else if (this.cgpa == s.getCGPA() && this.name.equals(s.getName())) {
             return s.getID() - this.id;
         }
         else {
            return this.name.compareTo(s.getName());
         }
     }
     
 }
 
 class Priorities {
     public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<Student>();
        //List<Student> result = new ArrayList<Student>();
    
        for (String event : events) {
            // Parsing each string in list
            String[] ev = event.split("\\s+");
                 
            // Actions     
            switch (ev[0]) {
                case ("ENTER"):
                    pq.add(new Student(
                        Integer.parseInt(ev[3]), 
                        ev[1], 
                        Double.parseDouble(ev[2])));
                    break;
                case ("SERVED"):
                    pq.poll();
                    break;
            }
        }   
        // Polling rest of objects from queue adding the to result list
        List<Student> result = new ArrayList<Student>();
        
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        return result;    
     }
 }


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
