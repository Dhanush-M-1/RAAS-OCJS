
for _ in range(int(input())) :
    
    n,m = map(int,input().split())
    
    a = list(map(int,input().split()))
    
    b = list(map(int,input().split()))
    flag = 1
    
    for i in a :
        
        for j in b :
            
            if i==j :
                
                print("YES")
                
                print("1",end=" ")
                
                print(i)
                flag = 0
                
                break
            
        if flag ==1 :
            
            continue 
        
        else :
            break
        
    if flag==1 :
        print("NO")
            
            
            
            
    
    
    
    