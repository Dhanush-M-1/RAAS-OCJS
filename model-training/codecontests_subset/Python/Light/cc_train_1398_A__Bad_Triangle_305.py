def run():
    num = int(input())
    nums = [int(i) for i in input().split()]
    if nums[0] + nums[1] <= nums[-1]:
        print(1, 2, num)
    else:
        print(-1)
n = int(input())
for i in range(n):
    run()
