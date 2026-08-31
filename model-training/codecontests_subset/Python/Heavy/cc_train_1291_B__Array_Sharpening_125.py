from math import *

t=int(input())

while t>0:
	n=int(input())
	a=[]
	a=[int(x) for x in input().split()]

	if n==1:
		print("Yes")
	elif n==2:
		if a[0]==a[1] and a[0]==0:
			print("No")
		else:
			print("Yes")
	elif n==3:
		if a[1]==0:
			print("No")
		else:
			print("Yes")
	elif n==4:
		if a[1]==0 or a[2]==0:
			print("No")
		elif a[1]==a[2] and a[1]==1:
			print("No")
		else:
			print("Yes")
	elif n%2==0:
		flag=0
		for i in range((n-1)//2+1):
			if a[i]<i or a[-(i+1)]<i:
				print("No")
				flag=1
				break
		if flag==0:
			if a[(n-1)//2]==a[n//2] and a[n//2]==(n-1)//2:
				print("No")
			elif a[1]==0 or a[-2]==0:
				print("No")
			else:
				print("Yes")
	else:
		flag=0
		for i in range((n-1)//2+1):
			if a[i]<i or a[-(i+1)]<i:
				print("No")
				flag=1
				break
		if flag==0:
			if a[1]==0 or a[-2]==0:
				print("No")
			else:
				print("Yes")


	t-=1