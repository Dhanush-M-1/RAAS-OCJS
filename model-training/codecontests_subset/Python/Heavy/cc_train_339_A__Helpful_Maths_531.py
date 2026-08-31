import sys
import math
from collections import Counter
from collections import OrderedDict
from functools import reduce
sys.setrecursionlimit(10**6)
def inputt():
    return sys.stdin.readline().strip()
def printt(n):
    sys.stdout.write(str(n)+'\n')
def listt():
    return [int(i) for i in inputt().split()]
 
def gcd(a,b): 
   return math.gcd(a,b) 
 
def lcm(a,b): 
    return (a*b) // gcd(a,b) 

def factors(n):    
    return set(reduce(list.__add__,([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0)))

def comb(n,k):
    factn=math.factorial(n)
    factk=math.factorial(k)
    fact=math.factorial(n-k)
    ans=factn//(factk*fact)
    return ans

s=inputt()
l=[]
for i in range(len(s)):
    if i%2==0:
        l.append(int(s[i]))
l.sort()
for i in range(len(l)):
    print(l[i],end='')
    if i!=len(l)-1:
        print('+',end='')