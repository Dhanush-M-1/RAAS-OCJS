def main():
    res, h1 = 0, -1
    x1 = lo = -10 ** 9
    for _ in range(int(input())):
        x2, h2 = map(int, input().split())
        if lo < x1 - h1:
            res += 1
        elif x1 + h1 < x2:
            res += 1
            x1 += h1
        lo, x1, h1 = x1, x2, h2
    print(res)


if __name__ == '__main__':
    main()
