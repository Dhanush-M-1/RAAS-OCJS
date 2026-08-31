for i in range(int(input())):
	n = int(input())
	a = [int(i) for i in input().split()][:n]
	s = a[0] + a[1]
	if s > a[-1]:
		print(-1)
	else:
		print(1,2,n)