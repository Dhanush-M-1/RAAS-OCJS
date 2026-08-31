# Binary search, not actual bs lol
def bs(a):
	if len(a) <= 1: return [0]

	mid = a.index(max(a))
	dp = [-1 for _ in a]
	# dp for depths, not dynamic programming lol
	dp[  :mid]  = bs(a[:mid])    # Length mid
	dp[   mid]  = -1             # Length 1
	dp[mid+1:]  = bs(a[mid+1:])  # Length len(a) - mid - 1
	dp = [n + 1 for n in dp]
	# print(a, ':', dp)
	return dp[:len(a)]



T = int(input())
for _ in range(T):
	N = int(input())
	p = list(map(int, input().split()))
	print(*bs(p))

# arr = [0, 1, 5, 3, 4, 2]
# mid = arr.index(max(arr))
# arr = arr[:mid][::-1] + [arr[mid] ** 3] + arr[mid + 1:][::-1]
# print(arr)