n,c,b,a=map(int,input().split())
ans=0
for i in range(a+1):
    for j in range(b+1):
        e=n-2*i-1*j
        if(2*e<=c and e>=0):
            ans+=1
print(ans)
