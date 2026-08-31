def solve(n, s, mx):
    # print(n, s, mx)
    if n == 0:
        print(s)
    else:
        for i in range(mx):
            solve(n - 1, s + chr(ord("a") + i), max(mx, i + 2))

n = int(input())
solve(n - 1, 'a', 2)