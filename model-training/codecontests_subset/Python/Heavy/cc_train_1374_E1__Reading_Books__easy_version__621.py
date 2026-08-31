from sys import stdin
input=lambda : stdin.readline().strip()
from math import ceil,sqrt,factorial,gcd
from collections import deque
n,k=map(int,input().split())
a1=[]
b1=[]
x=set()
y=set()
com=[]
for i in range(n):
	t,a,b=map(int,input().split())
	if a==1 and b!=1:
		a1.append(t)
	if b==1 and a!=1:
		b1.append(t)
	if a==1 and b==1:
		com.append(t)
s=set()
count=0
a1.sort(reverse=True)
b1.sort(reverse=True)
com.sort(reverse=True)
a=k
b=k
# print(com,a1,b1)
if len(a1)+len(com)<k or len(b1)+len(com)<k:
	print(-1)
	exit()
while a>0 or b>0:
	if a>0 and b>0:
		if len(com)>0:
			if len(a1)>0 and len(b1)>0:
				if a1[-1]+b1[-1]<com[-1]:
					count+=a1.pop()+b1.pop()
					a-=1
					b-=1
				else:
					count+=com.pop()
					a-=1
					b-=1
			else:
				count+=com.pop()
				a-=1
				b-=1

		else:
			count+=a1.pop()+b1.pop()
			a-=1
			b-=1
	else:
		if len(com)>0:
			if a>0:
				if len(a1)>0 and a1[-1]<com[-1]:
					count+=a1.pop()
					a-=1
				else:
					count+=com.pop()
					a-=1
					b-=1
			else:
				if len(b1)>0 and b1[-1]<com[-1]:
					count+=a1.pop()
					b-=1
				else:
					count+=com.pop()
					a-=1
					b-=1
		else:
			if a>0:
				count+=a1.pop()
				a-=1
			else:
				count+=b1.pop()
				b-=1
	# print(a,b)
print(count)
				

