import os,io
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

mod = 998244353

def factorial(n):
    fact = [i for i in range(n+1)]
    fact[0] = 1
    for i in range(3,n+1):
        fact[i] = (fact[i]*fact[i-1])%mod
    return fact

def invfac(n,factmax):
    m = pow(factmax,mod-2,mod)
    invf = [m for i in range(n+1)]
    for i in range(n-1,-1,-1):
        invf[i] = (invf[i+1]*(i+1))%mod
    return invf

def comb(a,b):
    if b>a:
        return 0
    elif b==a:
        return 1
    else:
        return (((factn[a]*invfactn[b])%mod)*invfactn[a-b])%mod

n,k = list(map(int,input().split()))
factn = factorial(n)
invfactn = invfac(n,factn[-1])
lrl = []
maxt = 0
for i in range(n):
    l,r = list(map(int,input().split()))
    lrl.append(2*l),
    lrl.append(2*r+1)

lrl = sorted(lrl)

s = 0
c = 0
for i in lrl:
    if i&1 == 0:
        s += comb(c,k-1)
        s %= mod
        c += 1
    else:
        c -= 1
print(s)