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

t=int(inputt())
for _ in range(t):
    du,dv=0,0
    c=0
    n=int(inputt())
    li=[]
    for _ in range(n):
        l=listt()
        li.append(l)
    for i,j in li:
        du=i-du
        dv=j-dv
        if du<0 or dv<0:
            print("NO")
            c=1
            break
        elif (du-dv)<0:
            print("NO")
            c=1
            break
        du=i
        dv=j
    if c!=1:
        print("YES")    


