def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        grid = []
        for __ in range(n):
            grid.append(input())
        a, b, c, d = grid[0][1], grid[1][0], grid[-1][-2], grid[-2][-1]
        total = 0; flips = []
        if a == b:
            if a == c:
                total += 1
                flips.append([n, n - 1])
            if a == d:
                total += 1
                flips.append([n - 1, n])
        elif c == d:
            if c == a:
                total += 1
                flips.append([1, 2])
            if c == b:
                total += 1
                flips.append([2, 1])
        else:
            total = 2
            if a == "0":
                flips.append([1, 2])
            else:
                flips.append([2, 1])
            if c == "1":
                flips.append([n, n - 1])
            else:
                flips.append([n - 1, n])
        print(total)
        for flip in flips:
            print(*flip)
main()