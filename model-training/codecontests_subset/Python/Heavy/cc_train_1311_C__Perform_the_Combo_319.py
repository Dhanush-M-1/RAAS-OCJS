
from sys import maxsize, stdout, stdin,stderr
mod = int(1e9 + 7)

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
    return a  / gcd(a, b) * b

def check_prime(n):
    for i in range(2, int(n ** (1 / 2)) + 1):
        if not n % i:
            return False
    return True
def Bs(a, x):
    i=0
    j=0
    left = 0
    right = len(a)
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
 
    return (fact(n) / (fact(r)
                * fact(n - r)))
 
# Returns factorial of n
def fact(n):
 
    res = 1
     
    for i in range(2, n+1):
        res = res * i
         
    return res
t = I()
for _ in range(t):
    n,m=lint()
    s=input()
    p=lint()
    p.sort()
    a=[]
    d=defaultdict(lambda:0)
    c=defaultdict(lambda:0)
    ls=0
    for i in p:
        d[i]+=1
        
        a.append(i-ls)
        ls=i
    q=0
    
    tmp=a[q]
    for i in range(1,n+1):
        if tmp==0:
            q+=1
            while q<len(a) and a[q]==0:
                q+=1
            if q>=len(a):
                break
            tmp=a[q]
        c[s[i-1]]+=len(a)-q
        
        tmp-=1
        
        
    for i in range(n):
        c[s[i]]+=1
    for i in range(97,123):
        print(c[chr(i)],end=" ")
    print()
            
            
            
            
            



