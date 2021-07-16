package Lab060;
import java.util.*;
class Link implements Comparable<Link> {
	public String ref;
	public int weight;

	public Link(String ref) {
		this.ref = ref;
		weight = 1;
	}

	public Link(String ref, int weight) {
		this.ref = ref.toLowerCase();
		this.weight = weight;
	}

	public String getRef() {
		return ref;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public boolean equals(Object obj) {
		if (ref != null && obj instanceof Link) {
			Link link = (Link) obj;
			if (link.ref == null)
				return false;
			return ref.equals(link.ref);
		}
		return false;
	}

	@Override
	public String toString() {
		return ref + "(" + weight + ")";
	}

	@Override
	public int compareTo(Link another) {
		String thisRef = this.getRef();
		String thatRef = another.getRef();
		int sizeDiff = Math.abs(thisRef.length() - thatRef.length());
		int bound = Math.max(thisRef.length(), thatRef.length()) - sizeDiff;
		for (int i = 0; i < bound; i++) {
			int a = (int) thisRef.charAt(i);
			int b = (int) thatRef.charAt(i);
			if (a > b || a < b) {
				return a - b;
			}
		}
		return thisRef.length() - thatRef.length();
	}
}

