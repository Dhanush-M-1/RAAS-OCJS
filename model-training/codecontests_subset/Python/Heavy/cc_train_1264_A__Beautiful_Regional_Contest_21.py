# nmax = 4 * (10 ** 5) + 1
if __name__ == '__main__':
    n = int(input())
    # arr = [0 for _ in range(nmax)]

    while n > 0:
        q = int(input())
        x = list(map(lambda x: int(x), input().split(' ')))
        cnt = int(q / 2)

        while cnt > 0 and x[cnt - 1] == x[cnt]:
            cnt -= 1
        if cnt == 0:
            print(0, 0, 0)
            n -= 1
            continue

        g = 1
        while g < cnt and x[g - 1] == x[g]:
            g += 1
        s = g + 1
        while g + s < cnt and x[g + s - 1] == x[g + s]:
            s += 1
        b = cnt - g - s
        if b > g:
            print(g, s, b)
        else:
            print(0, 0, 0)
        n -= 1
