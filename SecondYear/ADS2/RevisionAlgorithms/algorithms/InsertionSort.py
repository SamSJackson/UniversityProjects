# Insertion sort

# Best case: O(n^2)
# Worst case: O(n^2)
# Average case: O(n^2)
# Stable: True
# In-place: True

# Explanation:
'''
Insertion traverses the list normally
At each index increase, insertion checks all previous
elements to decide where to place the element

Imagine it as walking kids to school, in alphabetical order.
You pick up a kid with the initials S.J.
Checking the kid closest to you if his initial is before J or after.
If after, check the next person and repeat.
Else, place the new kid where you are for now and repeat.
At the end of this, you have moved all people after J closer to you (or up 1).

'''

def insertion_sort(arr : list):
	n = len(arr)
	for i in range(1, n):
		key = arr[i]
		j = i-1
		while (j >= 0 and arr[j] > key):
			arr[j+1] = arr[j]
			j = j-1
		arr[j+1] = key
	return arr

