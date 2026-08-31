import math
t = int(input())
for i in range(t):
	n = int(input())
	a = list(map(int,input().split()))
	# if(n==1):
	# 	print("Yes")
	# elif n==2:
	# 	if(a[0]==a[1]):
	# 		print("No")
	# 	else:
	# 		print("Yes")
	# else:
		#flag1=0
		#flag2=0
	p=[0]*n
	s=[0]*n
	# print(s[0])
	# print(len(s))
	#s=[]
	for j in range(n):
		if(j<=a[j]):	
			p[j]=1
		else:
			#flag1=1
			break
	for j in range(n):
		if(j<=a[n-j-1]):
			s[j]=1
		else:
			#flag2=1
			break
	# if flag1==0 or flag2==0:
	# 	print("Yes")
	# else:
	# print(p)
	# print(s)
	flag=0
	for j in range(n):
		if(p[j]==s[n-j-1] and p[j]==1):
			# print("hi %d"%(p[j]))
			# print("hello %d"%(s[n-j-1]))
			print("Yes")
			flag=1
			break
	if(flag==0):
		print("No")







