from copy import copy, deepcopy


def read_int():
    return int(input())


def read_arr():
    return [int(x) for x in input().split(' ')]


def read_mx(n, m):
    return [[int(num) for num in input().split(' ')] for _ in range(0, n)]


def pow_of(p, x):
    if x % p == 0:
        return pow_of(p, x // p) + 1
    else:
        return 0


def work(p_case):
    n = read_int()

    a3 = pow_of(3, n)
    b2 = pow_of(2, n)
    if b2 > a3 or pow(3, a3)*pow(2, b2) != n:
        print(-1)
        return
    k = a3 + (a3 - b2)
    print(k)


if __name__ == "__main__":
    # work(0)
    t = read_int()     # cases
    for case in range(0, t):
        work(case+1)
