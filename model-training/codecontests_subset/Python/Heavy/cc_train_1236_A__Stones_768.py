
for _ in range(int(input())) :
    
    a,b,c = map(int,input().split())
    
    cnt1 = 0
    
    t1 = a 
    t2 = b 
    t3 = c 
    
    
    while(b>1 and a>0) :
        
        a = a-1 
        b = b-2 
        cnt1 = cnt1 + 3 
        
    while(b>0 and c>1) :
        
        b = b-1 
        c = c-2 
        cnt1 = cnt1 + 3 
    
    a = t1 
    b = t2
    c = t3 
    cnt2 = 0
    while(b>0 and c>1) :
        
        b = b-1 
        c = c-2 
        cnt2 = cnt2 + 3 
        
    while(b>1 and a>0) :
        
        a = a-1 
        b = b-2 
        cnt2 = cnt2 + 3 
        
    print(max(cnt1,cnt2))
        
        
    