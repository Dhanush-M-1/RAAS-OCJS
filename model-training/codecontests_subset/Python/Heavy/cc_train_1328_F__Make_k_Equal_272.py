
n, k = map(int, input().split())

a_list = sorted(map(int, input().split()))

nums = [0 for i in range(1 + 2* (10**5))]
counts = [0 for i in range(1 + 2* (10**5))]

for a in a_list:
    count = 0
    nums[a] += 1
    while a != 0:
        a = a // 2
        count += 1
        if nums[a] < k:
            nums[a] += 1
            counts[a] += count
        #elif nums[a] == k:
        #    break

#print(nums[:10])
#print(counts[:10])

counts2 = [counts[i] for i, num in enumerate(nums) if num >= k]
out = min(counts2)
print(out)