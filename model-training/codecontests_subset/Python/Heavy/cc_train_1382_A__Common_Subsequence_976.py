for _ in range(int(input())):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    
    adict={}
    bdict={}
    
    for val in a:
        try:
            adict[val]+=1
        except:
            adict[val]=1
            
    for val in b:
        try:
            bdict[val]+=1
        except:
            bdict[val]=1
    
    flag=0
    
    for key in adict:
        try:
            bdict[key]=bdict[key]
            ans=key
            flag=1
            break
        except:
            continue
        
    if(flag):
        print("YES")
        print(1,ans)
    else:
        print("NO")