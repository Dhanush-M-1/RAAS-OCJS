from math import ceil

def check_root(n, d):
	"""check if discriminant is non-negative"""
	return (n*n + 2*n + 1 >= 4*d)
	
def mod_expo(n, p, m):
	"""find (n^p)%m"""
	result = 1
	while p != 0:
		if p%2 == 1:
			result = (result * n)%m
		p //= 2
		n = (n * n)%m
	return result
	
def find_product(n, m, arr):
	"""find |arr i - arr j| mod m"""
	product=1
	if n <= m:
		for i in range(n):
			for j in range(i+1, n):
				 product = (product * abs(arr[i] - arr[j]))%m
		return product
	return 0

def find_subarrays(n, k, word):
	"""find subarrays with sum k"""
	curr_sum = 0
	count = 0
	mp = {}
	for i in range(n):
		curr_sum += int(word[i])
		if curr_sum not in mp:
			mp[curr_sum] = 0
		mp[curr_sum] += 1
		if curr_sum == k:
			count += 1
		elif (curr_sum - k) in mp:
			count += mp[(curr_sum - k)]
	return count
	
def find_total_games(n, a):
	"""find mminmum games need tot satisfy"""
	return max(ceil(sum(a)/(n-1)), max(a))
	
t = 1
# t = int(input())
while t:
	t = t - 1
	n = int(input())
	# a, b, m = map(int, input().split())
	a = list(map(int, input().strip().split()))[:n]
	print(find_total_games(n, a))
