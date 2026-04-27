import java.util.Scanner;

public class BinarySearchLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // กำหนดข้อมูลเริ่มต้นตามโจทย์ (ต้องเรียงลำดับมาแล้วถึงจะใช้ Binary Search ได้)
        int[] Number = {00000, 11111, 22222, 33333, 44444, 55555, 66666, 77777, 88888, 99999};
        
        System.out.print("Search ID : ");
        int key = scanner.nextInt();
        
        // เรียกใช้เมธอด Binary Search (เมธอดนี้จะจัดการปริ้นต์ first/last ด้วย)
        int index = binarySearch(Number, key);
        
        // แสดงผลลัพธ์สุดท้าย
        if (index != -1) {
            System.out.println("Found at Number[" + index + "] : " + key);
        } else {
            System.out.println("Not Found!");
        }
        
        scanner.close();
    }
    
    // --- อัลกอริทึม Binary Search อิงจากสไลด์หน้า 11 ---
    public static int binarySearch(int[] data, int key) {
        int found = 0, index = -1;
        int low = 0;
        int high = data.length - 1; 
        int mid;
        
        while (low <= high && found == 0) {
            // โชว์ค่า first (low) และ last (high) ในแต่ละรอบตามโจทย์สั่ง
            System.out.println("first : " + low + "      last : " + high);
            
            mid = (low + high) / 2;
            
            if (key == data[mid]) {
                found = 1;
                index = mid;
            } else {
                if (key < data[mid]) {
                    // ถ้าค่าน้อยกว่า mid ให้ขยับ high มาตัดข้อมูลครึ่งหลังทิ้ง
                    high = mid - 1;
                } else {
                    // ถ้าค่ามากกว่า mid ให้ขยับ low ไปตัดข้อมูลครึ่งแรกทิ้ง
                    low = mid + 1;
                }
            }
        }
        return index;
    }
}