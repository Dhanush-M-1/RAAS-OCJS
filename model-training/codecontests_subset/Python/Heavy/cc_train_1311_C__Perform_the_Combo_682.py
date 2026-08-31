t = int(input())
for i in range(t):

	dic = dict()
	for j in range(ord("a"), ord("z")+1):
		dic[j] = 0

	n, m = map(int, input().split())
	s = input()
	dp = [[0 for m in range(n)] for p in range(ord("a"), ord("z")+1)]
	dp[ord(s[0]) - ord("a")][0] = 1
	for j in range(1, n):
		dp[ord(s[j]) - ord("a")][j] = dp[ord(s[j]) - ord("a")][j-1] + 1 
		for k in range(ord("a"), ord("z")+1):
			if k != ord(s[j]):
				dp[k - ord("a")][j] = dp[k - ord("a")][j-1]


	for k in s:
		dic[ord(k)] += 1

	p = list(map(int, input().split(" ")))
	for k in p:
		for m in range(ord("a"), ord("z")+1):
			dic[m] += dp[m-ord("a")][k-1]

	for i in range(ord("a"), ord("z")+1):
		print(dic[i], end=" ")