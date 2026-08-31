for i in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    i=a[0]
    j=a[1]
    flag=0
    for k in range(len(a)-1,-1,-1):
        if i+j<=a[k]:
            print(1,end=" ")
            print(2,end=" ")
            print(k+1)
            flag=1
            break
    if flag==0:
        print(-1)
            
        
   
        
            
    
 