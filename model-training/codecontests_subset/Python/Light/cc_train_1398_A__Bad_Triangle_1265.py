t = int(input())

for _ in range(t):

    n = int(input())
    nums = list(map(int,input().split()))

    if nums[0] + nums[1] <= nums[-1]:
        print(*[1,2,n])
    else:
        print(-1)
    
