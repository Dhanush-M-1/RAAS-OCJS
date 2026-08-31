from sys import stdin,stdout
import sys
from bisect import bisect_left,bisect_right
import heapq
from collections import Counter
# sys.setrecursionlimit(2*(10**5))

# stdin = open("input.txt", "r");
# stdout = open("output.txt", "w");


n,m=stdin.readline().strip().split(' ')
n,m=int(n),int(m)


a=list(map(int,stdin.readline().strip().split(' ')))
b=list(map(int,stdin.readline().strip().split(' ')))

a=sorted(a,reverse=True)
b=sorted(b,reverse=True)

da=dict(Counter(b))
d={}
ans=1<<64
if a==b:
	ans=0
for i in b:
	diff=abs(a[0]-i)
	if a[0]<i:	#	Add d
		for j in a:
			kk=(j+diff)%m
			if kk in d:
				d[kk]+=1
			else:
				d[kk]=1
		if d==da:
			ans=min(ans,diff)

	else:		#	Add 1+d
		for j in a:
			kk=(j+m-diff)%m
			if kk in d:
				d[kk]+=1
			else:
				d[kk]=1
		if d==da:
			ans=min(ans,(m-diff))
	d={}

stdout.write(str(ans)+"\n")








