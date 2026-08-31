from copy import copy

t = int(input())


def addList(a, b):
    c = [0] * 26
    for i in range(26):
        c[i] = a[i] + b[i]
    return c


for _ in range(t):
    n, m = map(int, input().split())
    s = input()

    row = [0] * 26
    occ = []

    for c in s:
        row[ord(c) - ord('a')] += 1
        occ.append(copy(row))

    p = [int(x) - 1 for x in input().split()]

    total = [0] * 26
    for pi in p:
        total = addList(total, occ[pi])

    total = addList(total, occ[-1])

    print(*total)
