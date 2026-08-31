import math
import sys
import collections
from collections import defaultdict
from sys import stdin, stdout

sys.setrecursionlimit(10**9)

def isPrime(n):
    flag=0
    if n==2:
        return True
    for i in range(2,math.ceil(math.sqrt(n+1))+1):
        if n%i==0:
            flag=1
            break
    
    if flag==1:
        return False
    else:
        return True

def find_divisors(n):
    for i in range(2,math.ceil(math.sqrt(n))+1):
        if n%i==0:
            return i


n=int(input())
d=find_divisors(n)
# print(d)
if n==1:
    print(1)
    print(0)
elif isPrime(n):
    print(1)
    print(0)
else:
    # print(isPrime(d),isPrime(n//d))
    if isPrime(d) and isPrime(n//d):
        print(2)
    else:
        print(1)
        print(d*find_divisors(n//d))