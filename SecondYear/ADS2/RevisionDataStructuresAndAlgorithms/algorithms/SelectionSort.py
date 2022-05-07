# Selection sort

# Best case: O(n^2)
# Worst case: O(n^2)
# Average case: O(n^2)
# Stable: False
# In-place: True


# Explanation:

'''

Selection traverses the list and finds the smallest number.
Places smallest number at current index.
Index increases by one and repeat this process.

Imagine pairing socks:
You pick up one sock, search all the pile for the other sock.
Put these socks in a separate pile, they can be ignored.
Repeat the process until the socks are in the paired pile.

'''

def selection_sort(arr : list) -> list:
	n = len(arr)
	for i in range(n-1):
		min_index = i 
		for j in range(min_index+1, n):
			if (arr[j] < arr[min_index]):
				min_index = j

		arr[min_index], arr[i] = arr[i], arr[min_index]
	return arr
