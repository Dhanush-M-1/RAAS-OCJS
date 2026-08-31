t = int(input())
for _ in range(t):
    n = int(input())
    x = n
    count = 0
    ans = -1
    while(x >= 6):
        if(x%6 == 0):
            x = x//6
            count += 1
        else:
            break
    # print(x)    
    if(x==1):
        ans = count
        
    else:
        while(x>=3):
            if(x%3 == 0):
                x = x//3
                count += 2
            else:
                break
                        
        if(x==1):
            ans = count
            
                    
    print(ans)                
                    
                    
                    
                    
                    
                    