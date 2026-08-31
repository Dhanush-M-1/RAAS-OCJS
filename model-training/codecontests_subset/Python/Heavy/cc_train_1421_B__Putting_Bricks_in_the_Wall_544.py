tc = int(input())


def solve(grid):
    n = len(grid)

    ans = [(1, 2), (2, 1), (n, n - 1), (n - 1, n)]

    a, b = int(grid[0][1]), int(grid[1][0])
    c, d = int(grid[-1][-2]), int(grid[-2][-1])
    cur = [a, b, c, d]
    ans1 = [1, 1, 0, 0]
    ans2 = [0, 0, 1, 1]

    diff1 = []
    for a, b in zip(cur, ans1):
        diff1.append(abs(a - b))


    diff2 = []
    for a, b in zip(cur, ans2):
        diff2.append(abs(a - b))

    ret = []
    if sum(diff1) <= sum(diff2):
        for i in range(len(diff1)):
            if diff1[i] == 1:
                ret.append(ans[i])

    else:
        for i in range(len(diff2)):
            if diff2[i] == 1:
                ret.append(ans[i])

    return len(ret), ret


for _ in range(tc):
    n = int(input())
    grid = []
    for _ in range(n):
        line = str(input())
        grid.append(line)
    l, lst = solve(grid)
    print(l)
    for a,b in lst:
        print(a,b)
