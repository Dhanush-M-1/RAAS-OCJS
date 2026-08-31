# import sys
# sys.stdin = open("test.in","r")
# sys.stdout = open("test.out.py","w")
from math import ceil as c
n,x,y=map(int,input().split())
a=c((n*y)/100)
if x>=a:
	print('0')
else:
	print(a-x)	