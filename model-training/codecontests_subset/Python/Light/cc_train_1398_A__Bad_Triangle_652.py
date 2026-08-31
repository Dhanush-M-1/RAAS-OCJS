t=int(input())
for _ in range(t):
	n=int(input())
	a=list(map(int,input().split()))
	for i in range(n):
		for j in range(i+1,n):
			if a[i] + a[j] <= a[-1]:
				print(i+1,j+1,n)
				break
			else:
				print('-1')
				break
		break