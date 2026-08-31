from collections import Counter
import string
import math
import sys
# import random
# sys.setrecursionlimit(10**6) 
from fractions import Fraction
from itertools import product
def array_int():
    return [int(i) for i in sys.stdin.readline().split()]
def vary(arrber_of_variables):
    if arrber_of_variables==1:
        return int(sys.stdin.readline())
    if arrber_of_variables>=2:
        return map(int,sys.stdin.readline().split()) 
def makedict(var):
    return dict(Counter(var))
# i am noob wanted to be better and trying hard for that
def printDivisors(n): 
    divisors=[]  
    # Note that this loop runs till square root 
    i = 1
    while i <= math.sqrt(n): 
          
        if (n % i == 0) : 
              
            # If divisors are equal, print only one 
            if (n//i == i) : 
                divisors.append(i) 
            else : 
                # Otherwise print both 
                divisors.extend((i,n//i)) 
        i = i + 1
    return divisors
def countTotalBits(num):
     binary = bin(num)[2:]
     return(len(binary))
def isPrime(n):
    # Corner cases 
    if (n <= 1) : 
        return False
    if (n <= 3) : 
        return True
  
    # This is checked so that we can skip  
    # middle five numbers in below loop 
    if (n % 2 == 0 or n % 3 == 0) : 
        return False
  
    i = 5
    while(i * i <= n) : 
        if (n % i == 0 or n % (i + 2) == 0) : 
            return False
        i = i + 6
  
    return True
mod=10**9+7
# def ncr(n,r):
#     if n<r:
#         return 0
#     if n==r:
#         return 1
#     numer=fact[n]
#     # print(numer)
#     denm=(fact[n-r]*fact[r])
#     # print(denm)
#     return numer*pow(denm,mod-2,mod)
# def dfs(node):
#     global graph,m,cats,count,visited,val
#     # print(val)
#     visited[node]=1
#     if cats[node]==1:
#         val+=1
    
    
#     # print(val)
#     for i in graph[node]:
#         if visited[i]==0:
#             z=dfs(i)
#             # print(z,i)
#             count+=z
#         val-=1
#         return 0
#     else:
#         return 1
    
    
# fact=[1]*(1001)
# c=1
# mod=10**9+7
# for i in range(1,1001):
# print(fact)
def comp(x):
#     fact[i]=(fact[i-1]*i)%mod
    return x[1]
def SieveOfEratosthenes(n): 
    # Create a boolean array "prime[0..n]" and initialize 
    #  all entries it as true. A value in prime[i] will 
    # finally be false if i is Not a prime, else true. 
    prime = [True for i in range(n+1)] 
    p = 2
    while (p * p <= n): 
          
        # If prime[p] is not changed, then it is a prime 
        if (prime[p] == True): 
              
            # Update all multiples of p 
            for i in range(p * p, n+1, p): 
                prime[i] = False
        p += 1
      
    # Print all prime numbers 
    for p in range(2, n+1): 
        if prime[p]: 
            primes.append(p*p)
    primes=[]
# primes=[]
# SieveOfEratosthenes(2*(10**6))
def binary_search(arr, x):
    low = 0
    
    high = len(arr) - 1
    mid = 0
    while low <= high:
        mid = (high + low) // 2
  
        # Check if x is present at mid 
        if arr[mid] < x: 
            low = mid + 1
  
        # If x is greater, ignore left half 
        elif arr[mid] > x: 
            high = mid - 1
  
        # If x is smaller, ignore right half 
#     if val>m:
        else: 
            return mid 
  
    # If we reach here, then the element was not present 
    return -1
def lcm(a,b):
    return (a*b)//math.gcd(a,b)
def primeFactors(n): 
    factors=[]
    # Print the number of two's that divide n 
    while n % 2 == 0: 
        factors.append(2) 
        n = n // 2
          
    # n must be odd at this point 
    # so a skip of 2 ( i = i + 2) can be used 
    for i in range(3,int(math.sqrt(n))+1,2): 
          
        # while i divides n , print i ad divide n 
        while n % i== 0: 
            factors.append(i)
            n = n // i 
              
    # Condition if n is a prime 
    # number greater than 2 
    if n > 2: 
        factors.append(n)
    return factors
mod=10**9+7
testCases=1
testCases=vary(1)
for _ in range(testCases):
    n=vary(1)
    

    s=input()
    if n==1:
        print(0)
        continue
    beg=last=0
    for i in s:
        if i!='>':
            beg+=1
        else:
            break
    s=s[::-1]
    for i in s:
        if i!='<':
            last+=1
        else:
            break
    print(min(beg,last))


