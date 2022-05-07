'''
3 Primary Principles:
	1. Structure 
		- Characterise structure of optimal solution.
	2. Principle of optimality
		- Recursively define the value of an optimal solution
	3. Bottom-up computation
		- Compute the value of optimal solution using a table
Extra (occasionally required principle):
	4. Construction of optimal solution
		- Use computed information to construct solution


## Structure

Construct a table (V[0,...,n][0,...,W])
For 1 <= i <= n and 0 <= j <= W, 
V[i][j] contains maximum total value of any subset of items {1,...,i} of combined weight at most j.

V[n][W] contains maximum weight of items that can fit into bag with capacity W


## Principle of optimality

Similar idea to recursive definition from naive_knapsack.py (recursion tree/divide and conquer)

Base: V[0][j] = 0, 0 <= j <= W
	  V[i][j] = -inf with j < 0

Recursive step: V[i][j] = max(V[i-1][j], v[i] + V[i-1][j-w[i]]), 1 <= i <= n and 0 <= j <= W


## Bottom-up Computation

Use iteration instead of recursion to complete V table row by row.


'''

def knapsack_memo(weight : int, weight_list : list, values : list, n : int) -> int:
	V = [[0 for x in range(weight+1)] for x in range(n+1)]
	for j in range(weight):
		V[0][j] = 0
	for i in range(0,n):
		for j in range(weight+1):
			if weight_list[i] <= j:
				V[i+1][j] = max(V[i][j], values[i] + V[i][j-weight_list[i]])
			else:
				V[i+1][j] = V[i][j]
	for row in V:
		print(row)
	return V[n][weight]


if __name__ == '__main__':
	weight = 7
	weight_list = [2,3,4,1]
	values = [5,2,1,4]
	n = 4
	answer = knapsack_memo(weight, weight_list, values, n)
	print(answer)