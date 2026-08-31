from math import ceil
from math import sqrt
from math import factorial
from collections import Counter
from operator import itemgetter
i = lambda: input()
ii = lambda: int(input())
iia = lambda: list(map(int,input().split()))
isa = lambda: list(input().split())

t = ii()

for _ in range(t):
	n = ii()
	a = iia()
	b = []
	if(a[0]==-1 and a[1]!=-1):
		b.append(a[1])
	if(a[1]==-1 and a[0]!=-1):
		b.append(a[0])
	if(a[-1]==-1 and a[-2]!=-1):
		b.append(a[-2])
	if(a[-2]==-1 and a[-1]!=-1):
		b.append(a[-1])
	for i in range(1,n-1):
		if(a[i]==-1):
			if(a[i-1]!=-1):
				b.append(a[i-1])
			if(a[i+1]!=-1):
				b.append(a[i+1])
	if(len(b)==0):
		b.append(1)
	b = list(set(b))
	b.sort()
	#print(b)
	#print(set(b))
	p = ceil((b[0]+b[-1])/2)
	c = 0
	for i in range(len(a)):
		if(a[i]==-1):
			a[i] = p
	#c = max(0,abs(a[0]-a[1]),abs(a[-1]-abs(a[-2])))
	for i in range(1,n):
		#print(a[i-1],a[i],a[i+1])
		c = max(c,abs(a[i]-a[i-1]))
	print(c,p)
