t = int(input())


def query(i, n, x):
    if (x % 2 == 1):
        return i
    else:
        return (i + x // 2)


for _ in range(t):
    n, l, r = map(int, input().split())

    i = 1
    s = 0

    includeOne = False

    if r == n * (n - 1) + 1:
        includeOne = True
        r -= 1
    if l == n * (n - 1) + 1:
        print(1)
        continue

    while s + 2 * (n - i) < l:
        s += 2 * (n - i)
        i += 1

    newS = s
    allIs = [i]
    while newS + 2 * (n - i) < r:
        newS += 2 * (n - i)
        i += 1
        allIs.append(i)

    allIin = 0

    answer = []

    i = allIs[0]

    for x in range(l, r + 1):
        r = query(i, n, x - s)
        if r == n:
            s += 2 * (n - i)
            i += 1
        answer.append(r)

    if includeOne:
        answer.append(1)

    print(*answer)
