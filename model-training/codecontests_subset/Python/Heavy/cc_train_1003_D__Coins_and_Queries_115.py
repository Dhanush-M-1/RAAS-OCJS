from collections import Counter as C
from operator import itemgetter
from math import ceil,sqrt,gcd
from collections import defaultdict as dd
d=dd(lambda:0)
from sys import stdin
input = stdin.readline

def mp():return map(int,input().split())
def it():return int(input())

n,k=map(int,input().split())
l=list(map(int,input().split()))
c=C(l)
d=sorted(list(set(l)))
d.reverse()
# print(d)
# print(c)
for i in range(k):
	q=it()	

	if d[-1]!=1 and q%2!=0:
		print(-1)
	else:
		count=0
		for i in d:
			if q>=i:
				m=min(q//i,c[i])
				q-=m*i
				count+=m
				# print(q)
		if q:
			print(-1)
		else:
			print(count)	

