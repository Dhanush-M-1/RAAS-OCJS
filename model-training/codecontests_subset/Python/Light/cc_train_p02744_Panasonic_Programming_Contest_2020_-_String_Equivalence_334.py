import sys

N = int(sys.stdin.readline().strip())

def dfs(s, n):
	if len(s) == N:
		print(s)
	else:
		for i in range(n+1):
			dfs(s + chr(97+i), n+1 if i == n else n)

dfs("", 0)