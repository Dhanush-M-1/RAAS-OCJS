from sys import stdin


def main():
    input()
    cc, nc, c, d = [0] * 31, [0] * 31, 1, {}
    for i in range(31):
        d[str(c)], cc[i], c = i, c, c * 2
    for i in map(d.get, input().split()):
        nc[i] += 1
    ncc = tuple((n, c) for n, c in zip(nc, cc) if n)[::-1]
    l, cache = stdin.read().splitlines(), {}
    for i, s in enumerate(l):
        if s in cache:
            l[i] = cache[s]
        else:
            x, r = int(s), 0
            for n, c in ncc:
                m = x // c
                if m > n:
                    m = n
                x -= m * c
                r += m
                if not x:
                    cache[s] = l[i] = str(r)
                    break
            else:
                cache[s] = l[i] = '-1'
    print('\n'.join(l))


if __name__ == '__main__':
    main()
