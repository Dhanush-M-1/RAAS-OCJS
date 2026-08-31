t = int(input())
for _ in range(t):
    n = input()
    a = [0] * len(n)
    for s in range(len(n)):
        a[s] = n[s]
    ans = 0
    for i in range(len(n)-1):
        if a[i] != '?':
            if a[i] == a[i+1]:
                a[i+1] = '?'
                ans += 1
            if i < (len(n)-2):
                if a[i+2] == a[i]:
                    a[i+2] = '?'
                    ans += 1
    print(ans)
                
        
    
    
        
        
        
    
                
            
            
            
    
            
        
        
    
                
        
        
        
            
        
    
    
        
    
        
        
                
            
        
    
        
        
    
        
        
    
    

            
    
        

