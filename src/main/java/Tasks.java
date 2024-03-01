import java.util.*;

public class Tasks {
    // შეგიძლიათ ამ ამოცანებისთვის შეამოწმოთ ტესტერები
    int evaluateExpression(String expression) {

        if (expression.isEmpty()) {
            throw new IllegalArgumentException();
        }


        int ans = 0;
        int sign = 1;
        int currentNumber = -1;

        for (char c : expression.toCharArray()) {
            switch (c) {
                case '-': {
                    // this if statement handles the case in which the first number is negative
                    if (currentNumber >= 0) {
                        ans += currentNumber * sign;
                    }
                    currentNumber = -1;
                    sign = -1;
                    break;
                }
                case '+': {
                    // this if statement handles the case in which the first number is negative
                    if (currentNumber >= 0) {
                        ans += currentNumber * sign;
                    }
                    currentNumber = -1;
                    sign = 1;
                    break;
                }

                //this handles numbers
                default: {
                    if (currentNumber < 0) {
                        currentNumber = Integer.parseInt(c + "");
                    } else {
                        currentNumber = currentNumber * 10 + Integer.parseInt(c + "");
                    }
                }
            }
        }
        return ans + currentNumber * sign; //here we account for the final number
    }

    int numberOfHappyStrings(List<String> strings) {
        int ans = 0;
        for (String string : strings) {
            for (int i = 0; i < string.toCharArray().length - 1; i++) {
                if (string.charAt(i) == string.charAt(i + 1)) {
                    break;
                }
            }
            ans++;
        }
        return ans;
    }

    ListNode reverseList(ListNode head) {
        // handle null case
        if (head == null) {
            throw new IllegalArgumentException();
        }

        // one element case
        if (!head.hasNext()) {
            return head;
        }
        ListNode ans = new ListNode();
        reverseListRecursion(head, ans);
        return ans;
    }

    ListNode reverseListRecursion(ListNode current, ListNode newHead) {
        if (!current.hasNext()) {
            newHead.setVal(current.getVal());
            return newHead;
        } else {
            ListNode tempNode = reverseListRecursion(current.next, newHead);
            tempNode.setNext(new ListNode(current.getVal()));

            return tempNode.getNext();
        }
    }

    int[] findIntersection(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) {
            throw new IllegalArgumentException();
        }

        Set<Integer> answer = new HashSet<>();

        // პირობაში მოცემული იყო დალაგებული მასივები, მაგრამ არ იყო ნახსენები ყველა ინპუთი იქნებოდა თუ არა ასეთი ამიტომ დავალაგე თავის დაზღვევის მიზნით
        nums1 = Arrays.stream(nums1).sorted().toArray();
        nums2 = Arrays.stream(nums2).sorted().toArray();

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            if (nums1[pointer1] < nums2[pointer2]) {
                pointer1++;
            } else if (nums2[pointer2] < nums1[pointer1]) {
                pointer2++;
            } else {
                answer.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            }
        }
        return answer.stream().mapToInt(a -> a).toArray();
    }

    int lenOfLongSubarr(int[] array, int k) {
        if(array.length == 0){
            throw new IllegalArgumentException();
        }

        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            dp[i] = -1;
        }

        for (int num : array) {
            for (int i = k; i >= num; i--) {
                if (dp[i - num] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - num] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= k; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Tasks tas = new Tasks();
        System.out.println(tas.lenOfLongSubarr(new int[]{6, 2, 2, 3, 4, 1}, 8));
    }


    /*
    ამ ამოცანაში მაქვს შეკითხვა. იმ შემთხვევაში თუ მაგ. array = {1,2,1,3,4} და sequence = {1,2,3,4} სწორია მაინც?
    ამ ამოხსნაში ნაგულისხმებია რომ ეს სწორია, რადგან პირობაში არ არის გათვალისწინებული.
     */
    boolean isValidSequence(int[] array, int[] sequence) {

        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        if (sequence.length > array.length) {
            return false;
        }
        if (sequence.length == 0) {
            return true;
        }


        int pointer = 0;

        for (int j : array) {
            if (sequence[pointer] == j) {
                pointer++;
                if (pointer == sequence.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

