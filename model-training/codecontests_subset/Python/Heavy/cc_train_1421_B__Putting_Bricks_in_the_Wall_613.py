import sys
import itertools
import math
input = sys.stdin.readline
I = lambda : list(map(str,input().split()))

n,=I()
n=int(n)
while(n):
	n-=1
	k,=I()
	k=int(k)
	arr=[]
	for i in range(k):
		g,=I()
		arr.append(g)

	a,b,x,y=int(arr[0][1]),int(arr[1][0]),int(arr[k-1][k-2]),int(arr[k-2][k-1])

	if a==b and x==y and a==x:
		print(2)
		print(1,2)
		print(2,1)
	elif a==b and x==y and a!=x:
		print(0)
	elif a==b:
		if x==a:
			print(1)
			print(k,k-1)
		elif y==a:
			print(1)
			print(k-1,k)
	elif x==y:
		if a==x:
			print(1)
			print(1,2)
		else:
			print(1)
			print(2,1)
	else:
		print(2)
		if a==1:
			print(1,2)
		elif b==1:
			print(2,1)
		if x==0:
			print(k,k-1)
		elif y==0:
			print(k-1,k)





	
