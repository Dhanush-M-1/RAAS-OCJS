t = int(input().strip())

for _ in range(t):
    n = int(input().strip())
    nums = [int(i) for i in input().strip().split()]
    has = True
    up = True
    cur = 0
    down_index = 0
    
    for i in range(n - 1):
        cur = i
        if nums[i + 1] <= i:
            up = False
            down_index = i + 1
            cur = nums[i] - 1
            break
            
    
    if not up:
        for i in range(down_index,n):
            if cur < 0:
                has = False
                break
            cur = min(cur,nums[i]) - 1
           
            
    
        
    if has:
        print('Yes')
    else:
        print('No')
            
