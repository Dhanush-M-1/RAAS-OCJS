for _ in range(int(input())):
    t=input()
    k,n,m=map(int,input().split())
    l1=list(map(int,input().split()))
    l2=list(map(int,input().split()))
    l=[];i=0;j=0;chk=0
    while i<n or j<m:
        
        while i<n:
            f=0
            if l1[i]!=0:
                if l1[i]<=k:
                    l.append(l1[i])
                    i+=1;f=1;chk=0
            elif l1[i]==0:
                l.append(l1[i]);k+=1;f=1;i+=1;chk=0
            if f==0:
                chk+=1;break
        while j<m:
            f=0
            if l2[j]!=0:
                if l2[j]<=k:
                    l.append(l2[j])
                    j+=1;f=1;chk=0
            elif l2[j]==0:
                l.append(l2[j])
                k+=1;f=1;j+=1;chk=0
            if f==0:
                chk+=1;break
        if chk>4:
            break
    if chk>4:
        print(-1)
    else:
        print(*l)
    
        
        
            