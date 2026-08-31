for _ in range(int(input())):
    n,l,r = map(int,input().split())
    s=0
    ans=[]
    for i in range(1,n):
        gap2=i
        t=i
        
        
        if s+(n-i)*2 >=l :
            for j in range(l,r+1):
                gg=(j-s)//2
                if j%2==1:
                    ans.append(gap2)
                else:
                    ans.append(gap2+gg)
                    if gap2+gg==n:
                        gap2+=1 
                        s+=(n-t)*2
                        t+=1
                        
            if r==n*(n-1)+1:
                ans[-1]=1 
            break
            
                    
        else:
            s+=(n-i)*2 
    if len(ans)==0:
        print(1)
    else:
        print(*ans)
            
        
    