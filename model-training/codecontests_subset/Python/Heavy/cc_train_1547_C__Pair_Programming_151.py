for _ in range(int(input())):
	s = input()
	
	k, n, m = map(int,input().split())
	
	a = list(map(int,input().split()))
	b = list(map(int,input().split()))
	
	i = 0
	j = 0
	f = 0
	ans=[]
	
	while i<n or j<m:
		if i==n:
			if b[j]>k:
				print(-1)
				f=1
				break
				
			if b[j] == 0:
				k+=1
			ans.append(b[j])
			j+=1
		
		elif j == m:
			if a[i]>k:
				print(-1)
				f=1
				break
			if a[i] == 0:
				k+=1
			ans.append(a[i])
			i+=1
			
		elif a[i] == 0:
			ans.append(a[i])
			i+=1
			k+=1
		elif b[j] == 0:
			ans.append(b[j])
			j+=1
			k+=1
			
		elif a[i]<=k:
			ans.append(a[i])
			i+=1
			
		elif b[j]<=k:
			ans.append(b[j])
			j+=1
			
		else:
			print(-1)
			f=1
			break
		
	if f:
		continue
	print(*ans)
