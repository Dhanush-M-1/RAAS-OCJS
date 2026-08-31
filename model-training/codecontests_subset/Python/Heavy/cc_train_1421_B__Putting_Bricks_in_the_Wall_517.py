t = int(input())
for _ in range(t):
    n = int(input())
    a = [0] * n
    for i in range(n):
        a[i] = input()
    if a[0][1] == a[1][0]:
        if a[n-1][n-2] == a[n-2][n-1]:
            if a[n-2][n-1] == a[1][0]:
                print(2)
                print(*[2, 1])
                print(*[1, 2])
            else:
                print(0)
        else:
            print(1)
            if a[n-1][n-2] == a[1][0]:
                print(*[n, n-1])
            else:
                print(*[n-1, n])
    else:
        if a[n-1][n-2] == a[n-2][n-1]:
            print(1)
            if a[n-1][n-2] == a[1][0]:
                print(*[2, 1])
            else:
                print(*[1, 2])
        else:
            print(2)
            print(1, 2)
            if a[n-1][n-2] == a[1][0]:
                print(*[n, n-1])
            else:
                print(*[n-1, n])
            
        
        
    
    
            
            


  
        
    
    
    
    
            
           
                                
            
            
            
    

    
    
    
