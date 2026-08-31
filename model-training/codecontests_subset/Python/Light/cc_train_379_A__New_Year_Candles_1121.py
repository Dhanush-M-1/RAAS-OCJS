I=lambda :map(int,input().split())
n,m=I()
a=n
while n>=m:
    z=n%m
    n=int(n/m)
    a+=n
    n+=z
print(a)