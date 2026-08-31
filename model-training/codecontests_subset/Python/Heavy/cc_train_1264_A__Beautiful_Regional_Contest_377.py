from sys import maxsize, stdout, stdin,stderr
mod = int(1e9+7)
import sys
def I(): return int(stdin.readline())
def lint(): return [int(x) for x in stdin.readline().split()]
def S(): return input().strip()
def grid(r, c): return [lint() for i in range(r)]
from collections import defaultdict, Counter
import math
import heapq
from heapq import heappop , heappush
import bisect
from itertools import groupby
def gcd(a,b): 
    while b:
        a %= b
        tmp = a
        a = b
        b = tmp
    
    return a
 
def lcm(a,b): 
    return a  // gcd(a, b) * b
 
def check_prime(n):
    for i in range(2, int(n ** (1 / 2)) + 1):
        if not n % i:
            return False
    return True
def Bs(a, x):
    i=0
    j=0
    left = 1
    right = x
    flag=False
    while left<right:
        
        mi = (left+right)//2
        #print(smi,a[mi],x)
        
        if a[mi]<=x:
            left = mi+1
            i+=1
            
        else:
 
            right = mi
            j+=1
        #print(left,right,"----")
    #print(i-1,j)
    if left>0 and a[left-1]==x:
        return i-1, j
    else:
        return -1, -1
def nCr(n, r):
 
    return (fact(n) // (fact(r)
                * fact(n - r)))
 
# Returns factorial of n
def fact(n):
 
    res = 1
     
    for i in range(2, n+1):
        res = res * i
         
    return res
def primefactors(n):
    num=0
    
    while n % 2 == 0:
        num+=1
        n = n / 2
    
    for i in range(3,int(math.sqrt(n))+1,2):
         
    
        while n % i== 0:
            num+=1
            n = n // i
               
    
    if n > 2:
        num+=1
    return num
'''
def iter_ds(src):
    store=[src]
    while len(store):
        tmp=store.pop()
        if not vis[tmp]:
            vis[tmp]=True
            for j in ar[tmp]:
                store.append(j)
'''
def ask(a):
    print('? {}'.format(a),flush=True)
    n=I()
    
    return n


 
def dfs(i,p):
    
    a,tmp=0,0
    for j in d[i]:
        if j!=p:
            a+=1
            tmp+=dfs(j,i)
    
    if a==0:
        return 0
    
    return tmp/a + 1 
def primeFactors(n):
    l=[]
    
    while n % 2 == 0:
        l.append(2)
        n = n // 2
         

    if n > 2:
        l.append(n)
    return l
k=I()
for _ in range(k):
    
    n=I()
    q=lint()
    d=Counter(q)
    t=list(set(q.copy()))
    t.sort(reverse=True)
    g,s,b=0,0,0
    
    l=[d[t[0]]]
    for i in range(1,len(t)):
        l.append(d[t[i]]+l[-1])
        if l[-1]>n//2:
            break
    l=[0]+l
    
    i=len(l)-2
    #print(*t)
    #print(*l)
    g=l[1]
    while i>1:
        
        
        
            
        if b<=g:
                
            b+=(l[i]-l[i-1])
        else:
            s+=(l[i]-l[1])
            break
        
        i-=1
        #print(g,s,b)
    
    if min(g,s,b)>0 and g<min(s,b) and g+s+b<=n//2:
        print(g,s,b)
    else:
        print(0,0,0)









    




