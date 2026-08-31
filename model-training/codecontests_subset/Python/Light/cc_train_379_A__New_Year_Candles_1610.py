n,m=map(int,input().split())
total=n
while n>0:
    total+=n//m
    if (n//m)>0:
        n=n/m+int(n%m)
    else:
        n=n//m
print(int(total))