n,m=map(int,input().split())
h=n
while n>=m:
    d= n // m
    h += d
    x=n % m
    n=d + x
print(h)