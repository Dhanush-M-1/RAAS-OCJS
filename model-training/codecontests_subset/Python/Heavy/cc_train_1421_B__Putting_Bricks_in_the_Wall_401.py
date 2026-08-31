for _ in range(int(input())):
	n=int(input())
	l=[]
	for i in range(n):
		t=list(input())
		l.append(t)
	if l[0][1]=='0' and l[1][0]=='0':
		c=0
		out=[]
		if l[n-1][n-2]=='0':
			c+=1
			out.append((n,n-1))
		if l[n-2][n-1]=='0':
			c+=1
			out.append((n-1,n))
		print(c)
		for i in out:
			print(i[0],i[1])
	elif l[0][1]=='1' and l[1][0]=='1':
		c=0
		out=[]
		if l[n-1][n-2]=='1':
			c+=1
			out.append((n,n-1))
		if l[n-2][n-1]=='1':
			c+=1
			out.append((n-1,n))
		print(c)
		for i in out:
			print(i[0],i[1])
	else:
		if l[0][1]=='0':
			if l[n-1][n-2]=='0' and l[n-2][n-1]=='0':
				print(1)
				print(1,2)
			elif l[n-1][n-2]=='1' and l[n-2][n-1]=='1':
				print(1)
				print(2,1)
			else:
				print(2)
				print(2,1)
				if l[n-1][n-2]=='0':
					print(n,n-1)
				elif l[n-2][n-1]=='0':
					print(n-1,n)
		elif l[1][0]=='0':
			if l[n-1][n-2]=='0' and l[n-2][n-1]=='0':
				print(1)
				print(2,1)
			elif l[n-1][n-2]=='1' and l[n-2][n-1]=='1':
				print(1)
				print(1,2)
			else:
				print(2)
				print(1,2)
				if l[n-1][n-2]=='0':
					print(n,n-1)
				elif l[n-2][n-1]=='0':
					print(n-1,n)