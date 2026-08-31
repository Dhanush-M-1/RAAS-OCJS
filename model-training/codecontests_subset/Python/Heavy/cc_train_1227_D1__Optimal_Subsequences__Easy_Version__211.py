from sys import stdin,stdout
from math import gcd,sqrt,factorial,pi
from collections import deque,defaultdict
input=stdin.readline
R=lambda:map(int,input().split())
I=lambda:int(input())
S=lambda:input().rstrip('\n')
L=lambda:list(R())
P=lambda x:stdout.write(x)
lcm=lambda x,y:(x*y)//gcd(x,y)
hg=lambda x,y:((y+x-1)//x)*x
pw=lambda x:1 if x==1 else 1+pw(x//2)
chk=lambda x:chk(x//2) if not x%2 else True if x==1 else False
sm=lambda x:(x**2+x)//2
N=10**9+7
n=I()
d={}
for i in sorted(enumerate(R()),reverse=True,key=lambda x:x[1]):
	if i[1] not in d:
		d[i[1]]=[]
	d[i[1]]+=i,
	d[i[1]].sort(key=lambda x:x[0])
a=[]
for i in d:
	a.extend(d[i])
m=[]
x=[]
for i in range(n):
	x+=a[i],
	x.sort(key=lambda x:x[0])
	m.append(x.copy())
for i in range(I()):
	k,pos=R()
	print(m[k-1][pos-1][1])