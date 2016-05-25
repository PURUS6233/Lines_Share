package ua.purus6233.Sort;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		return Integer.signum(s1.length() - s2.length());
	}
}