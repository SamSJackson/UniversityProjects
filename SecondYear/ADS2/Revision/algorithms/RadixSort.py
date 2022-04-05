# Radix Sort

# b is the base (base 10 is standard, base 2 is binary etc.)
# d is log_b(k) where k is maximum value (basically number of passes required)
# Best case: O(dn) (all elements have the same number of digits)
# Worst case: O(d(n+b))
# Average case: O(d(n+b))
# Stable: Yes
# In-place: False


# Explanation:
'''
Given we are using count_sort, there is a strong link there.
The important thing is that radix sort requires a stable sorting algorithm.

Best way to view the radix sort is imagining a table.
The table has dimensions: d x n.
'd' is the length of the largest number.
'n' is the number of elements in the list to sort.

Now imagine sorting each column indvidually, starting from the digits of the lowest power.
The stable sort algorithm is important here as you are sorting d times.
You want to ensure that the numbers are being kept stable. It would be like matching 
a head to a wrong body. Frankenstein numbers.

You increase the exponential, which is basically moving along one column to the left, and repeat 
the process.

Once the exponential is greater than the largest digit length, then the elements are sorted.
'''

# (MSD = Most significant digit first, starting column from left first)
# Variations:
'''
	- Binary MSD radix sort (aka binary quicksort) is an inplace variations.
	- MSD Radix sort can be implemented as stable, requiring use of an array with length of input array.
	- Radix Sort with insertion sort (instead of counting sort), much faster on smaller arrays.
'''

from algorithms.CountSort import count_sort_exp

def radix_sort(arr : list) -> list:
	exp = 1
	max_num = max(arr)
	while max_num // exp > 0:
		count_sort_exp(arr, exp)
		exp *= 10
	return arr