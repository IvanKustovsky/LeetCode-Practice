package solutions;

import dataStructures.ListNode;
import dataStructures.TreeNode;


import java.util.*;


public class Solution {
    //Пошук індексів двох чисел, значення яких у сумі рівні заданій цілі(target)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer requiredNum = target - nums[i];
            if (map.containsKey(requiredNum)) {
                return new int[]{map.get(requiredNum), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    //Перетворення числа з римської си-ми числення в десяткову
    public int romanToInt(String str) {
        Character[] letters = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(letters[i], values[i]);
        }
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((i != str.length() - 1) && (map.get(str.charAt(i + 1))) > map.get((str.charAt(i)))) {
                result += (map.get((str.charAt(i + 1))) - map.get((str.charAt(i))));
                i++;
            } else {
                result += map.get((str.charAt(i)));
            }
        }
        return result;
    }

    // Перетворення з десяткової си-ми числення в римську - моє рішення
    public String intToRoman(int num) {
        List<String> letters = Arrays.asList("I", "V", "X", "L", "C", "D", "M", "IV", "IX", "XL", "XC", "CD", "CM");
        List<Integer> values = Arrays.asList(1, 5, 10, 50, 100, 500, 1000, 4, 9, 40, 90, 400, 900);
        if (values.contains(num)) {
            return letters.get(values.indexOf(num));
        }
        StringBuilder res = new StringBuilder();
        int digits = (int) Math.log10(num) + 1; // Кількість цифр в числі   (562 -> 3)
        //Заповнюємо строку
        int temp, degree, fiveOrOne, currentNum = num / ((int) Math.pow(10, digits - 1));
        for (int i = 0; i < digits; i++) {
            degree = (int) Math.pow(10, digits - 1 - i);
            currentNum = (num / degree == currentNum) ? (num / degree) : currentNum;
            temp = currentNum * degree;
            if (temp == 0) {
                num = num % degree;
                currentNum = num * 10 / (degree);
                continue;
            }
            if (values.contains(temp)) {
                res.append(letters.get(values.indexOf(temp)));
                num = num % degree;
                currentNum = num * 10 / (degree);
                continue;
            }
            fiveOrOne = (temp > 5 * degree) ? 5 : 1;
            res.append(letters.get(values.indexOf(fiveOrOne * degree)));
            currentNum -= fiveOrOne;
            i--;
        }
        return res.toString();
    }

