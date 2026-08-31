for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    if arr.count(-1) == n:
        print(0, 0)
        continue

    maximal = 0
    for i in range(n - 1):
        if arr[i] != -1 and arr[i + 1] != -1:
            maximal = max(maximal, abs(arr[i] - arr[i + 1]))

    # notnull = []
    # for i in arr:
    #     if i != -1:
    #         notnull.append(i)
    # if len(notnull) == 0:
    #     print(0, 0)
    #     continue

    neighs = []
    for i in range(n):
        if arr[i] != -1:
            continue
        if i != 0 and arr[i - 1] != -1:
            neighs.append(arr[i - 1])
        if i != n - 1 and arr[i + 1] != -1:
            neighs.append(arr[i + 1])

    a, b = min(neighs), max(neighs)
    t = (b - a - 1) // 2 + 1
    need = a + t

    if t >= maximal:
        print(t, need)
    else:
        print(maximal, need)
