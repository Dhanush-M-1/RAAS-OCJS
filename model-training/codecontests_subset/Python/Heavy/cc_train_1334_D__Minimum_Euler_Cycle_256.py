import itertools as it
import os


def items(k, n):
    return 2 * k * n - k * (k + 1)


def b(l, n):
    if l > n * (n - 1):
        return n

    low = 1
    high = n - 1
    while low < high:
        mid = (high + low) // 2
        if items(mid, n) < l:
            low = mid + 1
        else:
            high = mid

    return low


def row_gen(r, n):

    while r <= n:
        if r == n:
            yield 1
        else:
            x = r
            a = False

            while x < n:
                a = not a
                if a:
                    yield r
                else:
                    x += 1
                    yield x

        r += 1


"""
1 2 | 2

1 2 1 3 | 4 
    2 3 | 6
    
1 2 1 3 1 4 | 6 
    2 3 2 4 | 10
        3 4 | 12


last = n * (n - 1)
"""


def get_seg(l, r, n):
    start_row = b(l, n)
    count_r = l - items(start_row - 1, n)
    g = row_gen(start_row, n)

    return it.islice(g, count_r - 1, count_r + r - l )


def pp(input):
    T = int(input())
    for i in range(T):
        n, l, r = map(int, input().split())
        print(" ".join(map(str, get_seg(l, r, n))))


if "paalto" in os.getcwd():
    from string_source import string_source

    pp(
        string_source(
            """3
2 1 3
3 3 6
99995 9998900031 9998900031
"""
        )
    )
else:
    pp(input)
