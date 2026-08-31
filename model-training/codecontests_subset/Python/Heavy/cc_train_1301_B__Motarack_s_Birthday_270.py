t = int(input())
INF = 1000000007

for _ in range(t):

    n = int(input())
    a = list(map(int, input().split()))

    # adjacent missing
    am = []

    m2 = -INF

    for i in range(1, n):
        if (a[i] == -1) ^ (a[i - 1] == -1):
            am.append(max(a[i], a[i - 1]))
        elif (a[i] != -1) and (a[i - 1] != -1):
            m2 = max(abs(a[i - 1] - a[i]), m2)

    if len(am) == 0:
        am.append(0)

    k = (max(am) + min(am)) // 2
    m = abs(max(am) - k)
    m = max(m, m2)

    print(m, k)
