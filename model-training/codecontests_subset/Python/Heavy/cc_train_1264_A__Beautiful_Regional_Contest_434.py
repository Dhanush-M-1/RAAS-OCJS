from collections import Counter


def abc(nums: list, l: int):
    if len(nums) < 10:
        return '0 0 0'
    dic = Counter(nums)
    keys = sorted(dic, reverse=True)
    if len(keys) < 3:
        return '0 0 0'
    gold = dic[keys[0]]
    silver = 0
    bronze = 0
    target = l//2
    needle = 1
    for i in keys[1:]:
        silver += dic[i]
        needle += 1
        if silver > gold:
            break
    else:
        return '0 0 0'
    for i in keys[needle:]:
        bronze += dic[i]
        needle += 1
        if bronze > gold:
            break
    else:
        return '0 0 0'
    if gold+silver+bronze > target:
        return '0 0 0'
    for i in keys[needle:]:
        if gold+silver+bronze+dic[i] > target:
            return '%d %d %d' % (gold, silver, bronze)
        bronze += dic[i]
    return '%d %d %d' % (gold, silver, bronze)


t = int(input())
out = []
for i in range(t):
    a = int(input())
    s = list(map(int, input().split(' ')))
    out.append(abc(s, a))
for i in out:
    print(i)
'''
test = sorted([13, 12, 21, 21, 12, 12, 12, 21, 1, 1, 1, 1, 1, 1], reverse=True)
print(test)
print(abc(test, len(test)))
'''