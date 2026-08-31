def dfs(a='', b='a'):
	if len(a) == N:
		print(a)
	else:
		i = 'a'
		while i < b:
			dfs(a + i, b)
			i = chr(ord(i) + 1)
		dfs(a + b, chr(ord(b) + 1))

N = int(input())
dfs()