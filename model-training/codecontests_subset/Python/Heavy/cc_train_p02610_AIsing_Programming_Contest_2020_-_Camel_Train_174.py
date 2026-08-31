import sys
input=sys.stdin.readline
from heapq import heappop,heappush
t=int(input())
for _ in range(t):
	happy=0
	n=int(input())
	camel=[]
	p=[]
	m=[]
	for i in range(n):
		k,l,r=map(int,input().split())
		happy+=min(l,r)
		if l-r>=0:
			p.append((k,l-r))
		else:
			m.append((k,r-l))
	p.sort();m.sort(reverse=True)
	now=0
	P=[];M=[]
	for i in range(n):
		if now<len(p):
			while p[now][0]==i+1:
				heappush(P,(p[now][1],p[now][0]))
				now+=1
				if now==len(p):
					break
		while len(P)>i+1:
			r=heappop(P)
	now=0
	for i in range(n,0,-1):
		if now<len(m):
			while m[now][0]==i:
				heappush(M,(m[now][1],m[now][0]))
				now+=1
				if now==len(m):
					break
		while len(M)>n-i:
			r=heappop(M)
	for x in P:
		happy+=x[0]
	for x in M:
		happy+=x[0]
	print(happy)