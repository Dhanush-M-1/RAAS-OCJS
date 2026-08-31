def main():
    n, p, w, d = (int(i) for i in input().split())
    if p == 0:
        print(0, 0, n)
    elif (0--p//w) > n:
        print(-1)
    elif p % w == 0:
        x = p // w
        print(x, 0, n - x)
    else:
        s = set()
        for f in range(1, (0--p//w) + 1):
            r = p - (((0--p//w) - f) * w)
            if r % d in s:
                break
            s.add(r % d)
            if r % d == 0:
                x = (0--p//w) - f
                y = r // d
                z = n - x - y
                print(x, y, z)
                return
        print(-1)


if __name__ == '__main__':
    main()
