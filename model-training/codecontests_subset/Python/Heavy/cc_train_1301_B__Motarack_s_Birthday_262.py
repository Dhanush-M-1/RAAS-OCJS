

def tc():
    n = int(input())
    a = list(map(int, input().split()))
    m = 0
    minx = float('inf')
    maxx = 0

    for i in range(1, n):
        if a[i] == -1 and a[i - 1] == -1:
            continue
        elif a[i] != -1 and a[i - 1] != -1:
            m = max(abs(a[i] - a[i - 1]), m)
        else:
            x = a[i] if a[i - 1] == -1 else a[i - 1]
            minx = min(x, minx)
            maxx = max(x, maxx)

    k = (minx + maxx) // 2
    if k != k:  # check for nan
        k = 1
    m = max(m, maxx - k, k - minx)
    print(m, k)


T = int(input())
for _ in range(T):
    tc()
