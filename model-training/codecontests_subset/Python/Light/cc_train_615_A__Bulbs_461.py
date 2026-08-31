def main():
    n, m = [int(t) for t in input().split()]
    y = [
        [int(t) for t in input().split()][1:]
        for _ in range(n)
        ]
    off = set([i for i in range(1, m + 1)])
    for yi in y:
        for yij in yi:
            if yij in off:
                off.remove(yij)

    if off:
        print('NO')
    else:
        print('YES')


if __name__ == '__main__':
    main()
