class SimpleArray
{
	private long[] a; 

	public SimpleArray(int size) 
	{ a = new long[size]; } 

	public void setElem(int index, long value) 
	{ a[index] = value; }

	public long getElem(int index) 
	{ return a[index]; }
	
	// ข้อที่ 1: หาตำแหน่งของข้อมูลที่มากที่สุด (อันนี้ถูกต้องอยู่แล้ว)
	public int findMax(int nElems) 
	{
		if (nElems == 0) {
			return -1; 
		}
		
		int maxIndex = 0; 
		for (int i = 1; i < nElems; i++) {
			if (a[i] > a[maxIndex]) {
				maxIndex = i; 
			}
		}
		return maxIndex;
	}
	
	// ข้อที่ 2: ลบตัวที่มากที่สุด คืนค่าที่ถูกลบ และแสดงข้อความ (อัปเดตใหม่)
	// เปลี่ยนจาก void เป็น Long เพื่อให้ return ค่า null ได้
	public Long removeMax(int nElems) 
	{
		if (nElems == 0) {
			System.out.println("Cannot find max. Array is empty.");
			return null; 
		}
		
		int maxIndex = findMax(nElems); 
		long maxValue = a[maxIndex]; // เก็บค่าตัวที่มากที่สุดไว้ก่อนจะโดนทับ
		
		// เลื่อนข้อมูลมาทับเพื่อปิดช่องว่าง
		for (int i = maxIndex; i < nElems - 1; i++) {
			a[i] = a[i + 1];
		}
		
		// แสดงข้อความตามที่โจทย์สั่ง
		System.out.println(maxValue + " has been removed.");
		
		return maxValue; // คืนค่าตัวเลขที่ถูกลบ
	}
	
} // end class SimpleArray

class LabArray
{
	public static void main(String[] args)
	{
		SimpleArray arr = new SimpleArray(100); 
		int nElems = 0; 
		int j; 
		
		arr.setElem(0, 77); 
		arr.setElem(1, 99);
		arr.setElem(2, 44);
		arr.setElem(3, 55);
		arr.setElem(4, 22);
		arr.setElem(5, 88);
		arr.setElem(6, 11);
		arr.setElem(7, 00);
		arr.setElem(8, 66);
		arr.setElem(9, 33);
		nElems = 10; 
		
		for(j=0; j<nElems; j++) 
			System.out.print(arr.getElem(j) + " ");
		System.out.println("");

		// หาตำแหน่งที่มากที่สุดมาโชว์
		System.out.println("Index Number: " + arr.findMax(nElems));
		
		// เรียกใช้เมธอด removeMax ซึ่งมันจะปริ้นต์ข้อความ "... has been removed." ให้เอง
		arr.removeMax(nElems);
		nElems--; // ลบข้อมูลไป 1 ตัว ต้องลด nElems ลงด้วย
		
		for(j=0; j<nElems; j++) 
			System.out.print(arr.getElem(j) + " ");
		System.out.println("");
		
	} // end main()
} // end class LabArray