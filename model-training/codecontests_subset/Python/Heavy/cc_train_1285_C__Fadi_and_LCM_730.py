from random import randint


def quickMulMod(a,b,m):
    ret = 0
    while b:
        if b&1:
            ret = (a+ret)%m
        b//=2
        a = (a+a)%m
    return ret

def quickPowMod(a,b,m):
    ret =1
    while b:
        if b&1:
            ret =quickMulMod(ret,a,m)
        b//=2
        a = quickMulMod(a,a,m)
    return ret


def isPrime(n,t=5):
    t = min(n-3,t)
    if n<2:
        return False
    if n==2: return True
    d = n-1
    r = 0
    while d%2==0:
        r+=1
        d//=2
    tested=set()
    for i in range(t):
        a = randint(2,n-2)
        while a in tested:
            a = randint(2,n-2)
        tested.add(a)
        x= quickPowMod(a,d,n)
        if x==1 or x==n-1: continue
        for j in range(r-1):
            x= quickMulMod(x,x,n)
            if x==n-1:break
        else:
            return False
    return True

def gcd(a,b):
    while b!=0:
        a,b=b,a%b
    return a

def factor(n):
    '''pollard's rho algorithm'''
    if n==1: return []
    if isPrime(n):return [n]
    fact=1
    cycle_size=2
    x = x_fixed = 2
    c = randint(1,n)
    while fact==1:
        for i in range(cycle_size):
            if fact>1:break
            x=(x*x+c)%n
            if x==x_fixed:
                c = randint(1,n)
                continue
            fact = gcd(x-x_fixed,n)
        cycle_size *=2
        x_fixed = x
    return factor(fact)+factor(n//fact)

def f():
    x = int(input())
    if x == 1:
        print('1 1')
        return
    if isPrime(x):
        print('1 {}'.format(x))
        return
    fa = factor(x)
    fa.sort()
    fa.append(1)
    # print(fa)
    parts = []
    tmp = 1
    for i in range(len(fa)-1):
        tmp *= fa[i]
        if fa[i] != fa[i+1]:
            parts.append(tmp)
            tmp = 1
    if len(parts)==1:
        print('1 {}'.format(x))
        return
    parts.sort()
    # print(parts)
    # dp
    ans = x
    bar = int(x**0.5)
    memo = [1]
    for p in parts[::-1]:
        l = len(memo)
        for i in range(l):
            tmp = p*memo[i]
            if tmp > bar:
                ans = min(ans,tmp)
            else:
                memo.append(tmp)
    print("{} {}".format(ans, x//ans))

f()
