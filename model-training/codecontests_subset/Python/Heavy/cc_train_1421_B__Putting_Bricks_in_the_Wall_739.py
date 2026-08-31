for i in range(int(input())):
	l=[list(input()) for j in range(int(input()))]
	n=len(l)
	if(l[0][1]=='0' and l[1][0]=='0'):
		if(l[n-2][n-1]=='0' and l[n-1][n-2]=='0'):
			print(2)
			print(n,n-1)
			print(n-1,n)
		elif l[n-2][n-1]=='0':
			print(1)
			print(n-1,n)
		elif l[n-1][n-2]=='0':
			print(1)
			print(n,n-1)
		else:
			print(0)
	elif(l[0][1]=='1' and l[1][0]=='1'):
		if(l[n-2][n-1]=='1' and l[n-1][n-2]=='1'):
			print(2)
			print(n,n-1)
			print(n-1,n)
		elif l[n-2][n-1]=='1':
			print(1)
			print(n-1,n)
		elif l[n-1][n-2]=='1':
			print(1)
			print(n,n-1)
		else:
			print(0)
	else:
		if(l[n-2][n-1]=='0' and l[n-1][n-2]=='0'):
			if(l[0][1]=='0'):
				print(1)
				print(1,2)
			else:
				print(1)
				print(2,1)
		elif(l[n-2][n-1]=='1' and l[n-1][n-2]=='1'):
			if(l[0][1]=='1'):
				print(1)
				print(1,2)
			else:
				print(1)
				print(2,1)
		elif(l[0][1]=='1'):
			if(l[n-2][n-1]=='0'):
				print(2)
				print(1,2)
				print(n-1,n)
			else:
				print(2)
				print(1,2)
				print(n,n-1)
		else:
			if(l[n-2][n-1]=='1'):
				print(2)
				print(1,2)
				print(n-1,n)
			else:
				print(2)
				print(1,2)
				print(n,n-1)