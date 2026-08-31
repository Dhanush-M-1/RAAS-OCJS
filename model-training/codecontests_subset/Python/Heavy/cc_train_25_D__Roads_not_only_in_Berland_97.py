import math
from sys import stdin,stdout
from bisect import bisect_left, bisect_right
from copy import deepcopy

def isprime(n):  
    if(n<=1): 
       return False
    if(n<=3) : 
       return True
    if(n%2==0 or n%3==0) : 
       return False
    i=5
    while(i*i<=n) : 
        if(n%i==0 or n%(i+2)==0) : 
           return False
        i=i+6
    return True
def freq(l): #return freq disctionary   
    f = {} 
    for i in l: 
        if (i in f): 
            f[i] += 1
        else:
          f[i] = 1
    return f

MAX = pow(10, 5)
inp=lambda : int(stdin.readline())
sip=lambda : stdin.readline()
mulip =lambda : map(int, stdin.readline().split())
lst=lambda : list(map(int,stdin.readline().split()))
slst=lambda: list(sip())
#-------------------------------------------------------

def make_set(N):
    for i in range(1,N+1):
        d[i] = i 

def find_set(a):
    if d[a]==a:
        return a
    else:
        d[a] = find_set(d[a])
        return d[a]

def union(a, b):
    x = find_set(a)
    y = find_set(b)
    if x==y:
        arr.append([a, b])
    else:
        d[max(x, y)]= min(x,y)

N = inp()
d = {}
arr = []
par = {}
make_set(N)
for i in range(N-1):
    a, b = mulip()
    union(a, b)
#print(d)
for i in d:
    x = find_set(i)
    if x not in par:
        par[x]=x
#print(par)
l = list(par.values())
if len(l)==1 or len(arr)==0:
    print(0)
else:
    print(len(l)-1)
    for i in range(1, len(l)):
        print(*arr[i-1],l[i-1],l[i])



    



