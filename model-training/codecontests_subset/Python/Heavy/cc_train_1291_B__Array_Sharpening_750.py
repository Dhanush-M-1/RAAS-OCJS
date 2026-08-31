def is_good(nums):
    n = len(nums)

    incl = [0] * n
    incl[0] = 0

    left_inc_border = 0
    for i in range(1, n):
        if nums[i] > incl[i - 1]:
            incl[i] = incl[i - 1] + 1
            left_inc_border = i
        else:
            break

    incr = [0] * n
    incr[-1] = 0

    right_inc_border = n - 1
    for i in range(n - 2, -1, -1):
        if nums[i] > incr[i + 1]:
            incr[i] = incr[i + 1] + 1
            right_inc_border = i
        else:
            break

    return left_inc_border >= right_inc_border


is_good([1, 0, 1])
t = int(input())
for _ in range(t):
    n = int(input())
    *nums, = map(int, input().split())
    print("Yes" if is_good(nums) else "No")
