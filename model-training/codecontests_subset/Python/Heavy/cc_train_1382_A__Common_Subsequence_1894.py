for _ in range(int(input())):
    n,m=map(int,input().split())
    ccc=[0]*(1006)
    a=list(map(int,input().split()))
    a=list(set(a))
    
    b=list(map(int,input().split()))
    b=list(set(b))
    count=0
    for i in range(len(a)):
        ccc[a[i]]+=1
        if ccc[a[i]]>1:
            count+=1
    for i in range(len(b)):
        ccc[b[i]]+=1
        if ccc[b[i]]>1:
            count+=1
    if count==0:
        print("NO")
    else:
        print("YES")
        for i in range(len(ccc)):
            if ccc[i]==2:
        
                break
        print(1,i)
        
        
    
    
     