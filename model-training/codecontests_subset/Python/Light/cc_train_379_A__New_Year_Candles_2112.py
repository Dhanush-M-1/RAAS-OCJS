n,m=map(int,input().split())
s,k=0,0
while n>0:
    s=s+1
    if s % m==0:n=n+1
    n=n-1
print(s)
