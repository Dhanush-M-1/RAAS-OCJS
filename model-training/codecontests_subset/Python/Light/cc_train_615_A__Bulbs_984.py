n , m = list(map(int, input().split(' ')))
bulbs = []
for _ in range(n):
    nums = list(map(int, input().split(' ')))
    for i in range(1, len(nums)):
        bulbs.append(nums[i])
uniqueBulbs = set(bulbs)
if len(uniqueBulbs) == m:
    print("YES")
else:
    print("NO")