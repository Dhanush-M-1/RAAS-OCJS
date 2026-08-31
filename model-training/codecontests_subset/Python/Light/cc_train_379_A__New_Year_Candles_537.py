n,m=map(int,input().split())
x=0
if m<=n:
    x=n+((n-m)/(m-1))+1
    print(int(x))
else:
    x=n
    print(x)