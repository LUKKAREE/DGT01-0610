import java.util.*;

class Hashing {
    // สร้างตารางแฮชขนาด 10
    private int[] hash_table = new int[10];

    Hashing() {
        for (int j = 0; j < 10; j++) {
            hash_table[j] = -1; // กำหนดค่าเริ่มต้นเป็น -1 แสดงว่ายังไม่มีข้อมูล
        }
    } // Constructor

    public void display() {
        System.out.print("Table: ");
        // วนลูปเพื่อแสดงข้อมูลตั้งแต่ดัชนี 0 ถึง 9
        for (int i = 0; i < 10; i++) {
            if (hash_table[i] == -1) {
                // หากไม่มีข้อมูลในดัชนีนั้น ให้พิมพ์ *
                System.out.print("* ");
            } else {
                // หากมีข้อมูล ให้พิมพ์ข้อมูลนั้น
                System.out.print(hash_table[i] + " ");
            }
        }
        System.out.println(); // ขึ้นบรรทัดใหม่เมื่อแสดงผลเสร็จ
    }

    public void insert(int key) {
        // หาค่า Index เริ่มต้นด้วย Modulo 10
        int index = key % 10;
        
        // การแก้ปัญหาการชนกันแบบ Linear Probing
        // หากช่องนั้นไม่ว่าง (ค่าไม่ใช่ -1) ให้ขยับไปยังช่องถัดไปเรื่อยๆ
        while (hash_table[index] != -1) {
            index = (index + 1) % 10;
        }
        
        // เมื่อเจอช่องว่างแล้ว ให้นำข้อมูลไปเก็บไว้
        hash_table[index] = key;
    }

    public static void main(String[] args) {
        Hashing hashtab = new Hashing();
        String msg = "";
        int num = 0, i = 0;
        Scanner input = new Scanner(System.in);
        
        // รับเลขจำนวนเต็มทั้งหมด 7 ค่า มาเก็บใส่ตารางแฮช
        for (i = 0; i < 7; i++) {
            msg = input.nextLine();
            num = Integer.parseInt(msg);
            hashtab.insert(num);
        }
        
        hashtab.display();
        input.close();
    }
}