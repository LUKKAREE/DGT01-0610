import java.util.Scanner;

class StackA {
    public int maxSize; //ประกาศตัวแปรเพื่อเก็บขนาดสูงสุดที่สแต็กจะรับได้
    public String[] stackArray; //สร้างตัวแปร Array สำหรับเก็บข้อมูลจริง (ในที่นี้เก็บเป็นตัวอักษร/ข้อความ)
    public int top; //ตัวแปรดัชนี (Index) เพื่อบอกว่าตอนนี้ "จุดบนสุด" อยู่ที่ตำแหน่งไหน

    //--------------------------------------------------------------
    public StackA(int s) // constructor (ส่วนที่ทำงานตอนสร้าง Object)
    {
        maxSize = s; // set array size
        stackArray = new String[maxSize]; // create array
        top = -1; //กำหนดให้เริ่มต้นที่ -1 เพราะใน Array ตำแหน่งแรกคือ 0 การเริ่มที่ -1 หมายถึง "ยังไม่มีข้อมูล"
    }

    //--------------------------------------------------------------
    public void push(String j) //ฟังก์ชันสำหรับเพิ่มข้อมูล
    {
        // โปรแกรมจะ push ข้อมูลก็ต่อเมื่อสแต็กไม่เต็ม
        if (!isFull()) {  //ตรวจสอบก่อนว่าสแต็กเต็มหรือยัง (ถ้าไม่เต็มถึงจะเพิ่มได้)
            top++; //ขยับตำแหน่งบนสุดขึ้นไป 1 ช่อง
            stackArray[top] = j; //นำข้อมูลที่รับมาไปใส่ไว้ในช่องนั้น
        } else {
            System.out.println("Stack is full!");
        }
    }

    //--------------------------------------------------------------
    public String pop() //ฟังก์ชันสำหรับดึงข้อมูลออก
    {
        // โปรแกรมจะ pop ข้อมูลก็ต่อเมื่อสแต็กไม่ว่าง
        if (!isEmpty()) {    //ตรวจสอบว่ามีข้อมูลเหลืออยู่ไหม
            String value = stackArray[top]; //อ่านค่าที่อยู่บนสุดมาเก็บไว้ในตัวแปร value
            top--; //ลดตำแหน่งบนสุดลง 1 ช่อง (เปรียบเสมือนการหยิบออก)
            return value;
        } else {
            return null;
        }
    }

    //--------------------------------------------------------------
    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1); //ถ้าเท่ากับ -1 แสดงว่า ว่าง
    }

    //--------------------------------------------------------------
    public boolean isFull() // true if stack is full
    {
        return (top == maxSize - 1); //ถ้าเท่ากับขนาดสูงสุดลบหนึ่ง (เช่น 4 จากขนาด 5) แสดงว่า เต็ม
    }
    //--------------------------------------------------------------
} // end class StackA

public class Lab3ForStd {
    public static void main(String[] args) {
        // declare variables
        Scanner input = new Scanner(System.in); //สร้างเครื่องมือรับข้อมูลจากคีย์บอร์ด
        int stackSize = 5; //กำหนดว่าจะรับข้อมูลทั้งหมด 5 ตัวตามโจทย์
        
        // declare StackA variable
        StackA myStack = new StackA(stackSize); //สร้าง Object สแต็กขึ้นมาจริงๆ โดยมีขนาด 5 ช่อง
        
        // --- ขั้นตอนการ Push ข้อมูลเข้า Stack ---
        for (int i = 0; i < stackSize; i++) { //วนลูปทำงาน 5 ครั้ง
            System.out.print("Push Data " + (i + 1) + " : "); //แสดงข้อความเพื่อบอกผู้ใช้ว่าให้ใส่ข้อมูลตัวที่เท่าไหร่
            String data = input.nextLine(); //รับตัวอักษรจากผู้ใช้ (เช่น 'C', 'A', 'J')
            
            myStack.push(data); //นำตัวอักษรนั้นไปเก็บไว้ในสแต็ก
        }
        
        System.out.println("--------------------------");
        
        // --- ขั้นตอนการ Pop ข้อมูลออกจาก Stack ---
        if (!myStack.isEmpty()) { //เช็คเพื่อความชัวร์ว่าสแต็กมีข้อมูลข้างใน
            for (int i = 0; i < stackSize; i++) { //วนลูป 5 ครั้งเพื่อดึงข้อมูลออกมาให้
                String popData = myStack.pop(); //เรียกใช้คำสั่ง pop() เพื่อดึงข้อมูลตัวบนสุดออกมา
                System.out.println("Pop Data " + (i + 1) + " : " + popData); //แสดงผลลัพธ์ที่ดึงออกมาได้
            }
        }
        
        System.out.println(" ");
        input.close(); // ปิดการใช้งาน Scanner คืนหน่วยความจำ
    }
}
