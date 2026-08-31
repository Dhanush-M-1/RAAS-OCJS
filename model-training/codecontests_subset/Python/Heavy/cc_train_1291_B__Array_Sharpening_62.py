from collections import Counter as C,defaultdict as D,deque as Q
from operator import itemgetter as I
from itertools import product as P,permutations as PERMUT
from bisect import bisect_left as BL,bisect_right as BR,insort as INSORT
from heapq import heappush as HPUSH,heappop as HPOP
from math import floor as MF,ceil as MC, gcd as MG,factorial as F,sqrt as SQRT, inf as INFINITY,log as LOG
from sys import stdin, stdout
INPUT=stdin.readline
PRINT=stdout.write
L=list;M=map

def Player1():
	print("")

def Player2():
	print("")

def Yes():
	PRINT("Yes\n")

def No():
	PRINT("No\n")

def IsPrime(n):

	for i in range(2,MC(SQRT(n))+1):
		if n%i==0:
			return False
	return True

def Factors(x):

	ans=[]

	for i in range(1,MC(SQRT(x))+1):
		if x%i==0:
			ans.append(i)
			if x%(x//i)==0:
				ans.append(x//i)
	return ans
def CheckPath(source,destination,g):
	visited=[0]*101
	q=Q()
	q.append(source)
	visited[source]=1
	while q:
		node=q.popleft()
		if node==destination:
			return 1
		for v in g[node]:
			if not visited[v]:
				q.append(v)
				visited[v]=1
	return 0
def Sieve(n):
	prime=[1]*(n+1)
	p=2
	while p*p<=n:
		if prime[p]:
			for i in range(p*p,n+1,p):
				prime[i]=0
		p+=1
	primes=[]
	for p in range(2,n+1):
		if prime[p]:
			primes.append(p)
	return primes

def Prefix(a,n):
	p=[]
	for i in range(n):
		if i==0:
			p.append(a[0])
		else:
			p.append(p[-1]+a[i])
	return p
def Suffix(a,n):
	s=[0]*n
	for i in range(n-1,-1,-1):
		if i==n-1:
			s[i]=a[i]
		else:
			s[i]=s[i+1]+a[i]
	return s
def Spf(n):
	spf=[0 for i in range(n)]
	spf[1]=1
	for i in range(2,n):
		spf[i]=i
	for i in range(4,n,2):
		spf[i]=2
	for i in range(3,MC(SQRT(n))+1):
		if spf[i]==i:
			for j in range(i*i,n,i):
				if spf[j]==j:
					spf[j]=i
	return spf

def DFS(g,s,visited,ans):
	visited[s]=1
	
	for u,c in g[s]:

		if visited[u]:
			continue

		if c==ans[s]:

			if c==1:
				ans[u]=2
			else:
				ans[u]=1
		else:
			ans[u]=c
		DFS(g,u,visited,ans)


def lcm(a,b):

	return (a*b)//(MG(a,b))

def Main():

	for _ in range(int(INPUT())):

		n=int(INPUT())
		a=L(M(int,INPUT().split( )))

		p,s=-1,n
		for i in range(n):
			if a[i]<i:
				break
			p=i

		for i in range(n-1,-1,-1):
			if a[i]< n-1-i:
				break
			s=i

		if p>=s:
			Yes()
		else:
			No()



















Main()

'mysql -u root -p'