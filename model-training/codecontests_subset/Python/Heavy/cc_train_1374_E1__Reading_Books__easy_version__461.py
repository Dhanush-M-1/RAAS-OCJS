import time,math,bisect,sys
from sys import stdin,stdout
from collections import deque
from fractions import Fraction
from collections import Counter
from collections import OrderedDict
pi=3.14159265358979323846264338327950
def II(): # to take integer input
    return int(stdin.readline())
def IO(): # to take string input
    return stdin.readline()
def IP(): # to take tuple as input
    return map(int,stdin.readline().split())
def L(): # to take list as input
    return list(map(int,stdin.readline().split()))
def P(x): # to print integer,list,string etc..
    return stdout.write(str(x))
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
def sieve():
    li=[True]*1000001
    li[0],li[1]=False,False
    for i in range(2,len(li),1):
        if li[i]==True:
            for j in range(i*i,len(li),i):
                li[j]=False
    prime=[]
    for i in range(1000001):
        if li[i]==True:
            prime.append(i)
    return prime
def setBit(n):
    count=0
    while n!=0:
        n=n&(n-1)
        count+=1
    return count
def readTree(v,e): # to read tree
    adj=[set() for i in range(v+1)]
    for i in range(e):
        u1,u2,w=IP()
        adj[u1].add((u2,w))
        adj[u2].add((u1,w))
    return adj
def dfshelper(adj,i,visited):
    nodes=1
    visited[i]=True
    for ele in adj[i]:
        if visited[ele]==False:
            nd=dfshelper(adj,ele,visited)
            nodes+=nd
    return nodes
def dfs(adj,v): # a schema of bfs
    visited=[False]*(v+1)
    li=[]
    for i in range(v):
        if visited[i]==False:
            nodes=dfshelper(adj,i,visited)
            li.append(nodes)

    return li
#####################################################################################
mx=10**9+7
def solve():
    n,k=IP()
    a,b,ab=[],[],[]
    at,bt=0,0
    for i in range(n):
        t=L()
        if t[-2]==1 and t[-1]==1:
            ab.append(t[0])
        elif t[-2]==1 and t[-1]==0:
            a.append(t[0])
        elif t[-2]==0 and t[-1]==1:
            b.append(t[0])
        at+=t[0]
        bt+=t[0]
    at,bt=0,0
    t=0
    a.sort(reverse=True)
    b.sort(reverse=True)
    ab.sort(reverse=True)
    while (at<k or bt<k) and (ab or (a and b)):
        if ab and a and b:
            x,y=ab[-1],a[-1]+b[-1]
            if x<=y:
                t+=ab.pop()
            else:
                t=t+a.pop()+b.pop()
        else:
            if ab:
                t+=ab.pop()
            else:
                t=t+a.pop()+b.pop()
        at+=1
        bt+=1
    if at==k and bt==k:
        print(t)
        return
    else:
        print(-1)
        return

solve()

    #######
   #
  #
 #######   #     #  # ####   # #     #
       #  # #   #  # #   #  # # #   #
      #  ####  #  # ####   ####  # #
######  #   # #### #    # #   #   #