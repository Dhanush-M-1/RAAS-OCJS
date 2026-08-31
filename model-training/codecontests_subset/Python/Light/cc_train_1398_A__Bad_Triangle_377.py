for _ in range(int(input())):
	n = int(input())
	a = list(map(int, input().split()))
	if a[n-1]<a[1]+a[0]:
		print('-1')
	else:		
		for i in range(2, n):
			if a[i]>=a[0]+a[1]:
				print('1 2 '+str(i+1))
				break