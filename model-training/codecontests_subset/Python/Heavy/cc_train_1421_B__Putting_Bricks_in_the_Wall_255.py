t=int(input())
i=1
while(i<=t):
	n = int(input())
	mat = []
	for j in range(n):
		mat.append(list(input()))
	# print(mat)
	# print(mat[0])
	x1 = int(mat[0][1])
	x2 = int(mat[1][0])
	x3 = int(mat[n-1][n-2])
	x4 = int(mat[n-2][n-1])
	s1 = x1+x2
	s2 = x3+x4
	if(s1==0 and s2==1):
		print(1)
		if(x3==0):
			print(n,n-1)
		if(x4==0):
			print(n-1,n)
	elif(s1==1 and s2==1):
		print(2)
		if(x1==1):
			print(1,2)
		if(x2==1):
			print(2,1)
		if(x3==0):
			print(n,n-1)
		if(x4==0):
			print(n-1,n)
	elif(s1==2 and s2==1):
		print(1)
		if(x3==1):
			print(n,n-1)
		if(x4==1):
			print(n-1,n)
	elif(s1==1 and s2==0):
		print(1)
		if(x1==0):
			print(1,2)
		if(x2==0):
			print(2,1)
	elif(s1==0 and s2==0):
		print(2)
		print(1,2)
		print(2,1)
	elif(s1==2 and s2==2):
		print(2)
		print(1,2)
		print(2,1)
	elif(s1==1 and s2==2):
		print(1)
		if(x1==1):
			print(1,2)
		if(x2==1):
			print(2,1)
	else:
		print(0)
	i+=1