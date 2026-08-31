#582_D1

import math

l = [int(i) for i in input().split(" ")]
n = l[0]
k = l[1]

ln = [int(i) for i in input().split(" ")]

ln = sorted(ln)

m = 1000000000

def findPart(n, a, d):
    s1 = []
    s2 = []
    s3 = []
    for i in range(0, len(a)):
        n = math.floor(math.log(a[i], 2)) + 1
        if n - d < 0:
            s3.append(a[i])
            continue
        bt = a[i] & (1 << (n - d))
        if bt == 0:
            s1.append(a[i])
        else:
            s2.append(a[i])
    ops = []
    for i in range(0, len(a)):
        n = math.floor(math.log(a[i], 2)) + 1
        ops.append(n - (d - 1))
    m = sum(ops[:k])
    if len(a) - len(s3) >= k:
        if len(s1) >= k and len(s2) >= k:
            m = min(m, findPart(n * 2, s1, d + 1), findPart(n * 2 + 1, s2, d + 1))
        elif len(s1) >= k:
            m = min(m, findPart(n * 2, s1, d + 1))
        elif len(s2) >= k:
            m = min(m, findPart(n * 2 + 1, s2, d + 1))
    return m
print(findPart(1, ln, 2))
