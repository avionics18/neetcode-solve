# NeetCode Problems

Contains problems and solutions to [neetcode](https://neetcode.io/) 150 problems sheet.

<br>

### Arrays & Hashing

|Problem|Trick|Link|
|-|-|-|
|[217-Contains Duplicate](https://leetcode.com/problems/contains-duplicate)|Use `HashSet` to store unique elements. While adding check if the element already exists, if yes implies duplicate exists.|[Code](01_Arrays_and_Hashing/C01_217_Contains_Duplicate.java)|
|[242-Valid Anagram](https://leetcode.com/problems/valid-anagram)|First check their lengths must be equal, then create an array of size `26` for storing count of each character in strings `s` and `t`. For each character in `s`, increment the corresponding count at the respective index. And in `t`, for each character decrement the count. Finally, we should have an array where all elements are 0, if they are valid anagrams.|[Code](01_Arrays_and_Hashing/C02_242_Valid_Anagram.java)|
|[1-Two Sum](https://leetcode.com/problems/two-sum)|We create a store (`HashMap`) of potential solutions untill we get the actual solution for which complementary exists in the hashmap, whose sum equals the `target`.|[Code](01_Arrays_and_Hashing/C03_1_Two_Sum.java)|