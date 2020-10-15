import java.util.*;
import java.util.stream.*;
public class Range {
    int idx0, idx1;//instance variables
    Range() {}
    Range(int a, int b) {//parameterized constructor
        this.idx0 = a;
        this.idx1 = b;
    }
    public int getIdx0() {
        return this.idx0;
    }
    @Override
    public String toString() {
        return "[" + this.idx0 + "," + this.idx1 + "]";
    }
    List<Range> reformat(List<Range> lst) {
        List<Range> res = new ArrayList<Range>();
        if (lst.isEmpty() || lst == null) return res;//edge case
        List<Range> lstReorder = lst.stream().sorted(Comparator.comparing(Range::getIdx0)).collect(Collectors.toList());//sort lst by idx0
        int prevIdx0 = 0, prevIdx1 = 0;
        for (Range r : lstReorder){
            if (res.isEmpty() || prevIdx1 < r.idx0) {//'prevIdx1 == r.idx0' is not included
                res.add(r);
                prevIdx1 = r.idx1;
                prevIdx0 = r.idx0;
            } else {
                prevIdx1 = Math.max(prevIdx1, r.idx1);
                res.set(res.size()-1, new Range(prevIdx0, prevIdx1));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Range obj = new Range();
        //test case 1
        List<Range> ranges1 = Arrays.asList(new Range(19104,19104), new Range(93200,93400), new Range(93100,93200));
        System.out.println("test case 1 Before: " + Arrays.toString(ranges1.toArray()));
        List<Range> res1 = obj.reformat(ranges1);
        System.out.println("test case 1 After: " + Arrays.toString(res1.toArray()));
        //test case 2
        List<Range> ranges2 = Arrays.asList(new Range(94133,94133), new Range(94200,94299), new Range(94600,94699));
        System.out.println("test case 2 Before: " + Arrays.toString(ranges2.toArray()));
        List<Range> res2 = obj.reformat(ranges2);
        System.out.println("test case 2 After: " + Arrays.toString(res2.toArray()));
        //test case 3
        List<Range> ranges3 = Arrays.asList(new Range(11112,11113), new Range(11112,22222), new Range(11111,33333));
        System.out.println("test case 3 Before: " + Arrays.toString(ranges3.toArray()));
        List<Range> res3 = obj.reformat(ranges3);
        System.out.println("test case 3 After: " + Arrays.toString(res3.toArray()));
// output - 
// test case 1 Before: [[19104,19104], [93200,93400], [93100,93200]]
// test case 1 After: [[19104,19104], [93100,93400]]
// test case 2 Before: [[94133,94133], [94200,94299], [94600,94699]]
// test case 2 After: [[94133,94133], [94200,94299], [94600,94699]]
// test case 3 Before: [[11112,11113], [11111,22222], [0,33333]]
// test case 3 After: [[0,33333]]
    }
}



/*
BACKGROUND
Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

PROBLEM
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

NOTES
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

EXAMPLES:
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

Evaluation Guidelines:
Your work will be evaluated against the following criteria:
- Successful implementation
- Efficiency of the implementation
- Design choices and overall code organization
- Code quality and best practices
*/
