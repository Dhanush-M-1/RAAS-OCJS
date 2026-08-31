for nt in range(int(input())):
	n,a,b=map(int,input().split())
	if n==2:
		l=[1,2,1]
		print (*l[a-1:b])
		continue
	k=n
	prev=0
	for j in range(a,b+1):
		i=j-prev
		while k>1:
			if i<=2*(k-1):
				if i%2:
					print (n-k+1,end=" ")
				else:
					print (i//2+(n-k+1),end=" ")
				break
			else:
				i-=2*(k-1)
				prev+=2*(k-1)
				k-=1
		if k==1:
			print (1,end=" ")
	print ()