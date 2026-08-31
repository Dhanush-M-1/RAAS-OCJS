from math import ceil


def main():
    n, x, y = map(int, input().strip().split())
    print(max(0, ceil(n * y / 100) - x))


if __name__ == '__main__':
    main()
