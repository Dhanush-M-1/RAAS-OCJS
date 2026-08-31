test_cases = int(input())
for _ in range(test_cases):
    n = int(input())
    nums = list(map(int, input().split()))
    if nums[0]+nums[1] > nums[-1]:
        print("-1")
    else:
        print(1,2,n)