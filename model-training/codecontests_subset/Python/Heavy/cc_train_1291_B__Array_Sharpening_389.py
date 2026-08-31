
t=int(input())
for i in range(t):
	n=int(input())
	a=list(map(int,input().split()))
	check=[]
	for i in range(len(a)):
		if a[i]>=i:
			check.append(True)
		else:
			check.append(False)
	check2=[]
	for i in range(len(a)):
		if a[i]>=n-i-1:
			check2.append(True)
		else:
			check2.append(False)

	i=-1

	for j in range(n):
		if check[j]!=True:
			i=j
			break
	x=0
	if(i==-1):
		print("Yes")
	elif(i==0):
		ll=0
		for k in check2:
			if k==False:
				ll=1
		if(ll==1) :
			print("No")
		else:
			print("Yes")
	else:
		for k in range(i-1,n):
			if(check2[k]==False):
				x=1
				break
		
		# print(check,check2)
		if(x==1):
			print("No")
		else:
			print("Yes")


