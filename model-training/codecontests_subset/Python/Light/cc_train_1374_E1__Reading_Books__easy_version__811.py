n,k=map(int,input().split())
p1=[]
a1=[]
b1=[]
c1=0
c2=0
for _ in range(n):
    p,a,b=map(int,input().split())
    if(a==1 and b==1):
        p1.append(p)
        c1+=1
        c2+=1
    elif(a==1):
        a1.append(p)
        c1+=1
    elif( b==1):
        b1.append(p)
        c2+=1
if(c1<k or c2<k):
    print(-1)
else:
    a1.sort()
    b1.sort()
    i=0
    while(i<len(a1) and i<len(b1)):
        p1.append(a1[i]+b1[i])
        i+=1
    p1.sort()
    ans=0
    for i in range(k):
        ans+=p1[i]
    print(ans)


