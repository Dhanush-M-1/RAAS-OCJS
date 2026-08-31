
def swap_range(li, b, e, t):
    """Swap element (b + k) and element (t + k) (0 <= k < e-b).

    >>> li = ['1', '2', '3', '4', '5', '6', '7', '8']
    >>> swap_range(li, 1, 3, 5)
    >>> " ".join(li)
    '1 6 7 4 5 2 3 8'
    >>> swap_range(li, 3, 5, 4)
    >>> " ".join(li)
    '1 6 7 5 2 4 3 8'
    """
    for k in range(e-b):
        li[b+k], li[t+k] = li[t+k], li[b+k]


def run():
    n = int(input())
    li = input().split()
    assert(n == len(li))

    q = int(input())
    for _ in range(q):
        b, e, t = [int(x) for x in input().split()]
        swap_range(li, b, e, t)

    print(" ".join(li))


if __name__ == '__main__':
    run()

