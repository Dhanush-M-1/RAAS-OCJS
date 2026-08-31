for _ in range(int(input())):
	n=int(input())
	l=[]
	for i in range(n):
		s=str(input())
		l.append(s)
	a=int(l[0][1])
	b=int(l[1][0])
	c=int(l[n-1][n-2])
	d=int(l[n-2][n-1])
	if(a==0 and b==0):
		if(c==1 and d==1):
			print(0)
		elif(c==1 and d==0):
			print(1)
			print(n-1,n)
		elif(c==0 and d==1):
			print(1)
			print(n,n-1)
		elif(c==0 and d==0):
			print(2)
			print(1,2)
			print(2,1)
	elif(a==1 and b==0):
		if(c==1 and d==1):
			print(1)
			print(1,2)
		elif(c==1 and d==0):
			print(2)
			print(1,2)
			print(n-1,n)
		elif(c==0 and d==1):
			print(2)
			print(1,2)
			print(n,n-1)
		elif(c==0 and d==0):
			print(1)
			print(2,1)
	elif(a==0 and b==1):
		if(c==0 and d==0):
			print(1)
			print(1,2)
		elif(c==1 and d==0):
			print(2)
			print(1,2)
			print(n,n-1)
		elif(c==0 and d==1):
			print(2)
			print(1,2)
			print(n-1,n)
		elif(c==1 and d==1):
			print(1)
			print(2,1)
	elif(a==1 and b==1):
		if(c==0 and d==0):
			print(0)
		elif(c==1 and d==0):
			print(1)
			print(n,n-1)
		elif(c==0 and d==1):
			print(1)
			print(n-1,n)
		elif(c==1 and d==1):
			print(2)
			print(n,n-1)
			print(n-1,n)

			
