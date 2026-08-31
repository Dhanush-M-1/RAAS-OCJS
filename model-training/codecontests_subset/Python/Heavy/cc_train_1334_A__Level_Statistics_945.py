# -*- coding: utf-8 -*-
import sys

sys.setrecursionlimit(100000)
input = sys.stdin.readline
INF = 2**62-1

def read_int():
    return int(input())


def read_int_n():
    return list(map(int, input().split()))


def read_float():
    return float(input())


def read_float_n():
    return list(map(float, input().split()))


def read_str():
    return input().strip()


def read_str_n():
    return list(map(str, input().split()))


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


# @mt
def slv(N, PC):
    for p, c in PC:
        if p < c:
            return 'NO'
    for i in range(1, N):
        if not (PC[i-1][0] <= PC[i][0]):
            return 'NO'
        if not (PC[i-1][1] <= PC[i][1]):
            return 'NO'
        if not (PC[i][1] - PC[i-1][1] <= PC[i][0] - PC[i-1][0]):
            return 'NO'

    return 'YES'


def main():
    T = read_int()
    for _ in range(T):
        N = read_int()
        PC = [read_int_n() for _ in range(N)]
        print(slv(N, PC))


if __name__ == '__main__':
    main()
