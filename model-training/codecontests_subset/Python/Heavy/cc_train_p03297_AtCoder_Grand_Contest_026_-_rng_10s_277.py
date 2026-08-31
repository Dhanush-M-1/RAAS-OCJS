import sys

readline = sys.stdin.readline
MOD = 10 ** 9 + 7
INF = float('INF')
sys.setrecursionlimit(10 ** 5)


def main():
    from math import gcd

    def judge(a, b, c, d):
        if a - b < 0:
            return False
        else:
            if d - b < 0:
                return False

            first = a - b

            l = c + 1
            r = b - 1
            x = gcd(b, d)

            mod_min = first + (first - l + x - 1) // x * x
            mod_max = first + (r - first) // x * x
            if l <= mod_min <= r or l <= mod_max <= r:
                return False
            else:
                return True

    T = int(readline())

    for _ in range(T):
        a, b, c, d = map(int, readline().split())
        print("Yes") if judge(a, b, c, d) else print("No")


if __name__ == '__main__':
    main()
