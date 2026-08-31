from itertools import combinations


def stdin(t):
    for _ in range(t):
        n = int(input())
        a = [int(x) for x in input().split()]
        print(main(a, n))


def main(a, n):
    if a[n-1] >= a[0] + a[1]:
        return '{} {} {}'.format(1, 2, n)
    return -1


if __name__ == '__main__':
    stdin(int(input()))
