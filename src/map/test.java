package map;

public class test {
	
	static HashTable<String,Integer> table;
	
	public static void main(String[] args) {
		table = new HashTable<String,Integer>();
		System.out.println("Hola "+table.size());
		table.put("Kliver", 1);
		System.out.println("Hola "+table.size());
	}

}
