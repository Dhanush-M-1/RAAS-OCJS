from math import ceil

for q in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    MIN = float('inf')
    MAX = -float('inf')
    if a[0] != -1 and a[1] == -1:
        MIN = min(MIN, a[0])
        MAX = max(MAX, a[0])
    if a[-1] != -1 and a[-2] == -1:
        MIN = min(MIN, a[-1])
        MAX = max(MAX, a[-1])



    for i in range(1, n - 1):
        if a[i] != -1 and (a[i - 1] == -1 or a[i + 1] == -1):
            MIN = min(MIN, a[i])
            MAX = max(MAX, a[i])

    if MIN == float('inf'):
        k = 0
    else:
        k = (MAX+MIN)//2

    res = 0
    for i in range(n - 1):
        if a[i] == -1:
            a[i] = k
        if a[i + 1] == -1:
            a[i + 1] = k
        res = max(abs(a[i] - a[i + 1]), res)
    print(res, k)


