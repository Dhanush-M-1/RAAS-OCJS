import math


def main():
    n, x, y = map(int, input().split())
    print(max(0, math.ceil(n / 100 * y) - x))


if __name__ == '__main__':
    main()
