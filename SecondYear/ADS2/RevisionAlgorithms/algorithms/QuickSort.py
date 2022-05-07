# Quicksort Sort

# Best case: O(nlog(n))
# Worst case: O(n^2)
# Average case: O(nlog(n))
# Stable: False
# In-place: True

# Explanation: 
'''
Quicksort is a recursive algorithm, with parameters low and high.
Low is the lower index, high is the upper index.
The important technique is partitioning.
Partitioning is picking an element (traditionally the rightmost element, high parameter).
Then you sort the array such that all elements less than the chosen element on the left.
All elements greater than or equal to on the right.
Then returning the partitioned index, quicksort runs recursively, using the low 
and high parameters to ignore the element used for partitioning (since in right place).

Although this can go badly if the rightmost element is always the largest/smallest.
This will create a lopsided partition.

Imagine:
You choose the pivot point.
You hammer the pivot point in place.
All elements less than the pivot go on the left, all elements greater go on right.
You continue this until you realise all elements have been nailed in place.
They are all in the right place. 
'''


# Variations:
'''
- 3-Way Partitioning quicksort 
	- This is a good method, especially if you have duplicates.
	The duplicates group at the center (as the partition)
	Which reduces the size of the left and right partitions.

'''
import random


def partition(arr : list, low : int, high : int) -> int:
	i = low - 1
	pivot = (low + high+1) / 2

	for j in range(low, high):
		if arr[j] < pivot:
			i += 1
			arr[i], arr[j] = arr[j], arr[i]
	arr[i+1], arr[high] = arr[high], arr[i+1]

	return (i+1)

def quick_sort(arr : list, low : int=None , high : int=None) -> list:
	low = 0 if low == None else low
	high = len(arr)-1 if high == None else high
	if (low < high):
		part = partition(arr, low, high)
		print(f"{arr[:part]=}, {arr[part:]=}")
		quick_sort(arr, low, part-1)
		quick_sort(arr, part+1, high)
	return arr
 
if __name__ == '__main__':
	array = [1,3,5,7,8,6,4,2]
	quick_sort(array)