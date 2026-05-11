import java.util.Scanner;

public class GraphLab10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ส่วนที่ 1 & 2: รับจำนวน Vertices และสร้าง Matrix
        System.out.print("How many vertices? ");
        int n = sc.nextInt();
        
        // กำหนดขนาดสูงสุดไม่เกิน 9 ตามโจทย์
        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.out.println("Adjacent of vertex " + i + ":");
            while (true) {
                int adjacent = sc.nextInt();
                if (adjacent == -1) break; // สิ้นสุดเมื่อป้อน -1
                
                // ตรวจสอบขอบเขตข้อมูลก่อนบันทึกลง Matrix
                if (adjacent >= 0 && adjacent < n) {
                    adjMatrix[i][adjacent] = 1;
                }
            }
        }

        // ส่วนที่ 3: แสดง Adjacency Matrix
        System.out.println("\nAdjacency Matrix:");
        
        // แสดงหัวตาราง (หมายเลขคอลัมน์)
        System.out.print("    | ");
        for (int j = 0; j < n; j++) {
            System.out.print(j + " ");
        }
        System.out.println("\n----------------------");

        // แสดงข้อมูลในแต่ละแถว
        for (int i = 0; i < n; i++) {
            System.out.print(i + "   | ");
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
