import math
import bisect
from collections import defaultdict
from collections import OrderedDict
from itertools import combinations 
#for _ in range(int(input())):
 
 
#a,b,c = map(int,input().split())
n = int(input())
#ar = list(map(int,input().split()))

#s  = list(input())

def factors(x):
    res = []
    i = 1
    while i*i <= x:

        if x%i == 0:
            res.append(i)

            if x//i != i:
                res.append(x//i)

        i += 1

    return res


fac = factors(n)
ans = 1e13
#print(fac)
#fac.sort()
#print(fac[0],fac[1])
for i in range(len(fac)):
    

    if (n//(math.gcd(fac[i],n//fac[i]))) == n:
        z = max(fac[i],n//fac[i])
        if z <= ans:
            a = fac[i]
            b = n//fac[i]
            ans = z

print(a,b)
                

        

    

        
        
        
        

    

            
    
        
    
    
    
 
    
 
 
"""
stuff you should look for
    * int overflow, array bounds
    * special cases (n=1?)
    * do smth instead of nothing and stay organized
    * WRITE STUFF DOWN
    * DON'T GET STUCK ON ONE APPROACH
"""
    
