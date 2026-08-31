from sys import stdin,stdout
from math import gcd,sqrt,factorial
from collections import deque,defaultdict
input=stdin.readline
R=lambda:map(int,input().split())
I=lambda:int(input())
S=lambda:input().rstrip('\n')
L=lambda:list(R())
P=lambda x:stdout.write(x)
lcm=lambda x,y:(x*y)//gcd(x,y)
hg=lambda x,y:((y+x-1)//x)*x
pw=lambda x:0 if x==1 else 1+pw(x//2)
chk=lambda x:chk(x//2) if not x%2 else True if x==1 else False
sm=lambda x:(x**2+x)//2
N=10**9+7
for _ in range(I()):
	n=I()
	a=L()
	stp=a[n//2]
	v=[0]*3
	pst1=pst2=-1
	for i in a:
		if i==stp:break
		if not v[0] or pst1==i:v[0]+=1;pst1=i
		elif v[1]<=v[0] or pst2==i:v[1]+=1;pst2=i
		else:v[2]+=1
	if 0 not in v and v[0]<v[1] and v[0]<v[2]:print(*v)
	else:print(0,0,0)