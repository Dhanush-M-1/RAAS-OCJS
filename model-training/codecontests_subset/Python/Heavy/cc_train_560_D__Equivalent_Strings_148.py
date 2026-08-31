def solve(a, b):
    # DISGRACA DE TLE: O retorno 2

    if (a == b):
        return True

    if (len(a) == 1 or len(b) == 1):
        return False

    if (len(a) != len(b) or len(a) % 2 != 0):
        return False

    half_size = len(a) // 2

    a1 = a[:half_size]
    a2 = a[half_size:]

    b1 = b[:half_size]
    b2 = b[half_size:]

    return (solve(a1, b2) and solve(a2, b1)) or (solve(a1, b1) and solve(a2, b2))


wa = input()
wb = input()

if (solve(wa, wb)):
    print("YES")
else:
    print("NO")