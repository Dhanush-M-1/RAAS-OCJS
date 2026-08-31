import sys

n, k = map(int, sys.stdin.readline().split())

a = list(map(int, sys.stdin.readline().split()))

xs = [0]
for i in range(n):
    x = a[i]

    while x != 0:
        xs.append(x)
        x = x//2
xs = list(set(xs))
# print(xs)
minVal = sys.maxsize
for x in xs:
    op_cnts = []
    for j in range(n):
        cnt = 0
        start = a[j]
        while start != x:
            if start < x:
                cnt = 999999
                break
            cnt += 1
            start = start//2
            # print(start)
        op_cnts.append(cnt)

    op_cnts = sorted(op_cnts)
    # print(op_cnts)
    sumVal = 0
    for l in range(k):
        sumVal += op_cnts[l]
    minVal = min(minVal, sumVal)
print(minVal)
