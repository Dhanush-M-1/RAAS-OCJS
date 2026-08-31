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

# op_cnts = [0]*(2*(10**5))
op_cnts = dict()
for x in xs:
    op_cnts[x] = []
# print(op_cnts)
for i in range(n):
    cnt = 0
    start = a[i]
    while True:

        if start in op_cnts:
            op_cnts[start].append(cnt)
        cnt += 1
        if start == 0:
            break
        start = start // 2
minVal = sys.maxsize

for x in xs:
    if len(op_cnts[x]) >= k:
        sumVal = 0
        op_cnts[x] = sorted(op_cnts[x])
        for j in range(k):
            sumVal += op_cnts[x][j]
        minVal = min(minVal, sumVal)

print(minVal)
