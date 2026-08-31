f = lambda: map(int, input().split())
for _ in range(int(input())):
	n = input()
	a = list(f())
	print(-1 if a[0]+a[1]>a[-1] else '1 2 '+str(n))