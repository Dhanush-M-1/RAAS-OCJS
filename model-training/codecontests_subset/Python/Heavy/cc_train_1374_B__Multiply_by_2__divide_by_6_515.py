from sys import stdin,stdout
from math import gcd,sqrt
from collections import deque
input=stdin.readline
R=lambda:map(int,input().split())
I=lambda:int(input())
S=lambda:input().rstrip('\n')
L=lambda:list(R())
P=lambda x:stdout.write(x)
hg=lambda x,y:((y+x-1)//x)*x
pw=lambda x:1 if x==1 else 1+pw(x//2)
chk=lambda x:chk(x//2) if not x%2 else True if x==1 else False
dgnl=lambda x:sqrt(2*x**2)
for _ in range(I()):
	n=I()
	cnt=0
	while n%3==0:
		if n&1:n*=2
		else:n//=6
		cnt+=1
	if n==1:print(cnt)
	else:print(-1)