# -*- coding: utf-8 -*-

import sys
# sys.setrecursionlimit(10**6)
# buff_readline = sys.stdin.buffer.readline
buff_readline = sys.stdin.readline
readline = sys.stdin.readline

INF = 2**62-1


def read_int():
    return int(buff_readline())


def read_int_n():
    return list(map(int, buff_readline().split()))


def read_float():
    return float(buff_readline())


def read_float_n():
    return list(map(float, buff_readline().split()))


def read_str():
    return readline().strip()


def read_str_n():
    return readline().strip().split()

def error_print(*args):
    print(*args, file=sys.stderr)


def mt(f):
    import time

    def wrap(*args, **kwargs):
        s = time.time()
        ret = f(*args, **kwargs)
        e = time.time()

        error_print(e - s, 'sec')
        return ret

    return wrap


def divisor(n):
    for i in range(1, int(n**0.5)+1):
        if n % i == 0:
            yield i
            if i != n // i:
                yield n // i


@mt
def slv(N, A):


    if N == 1:
        print(1, 1)
        print(-A[0])

        print(1, 1)
        print(0)

        print(1, 1)
        print(0)

        return

    a = A[:]
    na = a[:]
    error_print([-na[i] % N for i in range(N)])
    for i in range(N-1):
        if a[i] > 0:
            na[i] = a[i] + (a[i] % N) * (N-1)
        else:
            na[i] = a[i] - (N - (a[i] % N)) * (N-1)
    print(1, N-1)
    print(*[na[i] - a[i] for i in range(N-1)])


    a = na[:]
    for i in range(N-1, N):
        if a[i] > 0:
            na[i] = a[i] - (a[i] % N)
        else:
            na[i] = a[i] - (a[i] % N)
    print(N, N)
    print(*[na[i] - a[i] for i in range(N-1, N)])

    print(1, N)
    print(*[-na[i] for i in range(N)])

    error_print(na)
    error_print([-na[i]%N for i in range(N)])



def main():
    N = read_int()
    A = read_int_n()
    slv(N, A)


if __name__ == '__main__':
    main()
