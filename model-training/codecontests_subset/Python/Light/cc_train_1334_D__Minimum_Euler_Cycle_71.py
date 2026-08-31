for nt in range(int(input())):
	w,a,b=map(int,input().split())
	if w==2:
		l=[1,2,1]
		print (*l[a-1:b])
		continue
	k=w
	prev=0
	for j in range(a,b+1):
		i=j-prev
		while k>1:
			if i<=2*(k-1):
				if i%2:
					print (w-k+1,end=" ")
				else:
					print (i//2+(w-k+1),end=" ")
				break
			else:
				i-=2*(k-1)
				prev+=2*(k-1)
				k-=1
		if k==1:
			print (1,end=" ")
	print ()
    	  	  				 	 						 	   		