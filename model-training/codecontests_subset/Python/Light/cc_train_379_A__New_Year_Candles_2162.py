n,m=map(int,input().split())
i=0
while(True):
    i=i+1
    n=n-1
    if i%m==0:
        n=n+1
    if n==0:
        break
print (i)
