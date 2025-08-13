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
|[347-Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)|We create a hashmap containing the integers and their count. And then we use a max-heap (`PriorityQueue<Integer>`) to store integers in the decreasing order of their counts. Thus create an integer array of size and `poll()` k elements from the heap.|[Code](01_Arrays_and_Hashing/C05_347_Top_K_Frequent_Elements.java)|
|[271-Encode and Decode Strings](#)|...|[Code](01_Arrays_and_Hashing/C06_271_Encode_and_Decode_Strings.java)|
|[238-Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self)|Make use of Prefix & Postfix Multiplication. For optimized solution calculate everything in the `res[]` array by only using two variables `pre` and `post`.|[Code](01_Arrays_and_Hashing/C07_238_Product_of_Array_Except_Self.java)|
|[36-Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)|You'll need three array of `HashSet` - one for row, column and box. Then traverse the elements of the board one-by-one and check in respective hashset, if certain element is repeating twice - if so return false i.e. not a valid sudoku. If everything passes implies valid sudoku. For identifying hashset for the box use `int boxIndex = (i/3) * 3 + (j/3);`|[Code](01_Arrays_and_Hashing/C08_36_Valid_Sudoku.java)|