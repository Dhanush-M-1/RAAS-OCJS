import math
import bisect

def egcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        g, x, y = egcd(b % a, a)
        return (g, y - (b // a) * x, x)



def mulinv(b, n):
    g, x, _ = egcd(b, n)
    if g == 1:
        return x % n


primes = []

def isprime(n):
    for d in range(2, int(math.sqrt(n))+1):
        if n%d==0:
            return False
    return True


def argsort(ls):
    return sorted(range(len(ls)), key=ls.__getitem__)

def f(p=0):
    if p==1:
        return map(int, input().split())
    elif p==2:
        return list(map(int, input().split()))
    else:
        return int(input())



n = f()
cl = sorted(f(2))
a = 0
b = 0
cla = []
clb = []
for i in range(n):
    if cl[i]%2==0:
        b+=1
        clb.append(cl[i])
    else:
        a+=1
        cla.append(cl[i])

if a<b:
    nb = b - a
    nb = max(0, nb-1)
    if nb!=0:
        x = sum(clb[:nb])
    else:
        x = 0
elif b<a:
    na = a-b
    na = max(0, na - 1)
    if na != 0:
        x = sum(cla[:na])
    else:
        x = 0
else:
    x = 0

print(x)