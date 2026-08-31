tests = int(input())
for test in range(tests):
    num = int(input())
    nums = list(map(int, input().split()))
    if nums[0] + nums[1] <= nums[-1]:
        print(1, 2, num)
    else:
        print(-1)
