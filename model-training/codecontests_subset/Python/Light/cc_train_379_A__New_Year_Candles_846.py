import sys 
from collections import Counter 
n,m=map(int,input().split())
k=n
c=0
while n>=m:
	c+=n//m
	n=n//m+(n%m)
print(c+k)	