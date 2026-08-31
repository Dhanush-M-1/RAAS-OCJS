from math import *

for i in range(int(input())):
    n, a = int(input()), list(map(int, input().split()))
    mi, ma, diff = float('inf'), -1, 0

    for j in range(n):
        if j > 0:
            if a[j - 1] == -1 and a[j] != -1:
                mi, ma = min(mi, a[j]), max(ma, a[j])
            elif a[j - 1] != -1 and a[j] != -1:
                diff = max(diff, abs(a[j] - a[j - 1]))

        if j < n - 1 and a[j] != -1 and a[j + 1] == -1:
            mi, ma = min(mi, a[j]), max(ma, a[j])

    # print(mi,ma,diff)
    if mi == float('inf') or ma == -1:
        print(0, 1)
    else:
        diff2 = ceil((ma + mi) / 2)
        print(max(ma - diff2, diff2 - mi, diff), diff2)
