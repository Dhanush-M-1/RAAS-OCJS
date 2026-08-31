def main():
    [n, x, y] = [int(_) for _ in input().split()]
    a = n / 100 * y - x

    if a <= 0:
        print(0)
    else:
        from math import ceil
        print(ceil(a))


if __name__ == '__main__':
    main()
