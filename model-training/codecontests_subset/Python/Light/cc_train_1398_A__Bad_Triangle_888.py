from sys import stdin

t = int(stdin.readline())
for _ in range(t):
    n = int(stdin.readline())
    nums = list(map(int,stdin.readline().split()))
    found = False
    for i in range(2,len(nums)):
        if nums[0] + nums[1] <= nums[i]:
            print(1,2,i+1)
            found = True
            break
    if not found:
        print(-1)
        
