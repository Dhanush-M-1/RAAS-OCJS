# https://codeforces.com/problemset/problem/519/B
from collections import Counter
n = int(input())
arr = [int(x) for x in input().split()]
first = [int(x) for x in input().split()]
second = [int(x) for x in input().split()]
freq = dict(Counter(arr))
first = dict(Counter(first))
second = dict(Counter(second))
for item in freq:
    if item not in first or first[item]!=freq[item]:
        print(item)
        break
for item in first:
    if item not in second or first[item]!=second[item]:
        print(item)
        break 