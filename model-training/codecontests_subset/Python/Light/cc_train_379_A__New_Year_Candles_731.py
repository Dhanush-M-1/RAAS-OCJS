n,m=map(int,input().split())
k=n//m
n=n+k
t=n//m
while t-k>=m or t-k>0:
    n=n+t-k
    k=t
    t=n//m
n=n+t-k
print(n)