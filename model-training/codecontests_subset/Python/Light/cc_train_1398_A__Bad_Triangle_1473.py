t = int(input())
for test in range(t):
    n = int(input())
    nums = [int(x) for x in input().split()]
    first = nums[0]+nums[1]
    if first <= nums[-1]:
        print(1,2,n)
    else:
        print(-1)