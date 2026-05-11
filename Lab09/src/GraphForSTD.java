import java.util.*;

class Graphs<T> {

	// ใช้ HashMap ในการเก็บ adjacency list ของแต่ละ Vertex [cite: 127, 128]
	private Map<T, List<T>> map = new HashMap<>();

	// ฟังก์ชันเพิ่ม Vertex ใหม่ลงในกราฟ [cite: 5, 112]
	public void addVertex(T s) {
		map.put(s, new LinkedList<T>());
	}

	// ฟังก์ชันเพิ่ม Edges ระหว่าง source และ destination [cite: 51, 113]
	public void addEdge(T source, T destination, boolean bidirectional) {
		if (!map.containsKey(source))
			addVertex(source);

		if (!map.containsKey(destination))
			addVertex(destination);

		map.get(source).add(destination);
		if (bidirectional == true) {
			map.get(destination).add(source);
		}
	}

	// (2.1) แสดงจำนวน Vertex ทั้งหมดในกราฟ [cite: 10, 151]
	public void getVertexCount() {
		int vertexCount = map.keySet().size();
		if (vertexCount > 1) {
			System.out.println("The graph has " + vertexCount + " vertices.");
		} else {
			System.out.println("The graph has " + vertexCount + " vertex.");
		}
	}

	// (2.2) แสดงจำนวน Edges ทั้งหมดในกราฟ [cite: 11, 29]
	public void getEdgesCount(boolean bidirection) {
		int count = 0;
		for (T v : map.keySet()) {
			count += map.get(v).size();
		}
		if (bidirection == true) {
			count = count / 2;
		}

		if (count > 1) {
			System.out.println("The graph has " + count + " edges.");
		} else {
			System.out.println("The graph has " + count + " edge.");
		}
	}

	// (2.4) ตรวจสอบว่ามี Vertex นั้นๆ อยู่หรือไม่ [cite: 39]
	public void hasVertex(T s) {
		if (map.containsKey(s)) {
			System.out.println("The graph contains " + s + " as a vertex.");
		} else {
			System.out.println("The graph does not contain " + s + " as a vertex.");
		}
	}

	// (2.3) ตรวจสอบว่ามีเส้นเชื่อม (Edge) ระหว่าง Vertex หรือไม่ [cite: 51, 152]
	public void hasEdge(T s, T d) {
		if (map.containsKey(s) && map.get(s).contains(d)) {
			System.out.println("The graph has an edge between vertex " + s + " and " + d + ".");
		} else {
			System.out.println("The graph has no edge between " + s + " and " + d + ".");
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		// เรียงลำดับ Key (Vertex) เพื่อให้แสดงผลเหมือนตัวอย่าง (0, 1, 2, 3, 4)
		List<T> sortedKeys = new ArrayList<>(map.keySet());
		if (sortedKeys.get(0) instanceof Comparable) {
			Collections.sort((List<Comparable>) sortedKeys);
		}

		for (T v : sortedKeys) {
			builder.append(v.toString() + ": ");
			List<T> neighbors = new ArrayList<>(map.get(v));
			// เรียงลำดับ neighbors เพื่อความสวยงามและตรงตามตัวอย่าง
			if (!neighbors.isEmpty() && neighbors.get(0) instanceof Comparable) {
				Collections.sort((List<Comparable>) neighbors);
			}
			for (T w : neighbors) {
				builder.append(w.toString() + " ");
			}
			builder.append("\n");
		}
		return (builder.toString());
	}
}

public class GraphForSTD {
	public static void main(String args[]) {
		Graphs<Integer> g = new Graphs<Integer>();

		// (1) ตั้งค่ารายละเอียดกราฟตามรูปภาพโจทย์ 
		g.addEdge(0, 1, true);
		g.addEdge(0, 4, true);
		g.addEdge(1, 2, true);
		g.addEdge(1, 3, true);
		g.addEdge(1, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(3, 4, true);

		// แสดงโครงสร้างกราฟ (Adjacency List) [cite: 127]
		System.out.println("Graph:");
		System.out.println(g.toString());

		// (2.1) แสดงจำนวน Vertex
		g.getVertexCount();

		// (2.2) แสดงจำนวน Edges
		g.getEdgesCount(true);

		// (2.3) ตรวจสอบเส้นเชื่อมระหว่าง 3 และ 4
		g.hasEdge(3, 4);

		// (2.4) ตรวจสอบว่ามี Vertex 5 หรือไม่
		g.hasVertex(5);
	}
}