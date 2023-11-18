import java.util.*;
import java.io.*;
public class Frequency {
private static int[] a;
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of elements in the array: ");
int n = scanner.nextInt();
a= new int[n];
System.out.println("Enter the elements of the array:");
 for (int i = 0; i < n; i++)
{
a[i] = scanner.nextInt();
 }
System.out.print("Enter the value of K: ");
int k = scanner.nextInt();
 if (k > n)
 {
 System.out.println("Invalid input. K should be less than or equal to the number of elements in the array.");
} 
else 
{
 printFrequency(a, k); 
} }
public static void printFrequency(int[] numbers, int k) {
int[] frequency = new int[10]; 
for (int num : numbers) {
 frequency[num]++;
}
for (int i = 0; i < k; i++) {
int highfreq = 0;
int highfreqno = 0;
for (int j = 1; j < frequency.length; j++) {
if (frequency[j] >highfreq) {
highfreq = frequency[j];
highfreqno = j;
}}
 if (highfreqno != 0) {
System.out.print(highfreqno + " ");
frequency[highfreqno] = -1;
  } 
else 
{
                break; 
  } }
        System.out.println();
}}
