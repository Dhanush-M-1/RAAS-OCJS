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
	s,c=S().split()
	s=list(s)
	c=list(c)
	ln=len(s)
	l=min(ln,len(c))
	for i in range(l):
		if s[i]==c[i]=='A':continue
		elif s[i]<c[i]:break
		else:
			ind=0
			ch=s[i]
			for j in range(i,ln):
				if s[j]<=ch:
					ch=s[j]
					ind=j
			if s[i]==c[i] and s[i]==ch:continue
			else:
				s[i],s[ind]=s[ind],s[i]
				break
	if s[:l]<c[:l] or s[:l]==c[:l] and ln<len(c):print(*s,sep='')
	else:print('---')