import time,math as mt,bisect as bs,sys
from sys import stdin,stdout
from collections import deque
from fractions import Fraction
from collections import Counter
from collections import OrderedDict
pi=3.14159265358979323846264338327950
def II(): # to take integer input
    return int(stdin.readline())
def IP(): # to take tuple as input
    return map(int,stdin.readline().split())
def L(): # to take list as input
    return list(map(int,stdin.readline().split()))
def P(x): # to print integer,list,string etc..
    return stdout.write(str(x)+"\n")
def PI(x,y): # to print tuple separatedly
    return stdout.write(str(x)+" "+str(y)+"\n")
def lcm(a,b): # to calculate lcm
    return (a*b)//gcd(a,b)
def gcd(a,b): # to calculate gcd
    if a==0:
        return b
    elif b==0:
        return a
    if a>b:
        return gcd(a%b,b)
    else:
        return gcd(a,b%a)
def bfs(adj,v): # a schema of bfs
    visited=[False]*(v+1)
    q=deque()
    while q:
        pass
def sieve():
    li=[True]*(2*(10**5)+5)
    li[0],li[1]=False,False
    for i in range(2,len(li),1):
        if li[i]==True:
            for j in range(i*i,len(li),i):
                li[j]=False
    prime=[]
    for i in range((2*(10**5)+5)):
        if li[i]==True:
            prime.append(i)
    return prime
def setBit(n):
    count=0
    while n!=0:
        n=n&(n-1)
        count+=1
    return count
mx=10**7
spf=[mx]*(mx+1)
def SPF():
    spf[1]=1
    for i in range(2,mx+1):
        if spf[i]==mx:
            spf[i]=i
            for j in range(i*i,mx+1,i):
                if i<spf[j]:
                    spf[j]=i
    return
def readTree(n,e): # to read tree
    adj=[set() for i in range(n+1)]
    for i in range(e):
        u1,u2=IP()
        adj[u1].add(u2)
    return adj
#####################################################################################
mod=10**9+7
def solve():
    n=II()
    li=L()
    a,b,c=li[0],li[1],li[-1]
    if a<(b+c) and b<(a+c) and c<(a+b):
        print(-1)
    else:
        print(1,2,n)
    return

t=II()
for i in range(t):
    solve()

    #######
   #
  #
 #######   #     #  # ####   # #     #
       #  # #   #  # #   #  # # #   #
      #  ####  #  # ####   ####  # #
######  #   # #### #    # #   #   #


