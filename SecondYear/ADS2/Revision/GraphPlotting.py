import timeit, random
import matplotlib.pyplot as plt

def create_arr_of_arrays(max_size: int, max_number : int):
	sumArray = []
	for i in range(max_size):
		this_turn_max = random.randint(1, max_number)
		innerArray = [random.randint(0, this_turn_max) for x in range(i+1)]
		sumArray.append(innerArray)
	return sumArray

def test(arr : list) -> bool:
	for i in range(len(arr)-1):
		if arr[i+1] < arr[i]:
			print(f"Failed test:\n{arr}")
			return False
	return True

def plot_graph(arrOfArrays : list, sort_func):
	times = []
	sizes = []
	for array in arrOfArrays:
		sizes.append(len(array))
		copiedArray = array.copy()
		time_start = timeit.default_timer()
		sort_func(copiedArray)
		time_end = timeit.default_timer()
		if not test(copiedArray):
			print(f"Sorting failed on {sort_func.__name__}")
			return False
		times.append(time_end - time_start)
	plt.plot(sizes, times, label=sort_func.__name__)
