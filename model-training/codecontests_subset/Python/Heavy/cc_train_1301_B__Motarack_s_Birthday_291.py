from math import ceil

t = int(input())
for i in range(t):
    n = int(input())
    ar = list(map(int, input().split()))
    mn = float('-inf')
    m = set()
    for index, j in enumerate(ar):
        if j == -1:
            if index != 0:
                if ar[index - 1] != -1:
                    m.add(ar[index - 1])
            if index != n - 1:
                if ar[index + 1] != -1:
                    m.add(ar[index + 1])
    if m:
        ans = ceil((min(m) + max(m)) / 2)
    else:
        ans = 42
    for index in range(n):
        if index != 0:
            if ar[index] == -1:
                ar[index] = ans
            if ar[index - 1] == -1:
                ar[index - 1] = ans
            d = abs(ar[index] - ar[index - 1])
            if d > mn:
                mn = d
    print(mn, ans)
