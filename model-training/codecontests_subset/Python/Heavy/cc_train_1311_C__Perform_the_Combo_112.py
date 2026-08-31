t=int(input())
for _ in range(t):
	n,m2=map(int,input().split())
	a=list(input())
	m1=list(map(int,input().split()))
 
	dm = { m1[i]:0 for i in range(m2) }
	for i in range(m2):
		dm[m1[i]]+=1
 
	m=set(m1)
 
	d = { chr(i):0 for i in range(97,123) }
	d2 = { chr(i):0 for i in range(97,123) }
	# print(d)
 
	for i in range(n):
		# print(a[i],i,m)
		if i+1 not in m:
			d2[a[i]]+=1
			d[a[i]]+=1
			# print("+",d2['o'],a[i])
		else:
			# print(dm[i+1],i+1,a[i],d2['o'])
			d[a[i]]+=1
			for j in d:
				d2[j]+=dm[i+1]*d[j]
 
			d2[a[i]]+=1
 
 
		# print(d)
	for k in d2:
		print(d2[k],end=" ")
	print()
