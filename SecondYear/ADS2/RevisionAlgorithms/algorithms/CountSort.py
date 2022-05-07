# Counting Sort

# k is the range of the array (k = max_number - min_number)
# Best case: O(n + k)
# Worst case: O(n + k)
# Average case: O(n + k)
# Stable: True
# In-place: False


# Explanation (linked to Radix):
'''
There is a strong element of dictionary/key involved in this.
Smart algorithm, less intuitive. Four primary processes.

1. Create an array of size k (k = max_number - min_number + 1)
This is an array of the range, so we can count the number of each element.
This is known as the index array.

2. Count the number of each element in the array.
Place the count in the index array at the index of the value of the element
E.g index_arr[element] += 1 (array is array of zeros at first)

3. Rolling sum of all elements in the index array.
Traverse the index array, adding the current rolling sum to the element.
E.g: array = [1, 3, 7, 7, 3, 1, 2, 2, 7, 2, 2, 2]

index_arr = [0, 2, 5, 2, 0, 0, 3]
rolling sum -> index_arr = [0, 2, 7, 9, 9, 9, 12]

4. Create array of same size as initial array.
Use the index array to place the elements, decrement the element in 
the index array after each access.
Important to note that you place the elements with index starting at 1.
E.g. Using previous example:
array = [1, 3, 7, 7, 3, 1, 2, 2, 7, 2, 2, 2]
index_arr = [0, 2, 7, 9, 9, 9, 12] (which becomes [0, 0, 2, 6, 9, 9, 10] at the end)
sorted_arr = [1, 1, 2, 2, 2, 2, 2, 3, 3, 7, 7, 7]

If don't understand, try do it with pen and paper.

No good imagery, try to understand why in each step.
2. Counting each element (how many do we have?)
3. Increase all the elements in the index array with the 
respect to the range effectively.
4. Use index array like dictionary to place elements in the, new, sorted array.

'''

# Evolution (superior variant):
'''
Radix sort is the more preferred method because it is an evolution of
Counting sort.
Counting Sort suffers when the upper_bound (max number) is in the range of
n^2 (the square of the length of the array), or greater.

'''

def count_sort(arr : list) -> list:
	lower_bound, upper_bound = min(arr), max(arr)
	counter_array = [0]*(upper_bound-lower_bound+1)
	for item in arr:
		counter_array[item-lower_bound] += 1
	pos = 0
	for index, value in enumerate(counter_array):
		num = index + lower_bound
		for i in range(value):
			arr[pos] = num
			pos += 1
	return arr

def count_sort_exp(arr : list, exp : int=None, d : int=10) -> list:
	n = len(arr)
	sorted_arr = [0] * n 
	count = [0] * d

	for i in range(0, n):
		index = (arr[i] // exp) % d
		count[index] += 1

	for i in range(1, d):
		count[i] += count[i - 1]

	i = n - 1
	while (i >= 0):
		index = arr[i] // exp
		sorted_arr[count[index % d] - 1] = arr[i]
		count[index % d] -= 1
		i -= 1
	i = 0

	for i in range(0, len(arr)):
		arr[i] = sorted_arr[i]

	return arr
