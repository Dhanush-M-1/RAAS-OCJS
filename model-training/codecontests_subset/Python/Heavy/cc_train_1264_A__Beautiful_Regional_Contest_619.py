from math import ceil
from math import factorial
from collections import Counter
from operator import itemgetter
ii = lambda: int(input())
iia = lambda: list(map(int,input().split()))
isa = lambda: list(input().split())
 
t = ii()
 
for i in range(t):
	n = ii()
	a = iia()
	d = Counter(a)
	d = sorted(d.items(), key=itemgetter(0),reverse=True)
	s = 0
	x = []
	for i in range(n):
		if(s+d[i][1]<=n//2):
			s+=d[i][1]
			x.append(d[i][1])
		else:
			break
	if(s<5):
		print('0 0 0')
	else:
		k = 0
		if(len(x)>1):
			for i in range(1,len(x)):
				if(k<=x[0]):
					k+=x[i]
		g = x[0]
		b = s-x[0]-k
		s = k
		if(g<s and g<b):
			print(g,s,b)
		else:
			print('0 0 0')

