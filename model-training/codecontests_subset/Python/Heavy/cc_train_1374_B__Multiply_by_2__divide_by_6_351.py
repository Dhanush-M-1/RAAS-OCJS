from collections import defaultdict
t = int(input())
for _ in range(t):
    n = int(input())
    ct = 0
    ans = 0
    while True:
        if n%6 == 0:
            ans += 1
            n = n//6
        else:
            break
    while True:
        if n%3 == 0:
            n = n//3
            ct += 1
        else:
            if n == 1:
                flag = True
                break
            else:
                flag = False
                break
    if flag:
        ans += 2*ct
    else:
        ans = -1
    print(ans)
        
            
    
    
    
    
            
