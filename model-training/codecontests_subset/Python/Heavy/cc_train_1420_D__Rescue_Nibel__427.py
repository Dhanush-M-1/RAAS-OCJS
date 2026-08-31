from functools import lru_cache
from sys import stdin, stdout
import sys
from math import *

# from collections import deque
# sys.setrecursionlimit(int(2e5+10))
input = stdin.readline
# print = stdout.write
# dp=[-1]*100000
N = 400000
factorialNumInverse = [None] * (N + 1) 
naturalNumInverse = [None] * (N + 1) 
fact = [None] * (N + 1) 
 
def InverseofNumber(p): 
    naturalNumInverse[0] = naturalNumInverse[1] = 1
    for i in range(2, N + 1, 1): 
        naturalNumInverse[i] = (naturalNumInverse[p % i] * 
                                   (p - int(p / i)) % p) 

def InverseofFactorial(p): 
    factorialNumInverse[0] = factorialNumInverse[1] = 1
  
    
    for i in range(2, N + 1, 1): 
        factorialNumInverse[i] = (naturalNumInverse[i] * 
                                  factorialNumInverse[i - 1]) % p 

def factorial(p): 
    fact[0] = 1
  
     
    for i in range(1, N + 1): 
        fact[i] = (fact[i - 1] * i) % p 
  

def Binomial(N, R, p): 
      
    
    ans = ((fact[N] * factorialNumInverse[R])% p * 
                      factorialNumInverse[N - R])% p 
    return ans


n,k=map(int,input().split())
s={}
e={}
a=[]
for i in range(n):
	x,y=map(int,input().split())
	if(s.get(x)==None):
		if(s.get(x)==None and e.get(x)==None):
			a.append(x)
		s[x]=0
	s[x]+=1
	if(e.get(y)==None):
		if(s.get(y)==None and e.get(y)==None):
			a.append(y)
		e[y]=0
	e[y]+=1
# a=list(set(a))
a.sort()

t=0
ans=0
mod=998244353

InverseofNumber(mod)
InverseofFactorial(mod)
factorial(mod)

for i in range(len(a)):
	x=0
	if(s.get(a[i])!=None):
		t+=s[a[i]]
		x=s[a[i]]
	if(x!=0 and t>=k):
		temp=t
		for j in range(x):
			temp-=1
			if(temp>=k-1):
				ans=(ans+Binomial(temp,k-1,mod))%mod

	if(e.get(a[i])!=None):
		t-=e[a[i]]
print(ans%mod)
# print(Binomial(1,0,mod))

