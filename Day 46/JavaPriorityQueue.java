import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

class Student implements Comparable<Student>{
    int idStudent;
    String nameStudent;
    double cpgaStudent;
    
    public Student(int idStudent, String nameStudent, double cpgaStudent){
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.cpgaStudent = cpgaStudent;
    }
    
    public int getId(){
        return this.idStudent;
    }
    
    public String getName(){
        return this.nameStudent;
    }
    
    public double getCGPA(){
        return this.cpgaStudent;
    }
    
   public int compareTo(Student b) {
        if (this.getCGPA() > b.getCGPA()){ 
            return -1; 
        }else
        if (this.getCGPA() < b.getCGPA()){
             return 1; 
        }else
        if (this.getCGPA() == b.getCGPA()){
            if (this.getName().compareTo(b.getName()) < 0 ){
                 return -1; 
            }else
            if (this.getName().compareTo(b.getName()) > 0){ 
                return 1; 
            }else
            if (this.getName().compareTo(b.getName()) == 0){
                if (this.getId() < b.getId()){ 
                    return -1; 
                }else
                if (this.getId() > b.getId()){ 
                    return 1;
                }
            }
        }
        return 0;
    }
}

class Priorities{
    public final List<Student> getStudents(List<String> events){
        List<Student> students = new ArrayList<>();
        PriorityQueue<Student> pQueue = new PriorityQueue<>();
        for(String event: events){
            if(event.equalsIgnoreCase("SERVED")){
                   pQueue.poll(); 
            }else{
                String [] detailsStudent = event.split(" ");
                int idStudent = Integer.parseInt(detailsStudent[3]);
                String nameStudent = detailsStudent[1];
                double cpgaStudent = Double.parseDouble(detailsStudent[2]);
                pQueue.add(new Student(idStudent, nameStudent ,cpgaStudent));
            }
        }
        while(!pQueue.isEmpty()){
            students.add(pQueue.poll());
        }
        return students;
    }
}
