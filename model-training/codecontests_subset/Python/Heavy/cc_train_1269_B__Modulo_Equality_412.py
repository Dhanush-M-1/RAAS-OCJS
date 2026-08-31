import sys
import math
def run(i, dif):
    global m
    for j in range(len(a)):
        indB = (j + i) % len(a)
        if b[indB] < a[j]:
            newDif = m - a[j] + b[indB]
        else:
            newDif = b[indB] - a[j]
        if newDif != dif:
            return False
    return True


n, m = list(map(int, sys.stdin.readline().split()))
a = list(map(int, sys.stdin.readline().split()))
b = list(map(int, sys.stdin.readline().split()))
a = sorted(a)
b = sorted(b)
ans = math.inf
for i in range(len(b)):
    if a[0] > b[i]:
        dif = m - a[0] + b[i]
    else:
        dif = b[i] - a[0]

    if run(i, dif):
        ans = min(ans, dif)
print(ans)