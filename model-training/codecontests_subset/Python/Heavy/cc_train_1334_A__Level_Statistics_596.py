

def read_int():
    return int(input().strip())


def read_ints():
    return list(map(int, input().strip().split(' ')))


def solve():
    n = read_int()
    min_diff = 0
    p, c = [0], [0]
    for _ in range(n):
        a, b = read_ints()
        p.append(a)
        c.append(b)
    for i in range(1, n+1):
        if p[i]-c[i] < min_diff:
            return 'NO'
        min_diff = p[i]-c[i]
        if p[i] < p[i-1] or c[i] < c[i-1]:
            return 'NO'
        if c[i] > p[i]:
            return 'NO'
    return 'YES'


if __name__ == '__main__':
    T = read_int()
    for _ in range(T):
        print(solve())
