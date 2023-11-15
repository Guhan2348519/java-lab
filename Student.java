import java.util.*;
import java.io.*;
public class Students {
int num_stud = 10;
int max_mark = 100;
int min_mark = 0;
int[] marks;
Students() 
{
        marks = new int[num_stud];
 }
void readMarks() {
Scanner scanner = new Scanner(System.in);        
System.out.println("Enter the marks for 10 students (between " + min_mark + " and " + max_mark + "):");
for (int i = 0; i < num_stud; i++) {
 int mark;
 do {
         System.out.print("Student " + (i + 1) + ": ");
         mark = getValidMark(scanner);
       } while (mark < min_mark || mark > max_mark);
marks[i] = mark;
 }
 }
private int getValidMark(Scanner scanner) {
 while (!scanner.hasNextInt()) {
 System.out.println("Invalid input. Please enter a valid integer.");
 scanner.next();         
}
int mark = scanner.nextInt();
if (mark < min_mark || mark > max_mark) {
 System.out.println("Invalid mark. Marks should be between " + min_mark + " and " + max_mark + ".");
return getValidMark(scanner);
 }
return mark;
}
 public int highmark() {
 int highest = marks[0];
for (int i = 1; i < num_stud; i++) {
if (marks[i] > highest) {
highest = marks[i];
}}
return highest;
}
 public int lowmark() {
int least = marks[0];
for (int i = 1; i < num_stud; i++) {
if (marks[i] < least) {
least = marks[i];
} }
 return least;
}
public int getmode() {
int[] frequency = new int[max_mark + 1];
for (int mark : marks) {
frequency[mark]++;
 }
 int mode = 0;
int maxFreq = 0;
for (int i = 0; i <= max_mark; i++) {
  if (frequency[i] > maxFreq) {
 mode = i;
 maxFreq = frequency[i];
 }}
return mode;
}
public int getfreqmode() {
 int[] frequency = new int[max_mark + 1];
 for (int mark : marks) {
frequency[mark]++;
}
int mode = 0;
int maxfrequency = 0;
 for (int i = 0; i <= max_mark; i++) {
 if (frequency[i] > maxfrequency) {
 mode = i;
maxfrequency = frequency[i];
}}
return maxfrequency;
}
 public void display() {
 System.out.println("Highest Mark: " + highmark());
 System.out.println("Least Mark: " + lowmark());
 System.out.println("Mode: " + getmode());
 System.out.println("Mode Frequency: " + getfreqmode());
}
 public static void main(String[] args) {        
Students students = new Students();
 students.readMarks();
 students.display();
}
}
