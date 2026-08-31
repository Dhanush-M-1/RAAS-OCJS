def solve(n, l):
    l.append(-2)

    i = 0
    while (l[i] == -1):
        i += 1
    if (l[i] == -2):
        return [0, 0]

    l.insert(0, l[i])
    l.pop()

    j = len(l) - 1
    while (l[j] == -1):
        j -= 1
    l.append(l[j])

    n = len(l)
    i = 0
    j = 0
    mmax = -1
    mmin = 10**9 + 1

    while (j < n):
        while (i < n and l[i] == -1):
            i += 1

        j = i + 1
        while (j < n and l[j] == -1):
            j += 1

        if (j >= n):
            break

        if (j == i + 1):
            i = j
            continue

        mmin = min(mmin, min(l[i], l[j]))
        mmax = max(mmax, max(l[i], l[j]))

        i = j

    res = 0
    k = (mmin + mmax) // 2

    for i in range(1, n):
        if (l[i] == -1):
            l[i] = k
        res = max(res, abs(l[i] - l[i - 1]))

    return [res, k]


for t in range(int(input())):
    n = int(input())
    l = [int(i) for i in input().split()]
    res = solve(n, l)
    print(res[0], res[1])
