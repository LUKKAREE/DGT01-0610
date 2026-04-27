import java.util.Scanner;

public class SequentialSearchLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // กำหนดข้อมูลเริ่มต้นตามโจทย์
        int[] A = {10001, 10022, 10060, 11255, 15022, 20001, 21002, 23003, 25566, 30078, 40000, 50012, 66006};
        
        System.out.print("ID : ");
        int key = scanner.nextInt();
        
        // เรียกใช้เมธอด Sequential Search
        int index = sequentialSearch(A, key);
        
        // แสดงผลลัพธ์ตามโจทย์
        if (index != -1) {
            System.out.println("Found at A[" + index + "]");
        } else {
            System.out.println("Not Found!");
        }
        
        scanner.close();
    }
    
    // --- อัลกอริทึม Sequential Search อิงจากสไลด์หน้า 7 ---
    public static int sequentialSearch(int[] data, int key) {
        int found = 0, index = -1;
        int i = 0;
        
        // วนลูปหาทีละตัวตราบที่ยังไม่เจอและยังไม่หมด array
        while (i < data.length && found == 0) {
            if (key == data[i]) {
                found = 1;
                index = i;
            } else {
                i++;
            }
        }
        return index;
    }
}