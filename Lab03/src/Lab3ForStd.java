import java.util.Scanner;

class StackA {
    public int maxSize; // size of stack array
    public String[] stackArray;
    public int top; // top of stack

    //--------------------------------------------------------------
    public StackA(int s) // constructor
    {
        maxSize = s; // set array size
        stackArray = new String[maxSize]; // create array
        top = -1; // no items yet (เริ่มที่ -1 เพราะ Array index เริ่มที่ 0)
    }

    //--------------------------------------------------------------
    public void push(String j) // put item on top of stack
    {
        // โปรแกรมจะ push ข้อมูลก็ต่อเมื่อสแต็กไม่เต็ม
        if (!isFull()) {
            top++; // increment top
            stackArray[top] = j; // insert item
        } else {
            System.out.println("Stack is full!");
        }
    }

    //--------------------------------------------------------------
    public String pop() // take item from top of stack
    {
        // โปรแกรมจะ pop ข้อมูลก็ต่อเมื่อสแต็กไม่ว่าง
        if (!isEmpty()) {
            String value = stackArray[top]; // access item
            top--; // decrement top
            return value;
        } else {
            return null;
        }
    }

    //--------------------------------------------------------------
    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1); // ถ้า top เป็น -1 แปลว่าไม่มีข้อมูล
    }

    //--------------------------------------------------------------
    public boolean isFull() // true if stack is full
    {
        return (top == maxSize - 1); // เต็มเมื่อ top ชี้ไปที่ช่องสุดท้ายของ Array
    }
    //--------------------------------------------------------------
} // end class StackA

public class Lab3ForStd {
    public static void main(String[] args) {
        // declare variables
        Scanner input = new Scanner(System.in);
        int stackSize = 5; // กำหนดขนาดตามโจทย์
        
        // declare StackA variable
        StackA myStack = new StackA(stackSize); 
        
        // --- ขั้นตอนการ Push ข้อมูลเข้า Stack ---
        for (int i = 0; i < stackSize; i++) { // for loop = Stack Size
            System.out.print("Push Data " + (i + 1) + " : ");
            String data = input.nextLine(); // รับค่าจากแป้นพิมพ์
            
            myStack.push(data); // push data
        }
        
        System.out.println("--------------------------");
        
        // --- ขั้นตอนการ Pop ข้อมูลออกจาก Stack ---
        if (!myStack.isEmpty()) { // check if not empty
            for (int i = 0; i < stackSize; i++) { // for loop = Stack Size
                String popData = myStack.pop(); // pop data
                System.out.println("Pop Data " + (i + 1) + " : " + popData); // display it
            }
        }
        
        System.out.println(" ");
        input.close(); // ปิดการใช้งาน Scanner คืนหน่วยความจำ
    }
}