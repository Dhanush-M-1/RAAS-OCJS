# cook your dish here
import math,sys
import heapq
from fractions import Fraction
from collections import Counter,defaultdict
def li(): return list(map(int,sys.stdin.readline().split()))
def ls(): return list(map(int,list(input())))
def la(): return list(input())
def ii():  return int(input())
def dic(x): return defaultdict(lambda: x) 
def isPrime(n):
    i= 2
    if n == 1:
        return False
    while i <= int(math.sqrt(n)):
        if n%i == 0:
            return False
        i = i + 1
    return True
def gcd(a,b):
    if b == 0:
        return a
    return gcd(b,a%b)
def LCM(a,b): 
    return (a*b) / gcd(a,b) 

n,s = li()
a = li()
a.sort()
if n == 1:
    print(abs(s-a[0]))
else:
    total = 0
    if a[n//2] < s :
        for i in range(n//2,n):
            if s > a[i]:
                total += abs(a[i]-s)
            else:
                break
        print(total)
    elif a[n//2] >s:
        for i in range((n//2),-1,-1):
            if s < a[i]:
                total += abs(a[i]-s)
            else:
                break
        print(total)
    else:
        print(0)
    



        

