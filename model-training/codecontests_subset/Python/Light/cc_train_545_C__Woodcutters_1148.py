n=int(input())
x={}
for _ in range(n):
    x1,h1=map(int,input().split())
    x[x1]=h1
y=sorted(x)
ans=1
z=y[0]
for i in range(1,n):
    if y[i]-x[y[i]]>z:
        z=y[i]
        ans+=1
    elif i+1 <n:
        if y[i]+x[y[i]]<y[i+1]:
            z=y[i]+x[y[i]]
            ans+=1
        else:
            z=y[i]
    else:
        ans+=1
print(ans)




    




