

def read_int():
    return int(input().strip())


def read_ints():
    return list(map(int, input().strip().split(' ')))


def solve():
    """
    1
    14
    k+a[k mod 1]=k+a[0]

    2
    1 -1
    k+a[k mod 2]

    4
    5 5 5 1
    k+a[k mod 4]
    0 -> 5
    1 -> 6
    2 -> 7
    3 -> 4

    3
    3 2 1
    k+a[k mod 3]
    0 -> 0
    1 -> 3
    2 -> 4

    room(k) = k+a[k mod n] = p+a[p mod n]
    0+a[0 mod 3] = 0 = 3 = 1+a[1 mod 3]
    """
    n = read_int()
    a = read_ints()
    b = []
    for k in range(n):
        b.append((k+a[k%n])%n)
    b.sort()
    for i in range(1, n):
        if b[i] == b[i-1]:
            return 'NO'
    return 'YES'


if __name__ == '__main__':
    T = read_int()
    for _ in range(T):
        print(solve())
