from sys import stdin,stdout
from math import gcd,sqrt,factorial,pi,inf
from collections import deque,defaultdict
from bisect import bisect,bisect_left
from time import time
from itertools import permutations as per
input=stdin.readline
R=lambda:map(int,input().split())
I=lambda:int(input())
S=lambda:input().rstrip('\r\n')
L=lambda:list(R())
P=lambda x:stdout.write(str(x)+'\n')
lcm=lambda x,y:(x*y)//gcd(x,y)
nCr=lambda x,y:(f[x]*inv((f[y]*f[x-y])%N))%N
inv=lambda x:pow(x,N-2,N)
sm=lambda x:(x**2+x)//2
N=10**9+7

N=998244353

f=[1]
for i in range(1,int(3e5)+5):
	f+=(f[-1]*i)%N,
n,k=R()
a=[]
for i in range(n):
	x,y=R()
	a.extend([x*2,y*2+1])
a.sort()
ans=0
cnt=0
for i in a:
	if i%2:
		cnt-=1
	else:
		if k-1<=cnt:ans=(ans+nCr(cnt,k-1))%N
		cnt+=1
print(ans)