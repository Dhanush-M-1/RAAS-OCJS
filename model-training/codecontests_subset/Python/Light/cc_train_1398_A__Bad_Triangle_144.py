def func():
	n = int(input())
	a = list(map(int, input().split()))
	first = a[0]
	second = a[1]
	last = a[n-1]

	if(first + second <= last):
		return "1 2 " + str(n)
	else:
		return "-1"

t = int(input())
for _ in range(t):
	print(func())
