t = int(input())
for i in range(t):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    ans = 'NO'
    for j in a:
        if j in b:
            ans = 'YES'
            k = j
            break
    print(ans)
    if ans == 'YES':
        print(1, k)
    
        
    
        
            
            
            
        
            
            
            
            
            
            

    
        
        
        
        
    
    
        
            
    
        
        
                
            
            
            
            
    
            
                
        
        
    
            
    
        
            
        
    

    
    
    
           
        
        
        
            

        
    
        
    
    
    
