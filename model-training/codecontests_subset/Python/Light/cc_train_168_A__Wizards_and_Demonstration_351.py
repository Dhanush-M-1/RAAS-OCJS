from math import ceil


def magicians(n, x, y):
    z = ceil(n * y / 100)
    if x < z:
        return z - x
    return 0


N, X, Y = [int(i) for i in input().split()]
print(magicians(N, X, Y))
