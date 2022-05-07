'''
Basic knapsack example

Bag can contain max W weight.
Given a set of weights, with certain values.
What is the maximum value achieved with the bag?

This solution is uses a recursion tree however contains overlap.
Overlap is bad.

This solution is O(2^)

'''

def knapsack_recv(weight : int, weight_list : list, values : list, n : int): 
	if (n < 0 or weight == 0):
		return 0
	if (weight_list[n] > weight):
		return knapsack_recv(weight, weight_list, values, n-1)
	else:
		a = values[n] + knapsack_recv(weight-weight_list[n], weight_list, values, n-1)
		b = knapsack_recv(weight, weight_list, values, n-1)
		return max(a,b)

if __name__ == '__main__':
	weight = 2
	weight_list = [1,1,1]
	values = [5,8,7]
	n = 2
	answer = knapsack_recv(weight, weight_list, values, n)
	print(answer)