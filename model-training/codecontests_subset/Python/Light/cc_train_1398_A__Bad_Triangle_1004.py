t=int(input())
for _ in range(t):
    n = int(input())
    nums = list(map(int, input().split()))
    flag=0
    for i in range(len(nums)-2):
        x = nums[i] + nums[i+1]
        if nums[-1] >= x:
            print(i+1, i+2, len(nums))
            flag=1
            break
    if (flag==0):
        print(-1)
    
        
        
    
