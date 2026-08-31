t = int(input())

for _ in range(t):
	n = int(input())
	a = list(map(int,input().split(' ')))
	i,j,k = 0,1,2
	
	while i < n-2:
		while j < n-1 :
			while k < n:
				if a[i] + a[j] <= a[k]:
					print(i+1,j+1,k+1)
					i,j,k = n,n,n
					break	
				else:
					k += 1
			j += 1
		i += 1
		
	if i == n-2 and j == n - 1 and k == n:
		print(-1)
