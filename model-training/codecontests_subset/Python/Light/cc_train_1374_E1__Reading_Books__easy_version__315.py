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
N=10**10+7
n,k=R()
A=[]
B=[]
D=[]
for i in range(n):
	t,a,b=R()
	if a==b==1:D+=t,
	elif a:A+=t,
	elif b:B+=t,
A.sort()
B.sort()
for i in range(min(len(A),len(B))):
	D+=A[i]+B[i],
D.sort()
if len(D)>=k:print(sum(D[:k]))
else:print(-1)