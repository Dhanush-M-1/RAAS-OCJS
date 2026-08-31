n,k=map(int,input().split())
ans=[]

c1=0
c2=0
for i in range(n):
    z=list(map(int,input().split()))
    
    if(z[1]==1):
        c1+=1
    if(z[2]==1):
        c2+=1
    ans.append(z)

if(min(c1,c2)<k):
    print(-1)
else:
    a0=[]
    a1=[]
    a2=[]
    for i in range(len(ans)):
        if(ans[i][1]==1 and ans[i][2]==1):
            a0.append(ans[i])
        elif(ans[i][1]==1 and ans[i][2]==0):
            a1.append(ans[i])
        elif(ans[i][1]==0 and ans[i][2]==1):
            a2.append(ans[i])
    p0=0
    p1=0
    p2=0
    c1=0
    c2=0
    
    a0.sort()
    a1.sort()
    a2.sort()
    total=0
    
    while(c1<k and c2<k):
        
        if(p0<len(a0) and p1<len(a1) and p2<len(a2) and a0[p0][0]<=a1[p1][0]+a2[p2][0]):
            total+=a0[p0][0]
            c1+=1
            c2+=1
            p0+=1
        else:
            if(p1<len(a1) and p2<len(a2)):
                total+=a1[p1][0]+a2[p2][0]
                c1+=1
                c2+=1
                p1+=1
                p2+=1
                continue;
            if(p1==len(a1) or p2==len(a2)):
                total+=a0[p0][0]
                c1+=1
                c2+=1
                p0+=1
            
            
    print(total)  
                
            

            
