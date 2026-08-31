num_buck, k = [int(x) for x in input().split()]
nums = [int(num) for num in input().split()]
mx = 0

for i in range(num_buck):
    if k % nums[i] == 0:
        mx = max(mx, nums[i])

print(int(k / mx))
