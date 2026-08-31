from math import *
import sys
from sys import stdin
from sys import stdout
# input = stdin.readline
for __ in range(int(input())):
	n=int(input())
	ar=[]
	for i in range(n):
		ar.append(input())
	a=ar[0][1]
	b=ar[1][0]

	x=ar[n-1][n-2]
	y=ar[n-2][n-1]
	if(a==b and x==y and a!=x):
		print(0)
	elif(a==b==x==y):
		print(2)
		print(1,2)
		print(2,1)
	else:
		if(a!=b and x!=y):
			print(2)
			if(a==x):
				print(1,2)
				print(n-1,n)
			else:
				print(1,2)
				print(n,n-1)
		elif(a!=b and x==y):
			print(1)
			if(a==x):
				print(1,2)
			else:
				print(2,1)
		elif(a==b and x!=y):
			print(1)
			if(a==x):
				print(n,n-1)
			else:
				print(n-1,n)
