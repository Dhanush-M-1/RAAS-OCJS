n,m=map(int,input().split())
x=n
while n>=m:
    x+=n//m
    n=n//m+n%m
print(x)
