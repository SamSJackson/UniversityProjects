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

NEED TO DO THIS EXPLANATION
'''

from algorithms.CountSort import count_sort_exp

def radix_sort(arr : list):
	exp = 1
	max_num = max(arr)
	while max_num // exp > 0:
		count_sort_exp(arr, exp)
		exp *= 10
	return arr