try:
    for _ in range(int(input())):
        n,m=map(int,input().split())
        l=list(map(int,input().split()))
        l1=list(map(int,input().split()))
        c=0
        u=0
        p=len(l)
        p1=len(l1)
        p2=p*p1
        for i in l:
            for j in l1:
                if i==j:
                    u=-1
                    
                    
                    print("YES")
                    print("1",end=" ")
                    print(i)
                    break
            
                    
                else:
                    c+=1
            if u==-1:
                break
            
        if c==p2:
            print("NO")
except:
    pass