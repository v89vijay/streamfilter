package pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo {
	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP", 25000, ""));
		productsList.add(new Product(2, "HP", 30000, ""));
		productsList.add(new Product(3, "Sony", 208000, ""));
		productsList.add(new Product(4, "Sony", 28000, ""));
		productsList.add(new Product(5, "Apple", 90000, ""));
		productsList.add(new Product(6, "HP", 70000, ""));
		Set<Map.Entry<String, List<Product>>> set = productsList.stream().collect(Collectors.groupingBy(p -> p.name))
				.entrySet();
		List finalList = new ArrayList();
		set.stream().forEach(u -> {
//			System.out.println("List==>"+u.setValue(productsList));
//			System.out.println("\n"+ "====" + u.getKey());
			List status = getStatus(u.getKey(), u.setValue(productsList));
//			System.out.println("all final List status=" + status);
			finalList.addAll(status);
			// updateStatus(u.getKey(), status, u.setValue(productsList));
			
		});
		
		System.out.println("all final List status=" + finalList);
	}

	public static List getStatus(String key, List<Product> list) {
		int sum = list.stream().filter(o -> o.name.equalsIgnoreCase(key)).map(p -> p.price).reduce((s, d) -> s + d)
				.get();
		List loop = new ArrayList();
		String prodName = list.stream().map(p -> p.name).collect(Collectors.toSet()).toString();
		System.out.println(key + "==" + sum);
		if (key.equalsIgnoreCase("hp") && sum > 100000) {
			List li = list.stream().filter(p -> p.name.equals(key)).collect(Collectors.toList());
			updateStatus("T", li);
			loop.addAll(li);
			return loop;
		} else if (key.equalsIgnoreCase("apple") && sum > 100000) {
			List li = list.stream().filter(p -> p.name.equals(key)).collect(Collectors.toList());
			updateStatus("T", li);
			loop.addAll(li);
			return loop;
		} else if (key.equalsIgnoreCase("sony") && sum > 100000) {
			List li = list.stream().filter(p -> p.name.equals(key)).collect(Collectors.toList());
			updateStatus("T", li);
			loop.addAll(li);
			return loop;
		}
//------------------------------------------------		
		if (key.equalsIgnoreCase("hp") && sum < 100000) {
			List li = list.stream().filter(p -> p.name.equals(key)).collect(Collectors.toList());
			updateStatus("A", li);
			loop.addAll(li);
			return loop;
		} else if (key.equalsIgnoreCase("apple") && sum < 100000) {
			List li = list.stream().filter(p -> p.name.equals(key)).collect(Collectors.toList());
			updateStatus("A", li);
			loop.addAll(li);
			return loop;
		} else if (key.equalsIgnoreCase("sony") && sum < 100000) {
			List li = list.stream().filter(p -> p.name.equals(key)).collect(Collectors.toList());
			updateStatus("A", li);
			loop.addAll(li);
			return loop;
		}		
		
		return null;
	}

	public static List<Product> updateStatus(String status, List<Product> list) {
		list.stream().forEach(f -> {
			f.status = status;
		});
//		System.out.println("===>" + list);
		return list;
	}

}

class Product {
	int id;
	String name;
	int price;
	String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product() {
		super();
	}

	public Product(int id, String name, int price, String status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", status=" + status + "]";
	}
}