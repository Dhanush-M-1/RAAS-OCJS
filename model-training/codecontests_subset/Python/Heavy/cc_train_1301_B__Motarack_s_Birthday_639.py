t = int(input())
for _ in range(t):
    n = int(input())
    a = [int(x) for x in input().split()]
    vals = []
    for i in range(n):
        if ((i - 1 >= 0 and a[i - 1] == -1) or (i + 1 < n and a[i + 1] == -1)) and a[i] != -1:
            vals.append(a[i])
    if len(vals) == 0:
        print(0, 0)
    else:
        # print("vals", vals)
        mid = (min(vals) + max(vals)) // 2
        maxResult = float("-inf")
        for i in range(n):
            if a[i] == -1:
                a[i] = mid
        for i in range(1, n):
            maxResult = max(maxResult, abs(a[i - 1] - a[i]))
            # print(abs(a[i - 1] - a[i]), i, mid)
        print(maxResult, mid)