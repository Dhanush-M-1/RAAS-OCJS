def solve():
    n = int(input())
    grid = []

    for i in range(0,n):
        grid.append([x for x in input()])

    a = grid[0][1]
    b = grid[1][0]
    c = grid[n-1][n-2]
    d = grid[n-2][n-1]
    changes = []
    change = 0
    if a==b:
        if c==a:
            change+=1
            changes.append((n,n-1))
        if d == a:
            change += 1
            changes.append((n-1, n))
    else:
        if d==c:
            change+=1
            if b==c:
                changes.append((2,1))
            else:
                changes.append((1,2))
        else:
            change+=2
            if a!=c:
                changes.append((1,2))
                changes.append((n,n-1))
            elif a!=d:
                changes.append((1, 2))
                changes.append((n-1, n))
            elif b!=c:
                changes.append((2, 1))
                changes.append((n, n - 1))
            else:
                changes.append((2, 1))
                changes.append((n-1, n))
    print(change)
    for x in changes:
        print(x[0], x[1])
    return


def main():
    t = int(input())
    for i in range(t):
        solve()
    return


main()
