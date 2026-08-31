t = int(input())
for i in range(t):
    n, m = map(int,input().split())
    a = [int(x) for x in input().split()]
    b = [int(x) for x in input().split()]
    c = 0
    count = 0
    for i in a:
        if i in b:
            c += i
            break
        else:
            count += 1
    if count == len(a):
        print("NO")
    else:
        print("YES")
        print(1,c)
        
            
        
        
        
        
    
    
    
    

    

        
            
    
        
    
    