import java.util.Scanner;

public class Lab4ForStd {
    public static int maxsize = 5;
    public static int[] number = new int[maxsize];
	
    public static void main (String[] args) {
        // Declare variables
        Scanner input = new Scanner(System.in);
        int num;
		
        // ขั้นตอนที่ 1: การ Enqueue (รับข้อมูลเข้าคิว)
        for(int i = 0; i < maxsize; i++) {
            
            // วนรับค่าไปเรื่อยๆ จนกว่าจะได้เลขที่มากกว่า 0
            do {
                System.out.print("Enqueue Data " + (i + 1) + " : ");
                num = input.nextInt();
                
                // หากต้องการแจ้งเตือนเมื่อใส่ค่าผิด สามารถปลดคอมเมนต์บรรทัดล่างได้ครับ
                // if (num <= 0) { System.out.println("กรุณาป้อนตัวเลขที่มากกว่า 0"); }
                
            } while (num <= 0); 
            
            // เรียกใช้เมธอด enqueue เพื่อนำค่าเก็บลง Array
            enqueue(i, num);
        }
        
        // เมื่อวนลูปครบ 5 ครั้ง แสดงว่าคิวเต็ม
        System.out.println("\nQueue is full.\n");
        
        // ขั้นตอนที่ 2: การ Dequeue (ดึงข้อมูลออกจากคิว)
        dequeue();
        
        input.close();
    }
	
    public static void dequeue() {
        // ดึงข้อมูลออกมาแสดงผลตั้งแต่ตัวแรกที่เข้าคิว (Index 0 ไปจนถึงสุดท้าย)
        for (int i = 0; i < maxsize; i++) {
            System.out.println("Dequeue Data " + (i + 1) + " : " + number[i]);
        }
        
        // เมื่อดึงข้อมูลออกหมดแล้ว แสดงว่าคิวว่าง
        System.out.println("\nQueue is empty.");
    }
		
    public static void enqueue(int i, int num) {
        // นำข้อมูลที่รับมา เก็บลงใน Array ตามตำแหน่ง i
        number[i] = num;
    }
}