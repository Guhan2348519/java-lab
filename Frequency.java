import java.util.*;
import java. io. *;
public class Frequency {
private static int[] a;
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of elements in the array: ");
int n = scanner.nextInt();
a = new int[n];
System.out.println("Enter the elements of the array:");
for (int i = 0; i < n; i++) {
a[i] = scanner.nextInt();
  }
System.out.print("Enter the value of K: ");
int k = scanner.nextInt();
  if (k > n) {
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
int maxFreq = -1;
  int maxFreqNo = 0;
for (int j = frequency.length - 1; j >= 0; j--) {
if (frequency[j] > maxFreq) {
maxFreq = frequency[j];
maxFreqNo = j;
  }
  }
if (maxFreqNo != 0) { System.out.print(maxFreqNo + " ");
frequency[maxFreqNo] = -1;
  }
else
{
  break;
} }
System.out.println();
  }}
