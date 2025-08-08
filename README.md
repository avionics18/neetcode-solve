# NeetCode Problems

Contains problems and solutions to [neetcode](https://neetcode.io/) 150 problems sheet.

<br>

### Arrays & Hashing

|Problem|Trick|Link|
|-|-|-|
|[217-Contains Duplicate](https://leetcode.com/problems/contains-duplicate)|We want a container where search is instant, so we can go for `HashMap`, but since key & value both are same, we went for `HashSet` as it also stores unique elements. Now while adding a new element to the set check if the element already exists, if yes implies duplicate exists.|[Code](01_Arrays_and_Hashing/C01_217_Contains_Duplicate.java)|
|[242-Valid Anagram](https://leetcode.com/problems/valid-anagram)|First to be anagrams their lengths must be equal. Then we create a `count[]` of size 26 for each alphabet in english for storing count of each character in strings `s` and `t`. For each character in `s`, increment the count at the respective index and same for `t` except decrement the respective count. Finally, we should have an array where all elements are 0 only if they are valid anagrams.|[Code](01_Arrays_and_Hashing/C02_242_Valid_Anagram.java)|
|[1-Two Sum](https://leetcode.com/problems/two-sum)|We create a store (`HashMap`) of potential solutions untill we get the actual solution for which complementary exists in the hashmap, whose sum equals the `target`.|[Code](01_Arrays_and_Hashing/C03_1_Two_Sum.java)|
|[49-Group Anagrams](https://leetcode.com/problems/group-anagrams/)|For each string in strs, we will compute a `count[26]` array, and convert that count array to string. So, all those string which produce same count string implies are anagrams. And hence will group them into a list inside a hashmap.|[Code](01_Arrays_and_Hashing/C04_49_Group_Anagrams.java)|