import dataStructures.ListNode;
import org.junit.jupiter.api.Test;
import solutions.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void testTwoSum() { // За умовою довжина масиву >= 2
        // Тестовий набір даних
        int[] nums = {2, 7, 11, 15};

        // Тест 1: Позитивний сценарій, коли рішення існує
        int target1 = 9;
        int[] expected1 = {0, 1}; // Позиції елементів у масиві nums
        assertArrayEquals(expected1, solution.twoSum(nums, target1));

        // Тест 2: Позитивний сценарій, коли рішення відсутнє
        int target2 = 3;
        assertArrayEquals(null, solution.twoSum(nums, target2));
    }

    @Test
    public void testRomanToInt() {
        Solution solution = new Solution();

        // Тестові дані та очікувані результати
        String[] inputs = {"III", "IV", "IX", "LVIII", "MCMXCIV"};
        int[] expectedResults = {3, 4, 9, 58, 1994};

        // Перевірка кожного тесту
        for (int i = 0; i < inputs.length; i++) {
            int result = solution.romanToInt(inputs[i]);
            assertEquals(expectedResults[i], result);
        }
    }

    @Test
    public void testIntToRoman() {
        // Тестові дані та очікувані результати
        int[] inputs = {101,3, 4, 9, 30, 58, 1994};
        String[] expectedResults = {"CI", "III", "IV", "IX", "XXX", "LVIII", "MCMXCIV"};

        // Перевірка кожного тесту
        for (int i = 0; i < inputs.length; i++) {
            String result = solution.intToRoman(inputs[i]);
            assertEquals(expectedResults[i], result);
        }
    }

    @Test
    public void testIntegerToRoman() {
        // Тестові дані та очікувані результати
        int[] inputs = {101,3, 4, 9, 30, 58, 1994};
        String[] expectedResults = {"CI", "III", "IV", "IX", "XXX", "LVIII", "MCMXCIV"};

        // Перевірка кожного тесту
        for (int i = 0; i < inputs.length; i++) {
            String result = solution.integerToRoman(inputs[i]);
            assertEquals(expectedResults[i], result);
        }
    }

    @Test
    public void testLongestCommonPrefix() {
        // Тест 1: Загальний префікс - "fl"
        String[] input1 = {"flower", "flow", "flight"};
        assertEquals("fl", solution.longestCommonPrefix(input1));

        // Тест 2: Загальний префікс - "a"
        String[] input2 = {"apple", "ape", "april"};
        assertEquals("ap", solution.longestCommonPrefix(input2));

        // Тест 3: Загальний префікс - "dog"
        String[] input3 = {"dog", "dogs", "doghouse"};
        assertEquals("dog", solution.longestCommonPrefix(input3));

        // Тест 4: Порожній вхід
        String[] input4 = {};
        assertEquals("", solution.longestCommonPrefix(input4));

        // Тест 5: Вхід з одним елементом
        String[] input5 = {"singular"};
        assertEquals("singular", solution.longestCommonPrefix(input5));

        // Тест 6: Вхід з пустим рядком
        String[] input6 = {"", "hello", "world"};
        assertEquals("", solution.longestCommonPrefix(input6));

        String[] input7 = {"ab", "a"};
        assertEquals("a", solution.longestCommonPrefix(input7));
    }

    @Test
    public void testIsValid() {
        Solution solution = new Solution();

        // Тест 1: Правильна послідовність дужок
        assertTrue(solution.isValid("()"));

        // Тест 2: Правильна послідовність дужок з квадратними дужками
        assertTrue(solution.isValid("([])"));

        // Тест 3: Неправильна послідовність дужок
        assertFalse(solution.isValid("([)]"));

        // Тест 4: Порожній рядок
        assertTrue(solution.isValid(""));

        // Тест 5: Дужки без закриваючих дужок
        assertFalse(solution.isValid("("));

        // Тест 6: Закриваюча дужка без відповідної відкриваючої дужки
        assertFalse(solution.isValid(")"));

        // Тест 7: Правильна послідовність дужок з фігурними дужками
        assertTrue(solution.isValid("{([])}"));

        // Тест 8: Неправильна послідовність дужок з фігурними дужками
        assertFalse(solution.isValid("{([])"));
    }

    @Test
    public void testMergeTwoLists() {
        // Створюємо список 1: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        // Створюємо список 2: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        // Очікуваний результат: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode expectedResult = new ListNode(1);
        expectedResult.next = new ListNode(2);
        expectedResult.next.next = new ListNode(3);
        expectedResult.next.next.next = new ListNode(4);
        expectedResult.next.next.next.next = new ListNode(5);
        expectedResult.next.next.next.next.next = new ListNode(6);

        // Перевірка результату
        ListNode result = solution.mergeTwoLists(list1, list2);
        assertTrue(areListsEqual(expectedResult, result));
    }

    private boolean areListsEqual(ListNode list1, ListNode list2) {
        while (list1 != null && list2 != null) {
            if (list1.val != list2.val) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return list1 == null && list2 == null;
    }

    @Test
    public void testRemoveDuplicates() {
        // Тест 1: Масив без дублікатів
        int[] nums1 = {1, 2, 3, 4, 5};
        assertEquals(5, solution.removeDuplicates(nums1));

        // Тест 2: Масив з дублікатами
        int[] nums2 = {1, 1, 2, 2, 3, 4, 5};
        assertEquals(5, solution.removeDuplicates(nums2));
    }

    @Test
    public void testRemoveElement() {
        // Тест 1: Видалення елементу, який є в масиві
        int[] array1 = {1, 2, 3, 4, 5};
        int val1 = 3;
        int[] expected1 = {1, 2, 4, 5};
        int length1 = solution.removeElement(array1, val1);
        assertEquals(4, length1);
        assertArrayEquals(expected1, Arrays.copyOf(array1, length1));

        // Тест 2: Видалення елементу, якого немає в масиві
        int[] array2 = {1, 2, 3, 4, 5};
        int val2 = 6;
        int[] expected2 = {1, 2, 3, 4, 5}; // Масив не зміниться
        int length2 = solution.removeElement(array2, val2);
        assertEquals(5, length2);
        assertArrayEquals(expected2, Arrays.copyOf(array2, length2));
    }

    @Test
    public void testStrStr() {
        // Тест 1: Знайти підрядок у рядку
        String haystack1 = "hello";
        String needle1 = "ll";
        int expected1 = 2; // "ll" починається з позиції 2 у "hello"
        assertEquals(expected1, solution.strStr(haystack1, needle1));

        // Тест 2: Підрядок відсутній у рядку
        String haystack2 = "hello";
        String needle2 = "world";
        int expected2 = -1; // "world" не знайдено у "hello"
        assertEquals(expected2, solution.strStr(haystack2, needle2));

        // Тест 3: Порожній підрядок
        String haystack3 = "hello";
        String needle3 = "";
        int expected3 = 0; // Порожній підрядок знаходиться на початку рядка
        assertEquals(expected3, solution.strStr(haystack3, needle3));

        // Тест 4: Порожній рядок
        String haystack4 = "";
        String needle4 = "abc";
        int expected4 = -1; // "abc" не знайдено у порожньому рядку
        assertEquals(expected4, solution.strStr(haystack4, needle4));
    }

    @Test
    public void testPlusOne() {
        // Тест 1: Додаємо 1 до числа 123
        int[] digits1 = {1, 2, 3};
        int[] expected1 = {1, 2, 4};
        assertArrayEquals(expected1, solution.plusOne(digits1));

        // Тест 2: Додаємо 1 до числа 9
        int[] digits2 = {9};
        int[] expected2 = {1, 0};
        assertArrayEquals(expected2, solution.plusOne(digits2));
    }

    @Test
    public void testClimbStairs() {
        // Тест 1: 2 способи підйому по сходах на 2 ступені
        assertEquals(2, solution.climbStairs(2));

        // Тест 2: 3 способи підйому по сходах на 3 ступені
        assertEquals(3, solution.climbStairs(3));
    }

    @Test
    public void testSearchInsert() {
        // Тест 1: Вставка елементу в середину масиву
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        assertEquals(2, solution.searchInsert(nums1, target1));

        // Тест 2: Вставка елементу в початок масиву
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 0;
        assertEquals(0, solution.searchInsert(nums2, target2));

        // Тест 3: Вставка елементу в кінець масиву
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        assertEquals(4, solution.searchInsert(nums3, target3));
    }

    @Test
    public void testLengthOfLastWord() {
        // Тест 1: Довжина останнього слова "world"
        assertEquals(5, solution.lengthOfLastWord("Hello world  "));

        // Тест 2: Довжина останнього слова "test"
        assertEquals(4, solution.lengthOfLastWord("Just a test       "));
    }

    @Test
    public void testMySqrt() {
        // Тест 1: Квадратний корінь з числа 16
        assertEquals(4, solution.mySqrt(16));

        // Тест 2: Квадратний корінь з числа 8
        assertEquals(2, solution.mySqrt(8));

        // Тест 3: Квадратний корінь з числа 55
        assertEquals(7, solution.mySqrt(55));
    }

    @Test
    public void testLengthOfLongestSubstring() {
        // Тест 1: Довжина найбільшого підрядка без повторень у "abcabcbb"
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));

        // Тест 2: Довжина найбільшого підрядка без повторень у "bbbbb"
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));

        // Тест 3: Довжина найбільшого підрядка без повторень у "pwwkew"
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void testGenerate() {
        // Тест 1: Перевірка для numRows = 1
        int numRows1 = 1;
        List<List<Integer>> expected1 = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        expected1.add(row1);
        assertEquals(expected1, solution.generatePascalTriangle(numRows1));

        // Тест 2: Перевірка для numRows = 2
        int numRows2 = 2;
        List<List<Integer>> expected2 = new ArrayList<>();
        List<Integer> row2_1 = new ArrayList<>();
        row2_1.add(1);
        List<Integer> row2_2 = new ArrayList<>();
        row2_2.add(1);
        row2_2.add(1);
        expected2.add(row2_1);
        expected2.add(row2_2);
        assertEquals(expected2, solution.generatePascalTriangle(numRows2));

        // Тест 3: Перевірка для numRows = 5
        int numRows3 = 5;
        List<List<Integer>> expected3 = new ArrayList<>();
        List<Integer> row3_1 = new ArrayList<>();
        row3_1.add(1);
        List<Integer> row3_2 = new ArrayList<>();
        row3_2.add(1);
        row3_2.add(1);
        List<Integer> row3_3 = new ArrayList<>();
        row3_3.add(1);
        row3_3.add(2);
        row3_3.add(1);
        List<Integer> row3_4 = new ArrayList<>();
        row3_4.add(1);
        row3_4.add(3);
        row3_4.add(3);
        row3_4.add(1);
        List<Integer> row3_5 = new ArrayList<>();
        row3_5.add(1);
        row3_5.add(4);
        row3_5.add(6);
        row3_5.add(4);
        row3_5.add(1);
        expected3.add(row3_1);
        expected3.add(row3_2);
        expected3.add(row3_3);
        expected3.add(row3_4);
        expected3.add(row3_5);
        assertEquals(expected3, solution.generatePascalTriangle(numRows3));
    }

    @Test
    public void testMajorityElement() {
        // Тест 1: Перевірка для масиву з одним елементом
        int[] nums1 = {3};
        assertEquals(3, solution.majorityElement(nums1));

        // Тест 2: Перевірка для масиву з парним числом елементів, де є більшість
        int[] nums2 = {2, 2, 3, 3, 2, 2, 2};
        assertEquals(2, solution.majorityElement(nums2));

        // Тест 3: Перевірка для масиву з парним числом елементів, де немає більшості
        int[] nums3 = {2, 3, 3, 2, 2, 3, 3};
        assertEquals(3, solution.majorityElement(nums3));

        // Тест 4: Перевірка для масиву з непарним числом елементів, де є більшість
        int[] nums4 = {2, 2, 2, 3, 3, 2, 2};
        assertEquals(2, solution.majorityElement(nums4));

        // Тест 5: Перевірка для масиву з непарним числом елементів, де немає більшості
        int[] nums5 = {2, 3, 3, 2, 2, 3, 3, 3};
        assertEquals(3, solution.majorityElement(nums5));
    }

    @Test
    public void testAddBinary() {
        // Тест 1: Перевірка для двійкових чисел "11" і "1"
        assertEquals("100", solution.addBinary("11", "1"));

        // Тест 2: Перевірка для двійкових чисел "1010" і "1011"
        assertEquals("10101", solution.addBinary("1010", "1011"));

        // Тест 3: Перевірка для двійкових чисел "0" і "0"
        assertEquals("0", solution.addBinary("0", "0"));

        // Тест 4: Перевірка для двійкових чисел "1101" і "101"
        assertEquals("10010", solution.addBinary("1101", "101"));
    }

    @Test
    public void testDeleteDuplicates() {
        // Тест 1: Перевірка для списку без дублікатів
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        ListNode expected1 = solution.deleteDuplicates(head1);
        assertEquals(head1, expected1);

        // Тест 2: Перевірка для списку з дублікатами
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        ListNode expected2 = solution.deleteDuplicates(head2);
        assertEquals(head2, expected2);

        // Тест 3: Перевірка для порожнього списку
        ListNode head3 = null;
        ListNode expected3 = solution.deleteDuplicates(head3);
        assertNull(expected3);
    }

    @Test
    public void testHasCycle() {
        // Тест 1: Перевірка для списку з циклом
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = head1; // цикл
        assertTrue(solution.hasCycle(head1));

        // Тест 2: Перевірка для списку без циклу
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        assertFalse(solution.hasCycle(head2));
    }

    @Test
    public void testBuildArray() {
        // Тест 1: Перевірка для масиву {0,1,2,3,4}
        int[] nums1 = {0,1,2,3,4};
        int[] expected1 = {0,1,2,3,4};
        assertArrayEquals(expected1, solution.buildArray(nums1));

        // Тест 2: Перевірка для масиву {5,0,1,2,3,4}
        int[] nums2 = {5,0,1,2,3,4};
        int[] expected2 = {4,5,0,1,2,3};
        assertArrayEquals(expected2, solution.buildArray(nums2));
    }

    @Test
    public void testGetConcatenation() {
        // Тест 1: Перевірка для масиву {1,2,3}
        int[] nums1 = {1,2,3};
        int[] expected1 = {1,2,3,1,2,3};
        assertArrayEquals(expected1, solution.getConcatenation(nums1));

        // Тест 2: Перевірка для масиву {1}
        int[] nums2 = {1};
        int[] expected2 = {1,1};
        assertArrayEquals(expected2, solution.getConcatenation(nums2));
    }

    @Test
    public void testIsPrefixString() {
        // Тест 1: Перевірка для "abcdef" та {"ab", "abc", "def"}
        String s1 = "iloveleetcode";
        String[] words1 = {"i","love","leetcode","apples"};
        assertTrue(solution.isPrefixString(s1, words1));

        // Тест 2: Перевірка для "hello" та {"cat", "dog", "bird"}
        String s2 = "hello";
        String[] words2 = {"cat", "dog", "bird"};
        assertFalse(solution.isPrefixString(s2, words2));
    }

    @Test
    public void testFindGCD() { // GCD - greatest common divisor of smallest and largest numbers of array
        // Тест 1: Перевірка для масиву {2, 3, 4}
        int[] nums1 = {2, 3, 4};
        assertEquals(2, solution.findGCD(nums1));

        // Тест 2: Перевірка для масиву {6, 8, 10}
        int[] nums2 = {6, 8, 10};
        assertEquals(2, solution.findGCD(nums2));
    }

    @Test
    public void testMinimumDifference() {
        // Тест 1: Перевірка для масиву {9, 4, 1, 7} та k = 2
        int[] nums1 = {9, 4, 1, 7};
        int k1 = 2;
        assertEquals(2, solution.minimumDifference(nums1, k1));

        // Тест 2: Перевірка для масиву {9, 4, 1, 7} та k = 3
        int k2 = 3;
        assertEquals(5, solution.minimumDifference(nums1, k2));
    }

    @Test
    public void testFirstPalindrome() {
        // Тест 1: Перевірка для масиву {"racecar", "hello", "wow"}
        String[] words1 = {"racecar", "hello", "wow"};
        assertEquals("racecar", solution.firstPalindrome(words1));

        // Тест 2: Перевірка для масиву {"apple", "banana", "orange"}
        String[] words2 = {"apple", "banana", "orange"};
        assertEquals("", solution.firstPalindrome(words2));
    }

    @Test
    public void testConvertToTitle() {
        // Тест 1: Перевірка для columnNumber = 1
        assertEquals("A", solution.convertToTitle(1));

        // Тест 2: Перевірка для columnNumber = 28
        assertEquals("AB", solution.convertToTitle(28));

        // Тест 3: Перевірка для columnNumber = 701
        assertEquals("ZY", solution.convertToTitle(701));
    }

    @Test
    public void testTitleToNumber() {
        // Тест 1: Перевірка для columnTitle = "A"
        assertEquals(1, solution.titleToNumber("A"));

        // Тест 2: Перевірка для columnTitle = "AB"
        assertEquals(28, solution.titleToNumber("AB"));
    }
}
