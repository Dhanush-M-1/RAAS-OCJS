from sys import stdin ,stdout
from os import path
rd = lambda:stdin.readline().strip()
wr = stdout.write
if(path.exists('input.txt')):
    stdin = open("input.txt","r")
import time ,math
#why sorting suffix array although we go through the whole array any way till we find the pattern
#------------------------------------=
from collections import defaultdict
x = int(rd())
mylist =list(map(int,rd().split()))
def gcd(x,y):
	if x == 0 :
		return y 
	return gcd(y%x,x)
if len(mylist) == 2:
	if mylist[0] == mylist[1]:
		y =  0 
		z = 0
	else:
		y = 1 
		z = abs(mylist[0] - mylist[1])
else:
	mx = max(mylist)
	mn = mx-mylist[0]
	sm  =0
	for i in range(len(mylist)):
		sm+=(mx-mylist[i])
		if mx == mylist[i] :
			continue
		else:
			mn = gcd(mx-mylist[i],mn)
	z = mn
	y = sm // mn 
print(y,z)

