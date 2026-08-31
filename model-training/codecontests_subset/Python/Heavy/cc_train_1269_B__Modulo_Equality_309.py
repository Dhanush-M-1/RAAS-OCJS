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
n,m=R()
a=sorted(R())
b=sorted(R())
p=sorted([(i-a[0])%m for i in b])
for i in p:
	if b==sorted([(a[j]+i)%m for j in range(n)]):exit(print(i))