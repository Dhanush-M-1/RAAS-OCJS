n = int(input())
 
 
from itertools import combinations as comb
def Factor(n):
    Ans = []
    d = 2
    while d * d <= n:
        if n % d == 0:
            Ans.append(d)
            n //= d
        else:
            d += 1
    if n > 1:
        Ans.append(n)
    return Ans
 
def gcd(a,b):
    while b != 0:
        a, b = b, a % b
    return a
 
p = Factor(n)
 
if n == 1:
    print(1,1)
    exit()
a, b = 1 * p[0], 1
 
 
t = 0
c = 0
if len(p) == 1:
    print(a,b)
    exit()
    
a,b = 1,1
var = []
tmp = 1
t = p[0]
for i in range(len(p)):
    if p[i] == t:
        tmp *= t
    else:
        var.append(tmp)
        tmp = p[i]
        t = p[i]
        
var.append(tmp)
 
if len(var) == 2:
    print(*var)
    exit()
if len(var) == 1:
    print(1,var[0])
    exit()
 
 
 
       
var = sorted(var)
 
 
k = []
for g in range(len(var)):
    for e in comb(var, g):
        tmp = list(e)
        c = 1
        for j in range(len(tmp)):
            c *= tmp[j]
        k.append(c)
 
a, b = 1, 1   
m = max(k) + 10
 
 
for i in range(len(k)):
    for j in range(len(k)):
        if k[i] * k[j] == n and max(k[i],k[j]) < m and i != j:
            a, b = k[i], k[j]
            m = max(k[i], k[j])
    
print(a,b)