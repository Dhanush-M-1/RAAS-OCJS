n,k=map(int,input().split())
v1,v2,v12=[],[],[]
for _ in range(n):
    t,l1,l2=map(int,input().split())
    if l1==1 and l2==1:
        v12.append(t)
    elif l1==1:
        v1.append(t)
    elif l2==1:
        v2.append(t)
    

v1.sort()
v2.sort()
v12.sort()
x,y,z=0,0,0
ans=0

sb=k-min(len(v1),len(v2))
sb = sb if sb>0 else 0
k-=sb

if sb>len(v12):
    print(-1)
else:
    for z in range(sb):
        ans+=v12[z]
    z=sb

    while(k>0 and z< len(v12)):
        if v12[z]<= v1[x]+v2[y]:
            ans+=v12[z]
            z+=1
        else:
            ans+=v1[x]+v2[y]
            x+=1
            y+=1
        k-=1
    if k<=(len(v1)-x) and k<= (len(v2)-y):
        while k>0:
            ans+=v1[x]+v2[y]
            x+=1
            y+=1
            k-=1
        print(ans)
    else:
        print(-1)

