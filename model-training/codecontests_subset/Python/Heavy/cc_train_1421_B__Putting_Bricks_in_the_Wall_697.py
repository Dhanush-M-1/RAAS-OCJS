def find_invert_positions(m):
    n = len(m)
    a = m[0][1]
    b = m[1][0]
    c = m[n - 1][n - 2]
    d = m[n - 2][n - 1]

    coords = []
    if a == b:
        if c == a:
            coords.append([n, n - 1])
        if d == a:
            coords.append([n - 1, n])
    elif c == d:
        if a == c:
            coords.append([1, 2])
        if b == c:
            coords.append([2, 1])
    else:
        coords.append([2, 1])
        if c == a:
            coords.append([n, n - 1])
        if d == a:
            coords.append([n - 1, n])

    assert len(coords) <= 2
    print(len(coords))
    for y, x in coords:
        print("{} {}".format(y, x))

if __name__ == '__main__':
    n_t = int(input())
    for t in range(n_t):
        n = int(input())
        m = []
        for r in range(n):
            row = input()
            assert len(row) == n
            m.append(row)

        #print(m)

        find_invert_positions(m)
