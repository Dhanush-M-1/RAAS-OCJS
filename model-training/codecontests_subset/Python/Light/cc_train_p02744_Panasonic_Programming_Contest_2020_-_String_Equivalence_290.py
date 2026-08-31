def dfs(a='', b=chr(ord('a'))):
	if len(a) == N:
		print(a)
	else:
		i = chr(ord('a'))
		while i < b:
			dfs(a + i, b)
			i = chr(ord(i) + 1)
		dfs(a + b, chr(ord(b) + 1))

N = int(input())
dfs()