    // Найкраще рішення
    public String integerToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num >= values[i]) {
                sb.append(romanNumerals[i]);
                num -= values[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    // Пошук найдовшого спільного префікса
    public String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        Arrays.sort(strings);
        String first = strings[0];
        String last = strings[strings.length - 1];

        int c = 0;
        while (c < first.length()) {
            if (first.charAt(c) == last.charAt(c)) {
                c++;
            } else {
                break;
            }
        }

        return c == 0 ? "" : first.substring(0, c);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // Invalid character or mismatched brackets
            }
        }

        return stack.isEmpty();
    }

    //Злиття двох неспадкових списків
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
        }
        return list2;
    }

    public int removeDuplicates(int[] nums) { // повертає кількість не дублікатів у масиві
        int k = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[k++] = nums[i + 1];
            }
        }
        return k;
    }

    public int removeElement(int[] array, int val) {
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != val) {
                array[position++] = array[i];
            }
        }
        return position;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }
        }
        return -1;
    }

    //Додаємо 1 до великого числа (число може не входити в діапазон Int, але буде результат)
    public int[] plusOne(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[digits.length - 1 - i] == 9) {
                if (i == digits.length - 1) {
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    return result;
                }
                digits[digits.length - 1 - i] = 0;
            } else {
                digits[digits.length - 1 - i]++;
                return digits;
            }
        }
        return digits;
    }

    // Рахуємо кількість варіантів підйому по сходах при умові, що можна переходити 1 або 2 сходинки за 1 крок
    public int climbStairs(int n) {
        int[] array = new int[n + 1];
        array[n] = 1;
        array[n - 1] = 1;
        for (int k = n - 2; k >= 0; k--) {
            array[k] = array[k + 1] + array[k + 2];
        }
        return array[0];
    }

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] != target && nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }

    public int lengthOfLastWord(String s) {
        int res = 0;
        int start = s.length() - 1;
        while (s.charAt(start) == ' ' && start > 0) {
            start--;
        }
        while (start >= 0 && s.charAt(start--) != ' ') {
            res++;
        }
        return res;
    }

    public int mySqrt(int x) {
        double eps = 0.001, n0 = x / 2., ni = (n0 + x / n0) / 2;
        while (Math.abs(ni - n0) >= eps) {
            n0 = ni;
            ni = (n0 + x / n0) / 2;
        }
        return (int) ni;
    }

    public int lengthOfLongestSubstring(String s) { // Level - Medium
        int maxLength = 0;
        Map<Character, Integer> visitedCharacters = new HashMap<>();
        for (int right = 0, left = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (visitedCharacters.containsKey(currentChar) &&
                    visitedCharacters.get(currentChar) >= left) {
                left = visitedCharacters.get(currentChar) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            visitedCharacters.put(currentChar, right);
        }
        return maxLength;
    }

    public List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        List<Integer> currentRow;
        for (int i = 0; i < numRows; i++) {
            currentRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                    List<Integer> prevRow = pascalTriangle.get(i - 1);
                    int value = prevRow.get(j - 1) + prevRow.get(j);
                    currentRow.add(value);
                }

            }
            pascalTriangle.add(currentRow);
        }
        return pascalTriangle;
    }

    /*public int majorityElement(int[] nums) { // Level - Easy
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        n = n / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        return 0;
    }*/

    public int majorityElement(int[] nums) {   // Better option
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n / 2];
    }

    /*public String addBinary(String a, String b) {  // my initial solution ??
        int difference = a.length() - b.length();
        String zeroString = "0".repeat(Math.abs(difference));
        StringBuilder newA = new StringBuilder(a);
        StringBuilder newB = new StringBuilder(b);
        if (difference < 0) {
            newA.insert(0, zeroString);
        }
        if (difference > 0) {
            newB.insert(0, zeroString);
        }

        StringBuilder result = new StringBuilder();
        int isShifted = 0;
        for (int i = newA.length() - 1; i >= 0; i--) {
            int value1 = Integer.parseInt(Character.toString(newA.charAt(i)));
            int value2 = Integer.parseInt(Character.toString(newB.charAt(i)));
            if (value1 == 0 && value2 == 0 && isShifted == 0) {
                result.insert(0, "0");
                continue;
            }
            int sum = value1 + value2 + isShifted;
            if (sum == 2) {
                if (i == 0) {
                    result.insert(0, "10");
                } else {
                    result.insert(0, "0");
                    isShifted = 1;
                }
                continue;
            }
            if (sum == 3) {
                if (i == 0) {
                    result.insert(0, "11");
                } else {
                    result.insert(0, "1");
                }
                isShifted = 1;
                continue;
            }
            result.insert(0, "1");
            isShifted = 0;
        }
        return result.toString();
    }*/

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digitA = i >= 0 ? a.charAt(i) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j) - '0' : 0;
            int currentSum = digitA + digitB + carry;

            result.insert(0, currentSum % 2);
            carry = currentSum / 2;

            i--;
            j--;
        }

        return result.toString();
    }


    //List is guaranteed to be sorted
    public ListNode deleteDuplicates(ListNode head) { // 1 1 2 3 3 => 1 2 3
        ListNode pointer = head;

        while (pointer != null && pointer.next != null) {
            if (pointer.val == pointer.next.val) {
                pointer.next = pointer.next.next; // Skip the duplicate node
            } else {
                pointer = pointer.next; // Move to the next node
            }
        }
        return head;
    }


    // My initial solution
    /*public boolean hasCycle(ListNode head) {  // 4 2 0 -4 -> 2 0 -4 -> 2 0 -4 ...
        Set<ListNode> visitedNodes = new HashSet<>();
        while (head != null) {
            if(visitedNodes.contains(head)){
                return true;
            }
            visitedNodes.add(head);
            head = head.next;
        }
        return false;
    }*/

    // Best option - Two Pointers method
    public boolean hasCycle(ListNode head) {
        ListNode slow_pointer = head, fast_pointer = head;
        while (fast_pointer != null && fast_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
            if (slow_pointer == fast_pointer) {
                return true;
            }
        }
        return false;
    }

    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

    public int[] getConcatenation(int[] nums) {
        int lengthOfGivenArray = nums.length;
        int[] result = new int[lengthOfGivenArray * 2];
        for (int i = 0; i < lengthOfGivenArray; i++) {
            result[i] = nums[i];
            result[i + lengthOfGivenArray] = nums[i];
        }
        return result;

        /*int[] arr=new int[2*nums.length];
        System.arraycopy(nums,0,arr,0,nums.length);
        System.arraycopy(nums,0,arr,nums.length,nums.length);
        return arr;*/
    }

    public boolean isPrefixString(String s, String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (stringBuilder.length() >= s.length()) {
                break;
            }
            stringBuilder.append(word);
        }
        return s.equals(stringBuilder.toString());
    }

    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (Integer num : nums) {
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        for (int i = min; i > 1; i--) {
            if (min % i == 0 && max % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public int minimumDifference(int[] nums, int k) {
        if (k == 1 || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int minDifference = Integer.MAX_VALUE;
        int min, max;
        for (int i = nums.length; i >= k; i--) {
            max = nums[i - 1];
            min = nums[i - k];
            if (minDifference > (max - min)) {
                minDifference = max - min;
            }
        }
        return minDifference;
    }


    public String firstPalindrome(String[] words) {
        for (String word : words) {
            int wordLength = word.length();
            for (int i = 0; i <= wordLength / 2; i++) {
                if (word.charAt(i) != word.charAt(wordLength - 1 - i)) {
                    break;
                }
                if (i == (wordLength / 2)) {
                    return word;
                }
            }
        }
        return "";
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            stringBuilder.append(Character.toString('A' + columnNumber % 26));
            columnNumber /= 26;

        }
        return stringBuilder.reverse().toString();
    }

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result = (result * 26) + (columnTitle.charAt(i) - ('A' - 1));
        }
        return result;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int k = m + n - 1;
        while (p2 >= 0) {

            //          0 1 2 3 4 5
            // nums1 = [1,2,3,0,0,0], nums2 = [2,5,6], p1=2, p2=2, k=5
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {

                //Iteration3:  3 > 2  p1=2, p2=0, k=3  nums1[3] = nums1[2]
                //[1,2,3,0,5,6] => [1,2,3,3,5,6]

                nums1[k--] = nums1[p1--];

            } else {

                //Iteration1: 3 < 6,    p1=2, p2=2, k=5
                //nums1 = [1,2,3,0,0,0] => [1,2,3,0,0,6]

                //Iteration2: 3 < 5     p1=2, p2=1, k=4
                // [1,2,3,0,0,6] => [1,2,3,0,5,6]

                //Iteration4:  2 < 2  p1=1, p2=0, k=2
                //[1,2,3,3,5,6]    =>    [1,2,2,3,5,6]
                nums1[k--] = nums2[p2--];
            }
        }
    }

    // Get a row from Pascal triangle rowIndex = 3 -> [1,3,3,1]
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        List<Integer> currentRow;
        for (int i = 0; i <= rowIndex; i++) {
            currentRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                    List<Integer> prevRow = pascalTriangle.get(i - 1);
                    int value = prevRow.get(j - 1) + prevRow.get(j);
                    currentRow.add(value);
                }

            }
            pascalTriangle.add(currentRow);
        }
        return pascalTriangle.get(rowIndex);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        helper(root, output);
        return output;
    }

    public void helper(TreeNode root, List<Integer> result) {
        if (root != null) {
            helper(root.left, result);
            result.add(root.val);
            helper(root.right, result);
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int maxDepthCount = 1;
        maxDepthCount += Math.max(maxDepth(root.left), maxDepth(root.right));
        return maxDepthCount;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return CreateBST(nums, 0, nums.length - 1);
    }

    private TreeNode CreateBST(int[] nums, int l, int r) {
        if (l > r) { // Base Condition or Recursion Stopping Condition
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]); // mid value or median
        root.left = CreateBST(nums, l, mid - 1); // assign the value for left of subtree that is l to mid -1 for given
        // array
        root.right = CreateBST(nums, mid + 1, r); // assign the value for right go subtree that is mid+1 to r for given
        // array
        return root;
    }

    public int maxProfit(int[] prices) { // 7 1 5 3 6 4 //todo
        int max = 0, length = prices.length;
        int[] restOfArray = new int[length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(prices, i + 1, restOfArray, i + 1, length - i - 1);
            Arrays.sort(restOfArray);
            max = Math.max(max, restOfArray[length - 1] - prices[i]);
        }
        return max;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            l2 = new ListNode(0);
        }
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        int carry = (l1.val + l2.val) / 10;
        if(l1.next == null){
            l1.next = new ListNode(carry);
        } else {
            l1.next.val = (l1.next.val + carry);
        }
        result.next = (l1.next.val == 0 && l2.next == null && l1.next.next == null) ? null : addTwoNumbers(l1.next, l2.next);
        return result;
    }

    public boolean isPowerOfTwo(int n) {
        // return (n > 0) && Integer.bitCount(n) == 1;
        for (int i = 0; i < 31; i++) {
            int ans = (int) Math.pow(2, i);
            if (ans == n) {
                return true;
            }
        }
        return false;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        helper(root, diameter);
        return diameter[0];
    }

    private int helper(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int leftHeight = helper(node.left, diameter);
        int rightHeight = helper(node.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

}


