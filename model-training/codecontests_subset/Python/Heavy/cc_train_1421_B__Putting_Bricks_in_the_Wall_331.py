from sys import stdin,stdout
from math import gcd,sqrt,factorial,pi,inf
from collections import deque,defaultdict
input=stdin.readline
R=lambda:map(int,input().split())
I=lambda:int(input())
S=lambda:input().rstrip('\n')
L=lambda:list(R())
P=lambda x:stdout.write(str(x)+'\n')
lcm=lambda x,y:(x*y)//gcd(x,y)
hg=lambda x,y:((y+x-1)//x)*x
pw=lambda x:1 if x==1 else 1+pw(x//2)
chk=lambda x:chk(x//2) if not x%2 else True if x==1 else False
sm=lambda x:(x**2+x)//2
N=10**6+6

for _ in range(I()):
	n=I()
	a=[S() for i in range(n)]
	cnt=0
	ans=[]
	if a[0][1]!='0':cnt+=1;ans+=(1,2),
	if a[1][0]!='0':cnt+=1;ans+=(2,1),
	if a[-1][-2]!='1':cnt+=1;ans+=(n,n-1),
	if a[-2][-1]!='1':cnt+=1;ans+=(n-1,n),
	if cnt<=2:
		print(cnt)
		for i in ans:print(*i)
		continue
	cnt=0
	ans=[]
	if a[0][1]!='1':cnt+=1;ans+=(1,2),
	if a[1][0]!='1':cnt+=1;ans+=(2,1),
	if a[-1][-2]!='0':cnt+=1;ans+=(n,n-1),
	if a[-2][-1]!='0':cnt+=1;ans+=(n-1,n),
	print(cnt)
	for i in ans:print(*i)