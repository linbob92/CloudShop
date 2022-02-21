import java.util.*;
import java.io.*;
public class finalRegrade {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input1 = new Scanner(new File("File1.txt"));
      Scanner input2 = new Scanner(new File("File2.txt"));

      String[] list = {"clam", "squid", "squid", "squid", "clam", "octopus", "octopus"} ;
      int[] list2 = {123, 321};
      ArrayList<String> array = new ArrayList<String>();
      for (int i = 0; i < list.length; i++) {
         array.add(list[i]);
      }
      compress(array);
      System.out.println(array);
   }
   public static void negativesToFront (ArrayList<Integer> list) {
      int index = list.size() - 1;
      for (int i = index; i >= 1; i--) {
         index--;
         if (list.get(index) < 0) {
            list.add(0, list.remove(index));
            index++;
         }
      }
   }
   public static void diff(Scanner input1, Scanner input2) {
      int diff = 0;
      int line = 0;
      while (input1.hasNextLine()) {
         int tempdiff = diff;
         String line1 = input1.nextLine();
         String line2 = input2.nextLine();
         Scanner lineScan1 = new Scanner(line1);
         Scanner lineScan2 = new Scanner(line2);
         line++;
         while (lineScan1.hasNext() && tempdiff == diff) {
            String temp1 = lineScan1.next().toLowerCase();
            String temp2 = lineScan2.next().toLowerCase();
            if (!temp1.equals(temp2)) {
               diff++;
            System.out.println("Diff on line " + line);
            System.out.println(line1 + " versus " + line2);
            }
         }
      }
      System.out.println();
      System.out.println(diff);
   }
   public static int[] expand(int[] list) {
      int count = 0;
      for (int i = 0; i < list.length; i += 2) {
         count += list[i];
      }
      int index = 0;
      int[] list2 = new int[count];
      for (int j = 0; j < list.length - 1; j += 2) {
         for (int k = 0; k < list[j]; k++) {
            list2[index] = list[j + 1];
            index++;        
         }
      }   
      return list2;
   }
   public static void compress(ArrayList<String> list) {
      for (int i = 1; i < list.size(); i++) {
                    System.out.println(list.get(i - 1));
            System.out.println(list.get(i));
         if (list.get(i).equals(list.get(i - 1))) {
            int same = 1;
            while (list.get(i - 1).equals(list.get(i))) {
               same++;
               list.remove(i - 1);
               i--;
               System.out.println(list);
               System.out.println(same);
            }
            list.set(i, "" + same + "*" + list.get(i));
         }
      }
   }
}