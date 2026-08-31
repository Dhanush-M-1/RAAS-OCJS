import math
for w in range(int(input())):
    x,y=list(map(int,input().split()))
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    flag=0
    if x<y:
        for i in a:
            if i in b:
                print("YES")
                print(1,i)
                flag=1
                break
    else:
        for i in b:
            if i in a:
                print("YES")
                print(1,i)
                flag=1
                break
    if flag==0:
        print("NO")
        
        
    
        
        
                
            
    
        
    
                
      