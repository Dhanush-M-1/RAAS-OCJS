import bisect
import decimal
from decimal import Decimal
import os
from collections import Counter
import bisect
from collections import defaultdict
import math
import random
import heapq 
from math import sqrt
import sys
from functools import reduce, cmp_to_key
from collections import deque
import threading
from itertools import combinations
from io import BytesIO, IOBase
from itertools import accumulate

# sys.setrecursionlimit(200000)
mod = 10**9+7
# mod = 998244353
decimal.getcontext().prec = 46

def primeFactors(n): 
    prime = set()
    while n % 2 == 0: 
        prime.add(2)
        n = n//2
    for i in range(3,int(math.sqrt(n))+1,2): 
        while n % i== 0: 
            prime.add(i)
            n = n//i 
    if n > 2: 
        prime.add(n)
    return list(prime)
    
def getFactors(n) : 
    factors = []
    i = 1
    while i <= math.sqrt(n): 
        if (n % i == 0) : 
            if (n // i == i) : 
                factors.append(i)
            else : 
                factors.append(i)
                factors.append(n//i)
        i = i + 1
    return factors
    
def modefiedSieve(): 
    mx=10**7+1
    sieve=[-1]*mx
    for i in range(2,mx):
        if sieve[i]==-1:
            sieve[i]=i
            for j in range(i*i,mx,i):
                if sieve[j]==-1:
                    sieve[j]=i
    return sieve
    
def SieveOfEratosthenes(n): 
    prime = [True for i in range(n+1)] 
    p = 2
    while (p * p <= n): 
        if (prime[p] == True): 
            for i in range(p * p, n+1, p): 
                prime[i] = False
        p += 1
    num = []
    for p in range(2, n+1): 
        if prime[p]: 
            num.append(p)
    return num

def lcm(a,b):
    return (a*b)//math.gcd(a,b)

def sort_dict(key_value):
    return sorted(key_value.items(), key = lambda kv:(kv[1], kv[0]), reverse=True)

def list_input():
    return list(map(int,input().split()))
    
def num_input():
    return map(int,input().split())
    
def string_list():
    return list(input())
    
def decimalToBinary(n):  
    return bin(n).replace("0b", "")  
    
def binaryToDecimal(n): 
    return int(n,2) 
    
def DFS(n,s,adj):              
    visited = [False for i in range(n+1)]  
    stack = [] 
    stack.append(s)  
  
    while (len(stack)):  
        s = stack[-1]  
        stack.pop() 
  
        if (not visited[s]):  
            visited[s] = True 
            
        for node in adj[s]:  
            if (not visited[node]):  
                stack.append(node)  
        
def maxSubArraySum(a,size): 
    max_so_far = -sys.maxsize - 1
    max_ending_here = 0
    start = 0
    end = 0
    s = 0
  
    for i in range(0,size): 
        max_ending_here += a[i] 
        if max_so_far < max_ending_here: 
            max_so_far = max_ending_here 
            start = s 
            end = i 
  
        if max_ending_here < 0: 
            max_ending_here = 0
            s = i+1
    
    return max_so_far,start,end
    
def lis(arr): 
    n = len(arr) 
    lis = [1]*n 
    for i in range (1 , n): 
        for j in range(0 , i): 
            if arr[i] >= arr[j] and lis[i]< lis[j] + 1 : 
                lis[i] = lis[j]+1
    maximum = 0
    for i in range(n): 
        maximum = max(maximum , lis[i]) 
  
    return maximum 
        
def solve():
    n = int(input())
    arr = list_input()
    even,odd = [],[]
    for i in arr:
        if i%2 != 0:
            odd.append(i)
        else:
            even.append(i)
    if abs(len(even)-len(odd)) <= 1:
        print(0)
        return
    odd.sort(reverse=True)
    even.sort(reverse=True)
    if odd == []:
        print(sum(even[1:]))
        return
    if even == []:
        print(sum(odd[1:]))
        return
    if len(even) < len(odd):
        print(sum(odd[len(even)+1:]))
    else:
        print(sum(even[len(odd)+1:]))
    
t = 1
#t = int(input())
for _ in range(t):
    solve()


    
    
    
    
