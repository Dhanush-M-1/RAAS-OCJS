import sys
from collections import defaultdict

def main():
    n, k = [int(x) for x in sys.stdin.readline().split(" ")]
    arr = [int(x) for x in sys.stdin.readline().split(" ")]
    # vals[x][a] holds number of iterations to get from x to a
    arr.sort()
    vals = defaultdict(list)
    for i, a in enumerate(arr):
        count = 0
        while (a > 0):
            vals[a].append(count)
            a = a // 2
            count += 1
    minCount = 99999999999999
    for x,v in vals.items():
        if len(v) < k:
            continue
        else:
            a = sorted(v)
            minCount = min(minCount, sum(a[:k]))
    return minCount

print(main())
