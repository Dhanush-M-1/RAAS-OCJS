for _ in range(1):
    n,k=map(int,input().split())
    one=[]
    two=[]
    both=[]
    a=[]
    for ii in range(n):
        x,y,z=map(int,input().split())
        a.append([x,y,z])
        if z*y:
            both.append(x)
        else:
            if z:
                two.append(x)
            if y:
                one.append(x)
    both.sort()
    one.sort()
    two.sort()
    ans=0
    tot=k
    bo=len(both)
    on=len(one)
    tw=len(two)
    if bo + min(on,tw)<k:
        print(-1)
    else:
        i=0
        if bo<k:
            for i in range(k-bo):
                ans+=(one[i] + two[i])
                tot-=1
            i+=1
        c=0    
        while tot:
            if i>=on or i>=tw:
                break
            if one[i]+two[i]<both[c]:
                ans+=one[i]+two[i]
                i+=1
                tot-=1
            else:
                ans+=both[c]
                c+=1
                tot-=1
        while tot:
            ans+=both[c]
            c+=1
            tot-=1
        print(ans)            
                
            
        