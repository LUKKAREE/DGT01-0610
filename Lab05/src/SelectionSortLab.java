import java.util.Arrays;

public class SelectionSortLab {
    public static void main(String[] args) {
        // กำหนดข้อมูลตามโจทย์
        int[] data = {120, 60, 20, 80, 79, 30, 45};
        int max = data.length; // จำนวนข้อมูล
        
        System.out.println("Unsorted Array: " + Arrays.toString(data));
        
        // --- อัลกอริทึม Selection Sort อิงจากหน้า 10 ของสไลด์ ---
        int i, j, maxIdx, temp;
        
        for (i = 0; i < max - 1; i++) { // passes
            maxIdx = i; // สมมติให้ตำแหน่ง i เป็นตัวที่มากที่สุด
            
            for (j = i + 1; j < max; j++) {
                // เปลี่ยนจากหาค่าน้อยสุดเป็นหาค่ามากสุด (ใช้ > แทน <)
                if (data[j] > data[maxIdx]) { 
                    maxIdx = j;
                }
            }
            
            // ทำการสลับตำแหน่ง (Swap)
            temp = data[i];
            data[i] = data[maxIdx];
            data[maxIdx] = temp;
        }
        // ---------------------------------------------------

        // แสดงผลลัพธ์ (คงข้อความตามรูปภาพในโจทย์ แม้ตัวเลขจะเรียงจากมากไปน้อย)
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(data));
    }
}