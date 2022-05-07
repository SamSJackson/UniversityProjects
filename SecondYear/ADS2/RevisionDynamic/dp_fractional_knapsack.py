'''

Fractional knapsack is super cool
Obtain ratio value of the lists (e.g weight/value ratio).
Sort according to ratio (non-descending order).
Then boom done.

'''

class Item:
	def __init__(self, weight : int, value : int):
		self.weight = weight;
		self.value = value;
		self.cost = self.value // self.weight

	def __lt__(self, other):
		return self.cost < other.cost

	def __str__(self):
		return f"({self.weight}, {self.value}, {self.cost:2f})"

def knapsack_fractional_cost(weight_capacity : int, weight_list : list, values : list) -> int:
	array = []
	for i in range(len(weight_list)):
		array.append(Item(weight_list[i], values[i]))
	array.sort(reverse=True)

	best_value = 0
	for item in array:
		currentWeight = int(item.weight)
		currentValue = int(item.value)
		if (weight_capacity - currentWeight) >= 0:
			weight_capacity -= currentWeight
			best_value += currentValue
		else:
			fraction = weight_capacity / currentWeight
			best_value += currentValue * fraction
			weight_capacity = int(weight_capacity - (currentWeight * fraction))
			break
	return best_value
	

if __name__ == '__main__':
	weight_capacity = 50
	weight_list = [10, 40, 20, 30]
	values = [60, 40, 100, 120]
	answer = knapsack_fractional_cost(weight_capacity, weight_list, values)
	print(answer)
