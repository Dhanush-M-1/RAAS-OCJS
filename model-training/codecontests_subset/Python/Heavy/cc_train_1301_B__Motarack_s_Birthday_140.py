t = int(input())
for i in range(t):
    n = int(input())
    a = [0] + [int(i) for i in input().split()] + [0]
    delta = 0
    f = 0
    minn = 10000000000000
    maxx = -1
    prev_j = 1
    a[0] = a[1]
    a[n + 1] = a[n]
    for j in range(1, n + 1):
        if (a[j - 1] == -1 or a[j + 1] == -1) and a[j] < minn and a[j] != -1:
            minn = a[j]
        if (a[j - 1] == -1 or a[j + 1] == -1) and (a[j] > maxx):
            maxx = a[j]
        if delta < abs(a[j] - a[j - 1]) and a[j]!=-1 and a[j-1]!=-1:
            delta = abs(a[j] - a[j - 1])
    k = (minn + maxx + 1) >> 1
    m = max(maxx - k, k - minn, delta)
    if maxx == -1:
        print(0, 0)
    else:
        print(m, k)
