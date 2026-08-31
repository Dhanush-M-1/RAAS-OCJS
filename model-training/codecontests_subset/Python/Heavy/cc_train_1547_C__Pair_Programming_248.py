import sys

def input():
    return sys.stdin.readline().strip()

def ints():
    return map(int, input().split())

def solve():
    input()
    k, n, m = ints()
    a = list(ints())
    b = list(ints())
    i = j = 0
    res = []
    while i < len(a) or j < len(b):
        if i < len(a) and a[i] == 0:
            res.append(a[i])
            k += 1
            i += 1
        elif j < len(b) and b[j] == 0:
            res.append(b[j])
            k += 1
            j += 1
        elif i < len(a) and a[i] <= k:
            res.append(a[i])
            i += 1
        elif j < len(b) and b[j] <= k:
            res.append(b[j])
            j += 1
        else:
            return [-1]
    return res

T = int(input())
for _ in range(T):
    print(*solve())