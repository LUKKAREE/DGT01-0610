import java.util.*;

class BST_class {
    Node root;

    // คลาส Node สำหรับเก็บข้อมูลและตัวชี้ไปยังลูกซ้ายและขวา
    class Node {
        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }
    }

    // Constructor
    BST_class() {
        root = null;
    } 

    // เมธอดสำหรับรับค่าเข้ามาเพิ่มใน BST
    void insert(int key) {
        root = insert_Recursive(root, key);
    }

    // เมธอดแบบ Recursive สำหรับหาตำแหน่งที่ถูกต้องในการแทรกข้อมูล
    Node insert_Recursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        
        if (key < root.key) {
            root.left = insert_Recursive(root.left, key);
        } else if (key > root.key) {
            root.right = insert_Recursive(root.right, key);
        }
        
        return root;
    }

    // เมธอดแสดงผลแบบ Inorder (Left -> Root -> Right)
    void inorder() {
        System.out.println("In order");
        inorder_Recursive(root);
        System.out.println(); // ขึ้นบรรทัดใหม่เมื่อแสดงผลเสร็จ
    }

    void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.key + " ");
            inorder_Recursive(root.right);
        }
    }

    // เมธอดแสดงผลแบบ Postorder (Left -> Right -> Root)
    void postorder() {
        System.out.println("Post order");
        postorder_Recursive(root);
        System.out.println(); // ขึ้นบรรทัดใหม่เมื่อแสดงผลเสร็จ
    }

    void postorder_Recursive(Node root) {
        if (root != null) {
            postorder_Recursive(root.left);
            postorder_Recursive(root.right);
            System.out.print(root.key + " ");
        }
    }

    // ฟังก์ชันหลัก (Main)
    public static void main(String[] args) {
        BST_class bst = new BST_class();
        String msg = "";
        int num = 0, i = 0;
        Scanner input = new Scanner(System.in);
        
        // รับค่าข้อมูล 10 ค่าตามที่โจทย์กำหนด
        for(i = 0; i < 10; i++) {
            msg = input.nextLine();
            num = Integer.parseInt(msg);
            bst.insert(num);
        }
        
        // เรียกใช้การแสดงผล
        bst.inorder();
        bst.postorder();
        
        input.close();
    }
}