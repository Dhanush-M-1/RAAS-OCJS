import sys

# inf = open('input.txt', 'r')
# reader = (line.rstrip() for line in inf)
reader = (line.rstrip() for line in sys.stdin)
input = reader.__next__

t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    minVal = float('inf')
    maxVal = -float('inf')
    for i, val in enumerate(a):
        if val >= 0 and (i > 0 and a[i - 1] < 0 or i < n - 1 and a[i + 1] < 0):
            minVal = min(minVal, val)
            maxVal = max(maxVal, val)
    if minVal == float('inf'):
        print(0, 0)
        continue
    
    k = (maxVal + minVal) >> 1
    if a[0] < 0:
        a[0] = k
    maxDelta = 0
    for i in range(1, n):
        if a[i] < 0:
            a[i] = k
        maxDelta = max(maxDelta, abs(a[i] - a[i - 1]))
    print(maxDelta, k)