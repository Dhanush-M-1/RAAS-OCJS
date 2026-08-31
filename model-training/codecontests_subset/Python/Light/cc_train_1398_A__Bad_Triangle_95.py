T = int(input())

for i in range(T):
    
    n = int(input())
    
    arr = list(map(int, input().split()))
    
    a, b, c = arr[0], arr[1], arr[-1]
    
    if a+b <= c:
        print(1, 2, n)
    else:
        print(-1)
    
                        
    
        
    
    
        
    