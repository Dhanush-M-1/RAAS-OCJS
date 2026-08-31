from sys import stdin
input = stdin.buffer.readline
for _ in range(int(input())):
	n, l, r = map(int, input().split())
	l -= 1
	r -= 1
	flag, tmp, s = 1, 0, 0
	ans = []
	x, y = n, n - 1
	for i in range(1, n):
		s += 2 * (n - i)
		if l < s and flag:
			x, tmp = i, (i > 1) * (s - 2 * (n - i))
			l -= tmp
			flag = 0
		if r < s:
			y = i
			r -= tmp
			break
	if x > y:
		l, r = 0, 0
	for i in range(x, y + 1):
		for j in range(i + 1, n + 1):
			ans.append(i)
			ans.append(j)
	#if r >= len(ans) and y != n - 1:
	#	print(0/0)
	ans.append(1)
	print(*ans[l : r + 1])