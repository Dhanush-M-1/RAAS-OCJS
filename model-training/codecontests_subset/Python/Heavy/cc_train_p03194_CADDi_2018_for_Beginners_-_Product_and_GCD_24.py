import collections
def prime_factorize(n):
    a = []
    while n % 2 == 0:
        a.append(2)
        n //= 2
    f = 3
    while f * f <= n:
        if n % f == 0:
            a.append(f)
            n //= f
        else:
            f += 2
    if n != 1:
        a.append(n)
    return a

n,p=map(int,input().split())
c=collections.Counter(prime_factorize(p))
a=list(c.keys())
b=list(c.values())
ans=1
if n==1:print(p)
else:
    for i in range(len(b)):
        c=0
        while b[i]>=n:
            c+=1
            b[i]-=n
        ans*=a[i]**c
    print(ans)