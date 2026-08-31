# cook your dish here
import math
from collections import Counter
def gcd(a,b): 
    if a == 0: 
        return b 
    return gcd(b % a, a) 
def lcm(a,b): 
    return (a*b) / gcd(a,b) 
def printDivisors(n) : 
    i = 1
    l=[]
    while i <= math.ceil(math.sqrt(n)): 
        if (n % i == 0) : 
            if (n //i == i) : 
                l.append(i) 
            else : 
                l.append(i)
                l.append(n//i)
        i = i + 1
    return l
n=int(input())
m=1000000000001
r=printDivisors(n)
#print(r)
for i in r:
    if(m>max(i,n//i) and lcm(i,n//i)==n):
        m=max(i,n//i)
        a=i
        b=n//i
e=min(a,b)
f=max(a,b)
print(e,f)

  

    

