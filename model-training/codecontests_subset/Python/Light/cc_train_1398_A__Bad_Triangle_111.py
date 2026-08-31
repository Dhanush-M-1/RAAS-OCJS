

def read_int():
    return int(input().strip())


def read_ints():
    return list(map(int, input().strip().split(' ')))


def solve():
    N = read_int()
    A = read_ints() # a+b < c
    if A[0]+A[1] <= A[-1]:
        return 1, 2, N
    return [-1]


if __name__ == '__main__':
    T = read_int()
    for _ in range(T):
        print(*solve())
