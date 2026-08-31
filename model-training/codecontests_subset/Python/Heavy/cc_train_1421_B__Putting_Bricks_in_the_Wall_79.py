import sys

t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())

    A = []
    for _ in range(n):
        A.append(sys.stdin.readline().strip())

    a = A[0][1]
    b = A[1][0]
    c = A[-1][-2]
    d = A[-2][-1]

    cells = []
    if a == b:
        if c == a:
            cells.append((n, n - 1))
        if d == a:
            cells.append((n - 1, n))
    elif c == d:
        if a == c:
            cells.append((1, 2))
        else:
            cells.append((2, 1))
    else:
        cells.append((1, 2))
        if b == c:
            cells.append((n, n - 1))
        else:
            cells.append((n - 1, n))

    print(len(cells))
    for cell in cells:
        print(cell[0], cell[1])