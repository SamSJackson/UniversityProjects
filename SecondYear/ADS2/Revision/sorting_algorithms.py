import random
import matplotlib.pyplot as plt
import argparse
# All algorithms
from GraphPlotting import plot_graph, create_arr_of_arrays
from algorithms.MergeSort import merge_sort
from algorithms.InsertionSort import insertion_sort
from algorithms.SelectionSort import selection_sort
from algorithms.QuickSort import quick_sort
from algorithms.CountSort import count_sort
from algorithms.RadixSort import radix_sort

''' Argument Parser content IGNORE '''

parser = argparse.ArgumentParser(description="Graph sorting algorithms")
parser.add_argument('-k', metavar='k', type=int, nargs='+',
					help='Max number in the array (default: 500)', default=[500])
parser.add_argument('-n', metavar='n', type=int, nargs='+',
					help='Max length of arrays (default: 500)', default=[500])
args = parser.parse_args()

max_number = args.k[0]
max_size = args.n[0]

'''
Standard:
	- Insertion sort
	- Selection sort
Divide and conquer:
	- Merge sort
	- Quicksort
Non-comparison sorts:
	- Counting sort
	- Radix sort
'''

def create_graph(max_size : int, max_number : int, list_sort_func):
	arrays = create_arr_of_arrays(max_size, max_number)
	for function in list_sort_func:
		plot_graph(arrays, function)
	plt.legend(loc="upper right")

def make_list(size : int) -> list:
	return [random.randint(0,size) for x in range(size)]

def run_test(arr : list, sort_func) -> bool:
	sorted_arr = sort_func(arr)
	for i in range(len(sorted_arr)-1):
		if sorted_arr[i+1] < sorted_arr[i]:
			print(f"Failed test:\n{arr}")
			return False
	print(f"Passed test:\n{arr}")
	return True

if __name__ == '__main__':
	all_funcs = [quick_sort, selection_sort, insertion_sort, merge_sort,
					count_sort, radix_sort]
	create_graph(max_size=max_size, max_number=max_number, list_sort_func=all_funcs)
	plt.show()

	# random_list = make_list(100)
	# run_test(random_list, radix_sort)

