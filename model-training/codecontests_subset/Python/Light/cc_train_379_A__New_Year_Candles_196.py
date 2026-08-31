n,m=map(int,input().split())


i=0
c=0
ans=n
while(n>=m):
    c=0
    while(n>=m):
        n=n-m

        c+=1
    #print(n,c)
    n=n+c
    ans+=c


print(ans)
