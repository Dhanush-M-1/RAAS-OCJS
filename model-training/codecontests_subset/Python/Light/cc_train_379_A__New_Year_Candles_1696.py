n,m=map(int,input().split())
s=0
while n>=m:
    s+=n-n%m
    n=sum(divmod(n,m))
print(s+n)
