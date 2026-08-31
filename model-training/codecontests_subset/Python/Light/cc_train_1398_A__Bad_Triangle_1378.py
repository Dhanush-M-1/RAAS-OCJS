t=int(input())
for t in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    flag=0
    ans=l[0]+l[1]
    for i in range(2,n):
        if ans<=l[i]:
            print(1,2,i+1)
            flag=1
            break
    if flag==0:
        print(-1)
    
    
        
                   
    
