package logic;

import java.util.*;
import java.util.stream.*;

public class Range {
	private String idx0;// instance variables - [idx0, idx1]
	private String idx1;

	public Range() {
	}

	public Range(String a, String b) {// parameterized constructor
		this.idx0 = a;
		this.idx1 = b;
	}

	public String getIdx0() {
		return idx0;
	}

	public void setIdx0(String idx0) {
		this.idx0 = idx0;
	}

	public String getIdx1() {
		return idx1;
	}

	public void setIdx1(String idx1) {
		this.idx1 = idx1;
	}

	@Override
	public String toString() {
		return "[" + this.idx0 + "," + this.idx1 + "]";
	}

	// produces the minimum number of ranges required to represent the same
	// restrictions as the input
	public static List<Range> reformat(List<Range> lst) {
		List<Range> res = new ArrayList<Range>();
		if (lst.isEmpty() || lst == null)
			return res;// edge case
		// sort list by idx0
		List<Range> lstReorder = lst.stream().sorted(Comparator.comparing(Range::getIdx0)).collect(Collectors.toList());
		int prevIdx0 = 0, prevIdx1 = 0;
		for (Range r : lstReorder) {
			if (res.isEmpty() || prevIdx1 < Integer.parseInt(r.idx0)) {// 'prevIdx1 == r.idx0' is not included
				res.add(r);
				prevIdx1 = Integer.parseInt(r.idx1);
				prevIdx0 = Integer.parseInt(r.idx0);
			} else {
				prevIdx1 = Math.max(prevIdx1, Integer.parseInt(r.idx1));
				res.set(res.size() - 1, new Range(String.format("%05d", prevIdx0), String.format("%05d", prevIdx1)));
			}
		}
		return res;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj.getClass() != this.getClass()) {
			return false;
		}

		final Range other = (Range) obj;

		if ((this.idx0 == null) ? (other.idx0 != null) : !this.idx0.equals(other.idx0)) {
			return false;
		}
		if ((this.idx1 == null) ? (other.idx1 != null) : !this.idx1.equals(other.idx1)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + (this.idx0 != null ? this.idx0.hashCode() : 0);
		hash = 53 * hash + (this.idx1 != null ? this.idx1.hashCode() : 0);
		return hash;
	}
}
