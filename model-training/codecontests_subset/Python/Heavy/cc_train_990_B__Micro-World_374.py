import bisect

def solve(n, k, A):
    A.sort()

    pos = n - 1
    ret = 0

    while pos >= 0:
        while pos > 0 and A[pos] == A[pos - 1]:
            pos -= 1
        idx = bisect.bisect_left(A, A[pos] - k)
        ret += pos - idx
        if A[idx] == A[pos]:
            pos -= 1
        else:
            pos = idx
    return n - ret

def driver():
    inp = [*map(lambda x : int(x), input().split())]
    n, k = inp[0], inp[1]
    A = [*map(lambda x: int(x), input().split())]
    print(solve(n, k, A))

driver()