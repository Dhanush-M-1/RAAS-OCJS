from collections import defaultdict
n,k=map(int,input().split())
d=defaultdict(lambda: [0,0])
la=[]
lb=[]
lboth=[]
ca,cb,cboth=0,0,0
for x in range(n):
    t,a,b=map(int,input().split())
    if a==1 and b==1:
        lboth.append(t)
        cboth+=1
    elif a==1:
        la.append(t)
        ca+=1
        d[t][0]+=1
    elif b==1:
        lb.append(t)
        d[t][1]+=1
        cb+=1
if ca+cboth<k or cb+cboth<k:
    print(-1)
else:
    la.sort()
    lb.sort()
    lboth.sort()
    coa,cob=0,0
    ans=0
    a,b,c=0,0,0
    while((coa<k or cob<k)==True):
        if c<cboth:
            if a<ca and b<cb:
                if lboth[c]<=(la[a]+lb[b]):
                    coa+=1
                    cob+=1
                    ans+=lboth[c]
                    c+=1
                else:
                    coa+=1
                    cob+=1
                    ans+=la[a]+lb[b]
                    a+=1
                    b+=1
            else:
                coa+=1
                cob+=1
                ans+=lboth[c]
                c+=1
        else:
            break
    while(coa<k):
        coa+=1
        ans+=la[a]
        a+=1
    while(cob<k):
        cob+=1
        ans+=lb[b]
        b+=1
    print(ans)

    
                
                    
            
                
            
    
        
    
