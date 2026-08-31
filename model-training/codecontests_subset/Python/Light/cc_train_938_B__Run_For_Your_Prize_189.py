def read():
    return [int(v) for v in input().split()]


def main():
    l, r = 1, 10 ** 6
    read()
    a = read()
    ans = 0
    for v in a:
        ans = max(ans, min(v - l, r - v))
    print(ans)


if __name__ == '__main__':
    main()
