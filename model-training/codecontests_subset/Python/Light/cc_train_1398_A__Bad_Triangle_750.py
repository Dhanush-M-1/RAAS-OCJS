n = int(input())
a = []
b = []
for i in range(n):
	s = input()
	a.append(list(map(int, input().split())))
	a[-1].sort()
	if a[-1][0] + a[-1][1] > a[-1][-1]:
		print(-1)
	else:
		print(1, 2, len(a[i]))