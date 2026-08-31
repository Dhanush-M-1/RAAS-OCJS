import sys

input = sys.stdin.readline


def inp():
    return (int(input()))


def inlt():
    return (list(map(int, input().split())))


def insr():
    s = input()
    return (list(s[:len(s) - 1]))


def invr():
    return list(map(int, input().split()))


def solve(a, b, c):
    k = 0
    res = [None, None]
    while k < n - 2:
        if res[0] is None and a[k] != b[k]:
            res[0] = a[k]

        if res[1] is None and b[k] != c[k]:
            res[1] = b[k]

        if res[0] is not None and res[1] is not None:
            break

        k += 1
    if res[0] is None:
        if a[-2] != b[-1]:
            res[0] = a[-2]
        else:
            res[0] = a[-1]

    if res[1] is None:
        res[1] = b[-1]
    return res


if __name__ == '__main__':
    n = inp()
    a = sorted(inlt())
    b = sorted(inlt())
    c = sorted(inlt())
    r = solve(a, b, c)
    print(r[0])
    print(r[1])

