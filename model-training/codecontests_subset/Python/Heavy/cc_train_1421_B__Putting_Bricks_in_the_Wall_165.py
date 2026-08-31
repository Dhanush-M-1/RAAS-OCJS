import sys
import math
from collections import defaultdict,Counter

input=sys.stdin.readline
# def print(x):
#     sys.stdout.write(str(x)+"\n")

# sys.stdout=open("CP2/output.txt",'w')
# sys.stdin=open("CP2/input.txt",'r')

# mod=pow(10,9)+7
t=int(input())
for i in range(t):
	n=int(input())
	for j in range(n):
		s=input().strip()
		if j==0:
			flag=int(s[1])
		elif j==n-1:
			flag3=int(s[-2])
		else:
			if j==1:
				flag1=int(s[0])
			if j==n-2:
				flag2=int(s[-1])
	l=[]
	if flag==flag1:
		if flag==0:
			if flag2==0:
				l.append([n-1,n])
			if flag3==0:
				l.append([n,n-1])
		else:
			if flag2==1:
				l.append([n-1,n])
			if flag3==1:
				l.append([n,n-1])
	elif flag2==flag3:
		if flag2==0:
			if flag==0:
				l.append([1,2])
			if flag1==0:
				l.append([2,1])
		else:
			if flag==1:
				l.append([1,2])
			if flag1==1:
				l.append([2,1])
	else:
		if flag==0:
			l.append([2,1])
		else:
			l.append([1,2])
		if flag2==0:
			l.append([n-1,n])
		else:
			l.append([n,n-1])

	print(len(l))
	for j in l:
		print(*j)