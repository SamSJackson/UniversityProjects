# Merge Sort

# Best case: O(nlog(n))
# Worst case: O(nlog(n))
# Average case: O(nlog(n))
# Stable: True
# In-place: False


# Explanation:

'''
Divide and Conquer Algorithm (problem is recursively split into subproblems)

Merge Sort functions such that it divides the array into 2.
This happens recursively so it continues until arrays is of size 1.
When arrays of size 1, combine and return to the previous recursive call.

This is recursive so the final recursive call will be the initial array, sorted
and split into two.

These two arrays are combined, and array is sorted.

Imagine it as a company:
The work is reviewed and delegated to the lower levels until at the lowest level.
The lowest level completes the work and passes it up.
The higher levels combine and pass it up. 
This is completed until it reaches the top, all completed.

(It is just divide and conquer, split the sort 
into many subproblems and compare).
'''

# Variations:

'''
- Insertion sort on small subarrays (instead of going to one-element arrays)
- 3-Way merge sort (split array into three instead of two)
- In-place merge sort (O(1) constant space as opposed O(n))
- Bottom-Up merge sort (iterative)
'''

def merge_sort(arr : list) -> list:
	if len(arr) > 1:
		mid = len(arr) // 2
		left = arr[:mid]
		right = arr[mid:]

		merge_sort(left)
		merge_sort(right)

		i=j=k=0

		while (i < len(left) and j < len(right)):
			if (left[i] < right[j]):
				arr[k] = left[i]
				i += 1
			else:
				arr[k] = right[j]
				j += 1
			k += 1

		while (i < len(left)):
			arr[k] = left[i]
			i += 1
			k += 1
		while (j < len(right)):
			arr[k] = right[j]
			j += 1
			k += 1
	return arr

