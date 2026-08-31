import bisect


def bisect_right(a, x, lo=0, hi=None):
    if hi is None:
        hi = len(a)
    while lo < hi:
        mid = (lo + hi) // 2
        if x < a[mid]: hi = mid
        elif x > a[mid]: lo = mid + 1
        else: return mid
    return ~lo


input()
first = list(map(int, input().split()))
second = list(map(int, input().split()))
second.sort()
secondCache = list(second)
for num in first:
    index = bisect_right(second, num)
    if (index < 0):
        print(num)
        first = secondCache
        second = list(map(int, input().split()))
        second.sort()
        break
    else:
        del second[index]

for num in first:
    index = bisect_right(second, num)
    if (index < 0):
        print(num)
        break
    else:
        del second[index]