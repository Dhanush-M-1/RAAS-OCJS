import operator
from functools import reduce


def read_int():
    return int(input().strip())


def read_ints():
    return list(map(int, input().strip().split(' ')))


def sqrt(n):
    low, high = 1, 10**7
    while low < high:
        mid = (low+high)//2
        if mid**2 > n:
            high = mid
        else:
            low = mid+1
    return low


def first_divisor(q, include_self=False):
    for i in range(2, sqrt(q)):
        if q%i == 0:
            return i, q//i
    return 1, q


def solve():
    q = read_int()
    d0, q0 = first_divisor(q)
    if d0 != 1:
        d1, q1 = first_divisor(q0)
        if d1 != 1:
            print(1)
            print(d0*d1)
        else:
            print(2)
    else:
        print(1)
        print(0)


if __name__ == '__main__':
    solve()
