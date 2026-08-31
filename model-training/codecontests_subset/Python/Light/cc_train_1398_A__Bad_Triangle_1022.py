t = int(input())
  
for i in range(t):
    n = int(input())
    nums = list(map(lambda x: int(x),input().split()))
    
    if nums[0] + nums[1] <= nums[n-1]:
        print(1, 2, n)
    else:
        print(-1)