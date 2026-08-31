import sys

t = int(input())
for T in range(t):
	empty = input()
	k,n,m = map(int,input().split())
	a = list(map(int,input().split()))
	b = list(map(int,input().split()))
	c = []
	i = 0
	j = 0
	while i<n or j<m:
		if i==n:
			if b[j]==0:
				k+=1
				c.append(b[j])
				j+=1
			elif b[j]<=k:
				
				c.append(b[j])
				j+=1
			else:
				c = -1
				break
		elif j==m:
			if a[i]==0:
				k+=1
				
				c.append(a[i])
				i+=1
			elif a[i]<=k:
				
				c.append(a[i])
				i+=1
			else:
				c=-1
				break
		else:
			if a[i]==0:
				k+=1
				
				c.append(a[i])
				i+=1
			elif b[j]==0:
				k+=1
				
				c.append(b[j])
				j+=1
			elif a[i]<=b[j]:
				if a[i]<=k:
					
					c.append(a[i])
					i+=1
				else:
					c=-1
					break
			elif b[j]<a[i]:
				if b[j]<=k:
					
					c.append(b[j])
					j+=1
				else:
					c=-1
					break
	if c==-1:
		print(c)
	else:
		print(*c)










				



