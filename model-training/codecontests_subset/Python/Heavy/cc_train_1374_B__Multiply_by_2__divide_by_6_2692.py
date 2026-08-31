

t = int(input())

for _ in range(t):
    
    n = int(input())
    
    val = 1
    count = 0
    flag = 0
    while(val != n):
        
        if(val < n):
            val = val * 6
            count += 1
        elif(val > n):
            if(val % 2 == 0 and val > 0):
                val = val // 2
                count += 1
            else:
                flag = 1
                print(-1)
                break
        
        if(val == n):
            break
    
    if(flag == 0):
        print(count)
                