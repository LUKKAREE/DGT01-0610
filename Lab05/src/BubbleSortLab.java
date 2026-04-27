import java.util.Scanner;

public class BubbleSortLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // รับจำนวนข้อมูล
        System.out.print("Input number of integers to sort: ");
        int size = scanner.nextInt();
        
        int[] n = new int[size];
        
        // วนลูปรับค่าข้อมูลทีละตัว
        System.out.println("Enter " + size + " integers");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter " + (i + 1) + ": ");
            n[i] = scanner.nextInt();
        }
        
        // --- อัลกอริทึม Bubble Sort v1 อิงจากหน้า 16 ของสไลด์ ---
        int i, pass, hold;
        
        for (pass = 1; pass <= size - 1; pass++) { // passes
            for (i = 0; i <= size - 2; i++) {      // one pass
                
                // เปลี่ยนจาก > เป็น < เพื่อเรียงจากมากไปน้อย
                if (n[i] < n[i + 1]) { 
                    hold = n[i];        // one swap
                    n[i] = n[i + 1];
                    n[i + 1] = hold;
                }
            }
        }
        // ------------------------------------------------------
        
        // แสดงผลลัพธ์ตาม Format ตัวอย่างในโจทย์
        System.out.println("Sorted list of numbers:");
        for (i = 0; i < size; i++) {
            System.out.println("Data " + (i + 1) + ": " + n[i]);
        }
        
        scanner.close();
    }
}