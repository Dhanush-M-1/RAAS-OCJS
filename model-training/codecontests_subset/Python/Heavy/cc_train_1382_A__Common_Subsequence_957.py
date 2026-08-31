

t=int(input())
for _t in range(t):
    
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    
    
    flag=0
    ans=-1
    for i in range(n):
        
        for j in range(m):
            
            if(a[i]==b[j]):
                
                flag=1
                ans=a[i]
                break
        
        if(flag==1):
            break
        
    if(flag==0):
        print("NO")
    else:
        print("YES")
        print('1',end=' ')
        print(ans)
        
        