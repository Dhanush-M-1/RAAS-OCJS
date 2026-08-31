import sys
from math import ceil,sqrt
read=sys.stdin.buffer.readline

mi=lambda:map(int,read().split())
li=lambda:list(mi())
cin=lambda:int(read())

def isp(n):
    i=2
    while i*i<=n:
        if n%i==0:
            return False
        i+=1
    return True


primes=[]

for _ in range(cin()):
    n=cin()
    a=li()
    mn,mx=max(a),-2
    for i in range(n):
        if a[i]==-1:
            if i>0 and a[i-1]!=-1:
                mx=max(a[i-1],mx)
                mn=min(mn,a[i-1])
            if i+1<n and a[i+1]!=-1:
                mx=max(a[i+1],mx)
                mn=min(mn,a[i+1])
    k=(mx+mn)//2
    if mn==-1 and mx==-2:
        k=0
    
    for i in range(n):
        if a[i]==-1:
            a[i]=k
    m=0
    for i in range(1,n):
        m=max(m,abs(a[i]-a[i-1]))
    print(m,k)