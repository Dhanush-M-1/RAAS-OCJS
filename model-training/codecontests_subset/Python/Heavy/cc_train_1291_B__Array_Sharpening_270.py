import sys


def sol():
    N = int(sys.stdin.readline())
    A = list(map(int, sys.stdin.readline().split()))

    inc_flags, dec_flags = make_tables(N, A)
    for i in range(N):
        if inc_flags[i] is True and dec_flags[i] is True:
            return True
    return False


def make_tables(N, A):
    inc_flags = [False for _ in range(N)]
    dec_flags = [False for _ in range(N)]
    for i in range(N):
        if A[i] < i:
            break
        else:
            inc_flags[i] = True

    for i in range(N - 1, -1, -1):
        if A[i] < N - 1 - i:
            break
        else:
            dec_flags[i] = True

    return inc_flags, dec_flags


T = int(input())
for _ in range(T):
    if sol():
        print('Yes')
    else:
        print('No')
