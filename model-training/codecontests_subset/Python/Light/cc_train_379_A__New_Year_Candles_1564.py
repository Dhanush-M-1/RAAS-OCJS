m,n=map(int,input().split())
s=m
while(m>=n):
    s+=m//n
    m=m//n+m%n
print(s)