n, k = [int(i) for i in input().split()]
lst = [int(i) for i in input().split()]


def light(k, lst):
    nums = [0 for j in range(1 + 2 * (10 ** 5))]
    counts = [0 for j in range(1 + 2 * (10 ** 5))]
    for elem in lst:
        count = 0
        nums[elem] += 1
        while elem != 0:
            elem //= 2
            count += 1
            if nums[elem] < k:
                nums[elem] += 1
                counts[elem] += count
    return min([counts[i] for i, num in enumerate(nums) if num >= k])


print(light(k, sorted(lst)))
