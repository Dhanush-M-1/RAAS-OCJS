import time,math,bisect,sys
sys.setrecursionlimit(1000)
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
def readTree(): # to read tree
    n=II()
    adj=[set() for i in range(n+1)]
    for i in range(n-1):
        u1,u2=IP()
        adj[u1].add(u2)
        adj[u2].add(u1)
    return adj
#####################################################################################
def bfs(adj,n,s,d,points):
    visited=[False]*(n+1)
    q=deque()
    q.append(s)
    visited[s]=True
    parent=[0]*(n+1)
    parent[s]=s
    while q:
        ele=q.popleft()
        for k in adj[ele]:
            if visited[k]==False:
                visited[k]=True
                q.append(k)
                parent[k]=ele
    win=0

    for ele in d:
        if d[ele]==parent[ele]:
            win+=1
    if win>=points:
        return True
    return False

mx=10**9+7
def solve():
    n=II()
    mov=0
    while n!=1:
        if n%6==0:
            n=n//6
            mov+=1
        elif n%3==0:
            n=n*2
            mov+=1
        else:
            print(-1)
            return
    else:
        print(mov)


t=int(input())
for i in range(t):
    solve()

    #######
   #
  #
 #######   #     #  # ####   # #     #
       #  # #   #  # #   #  # # #   #
      #  ####  #  # ####   ####  # #
######  #   # #### #    # #   #   #