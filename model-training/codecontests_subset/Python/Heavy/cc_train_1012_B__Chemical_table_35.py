from sys import stdin


def main():
    n, m, q = map(int, input().split())
    chm = list(range(n + m))
    r = [0] * (n + m)
    n -= 1
    res = n + m
    for s in stdin.read().splitlines():
        a, b = map(int, s.split())
        a -= 1
        b += n
        l = []
        while a != chm[a]:
            l.append(a)
            a = chm[a]
        for c in l:
            chm[c] = a
        l = []
        while b != chm[b]:
            l.append(b)
            b = chm[b]
        for c in l:
            chm[c] = b
        if a != b:
            if r[a] < r[b]:
                chm[a] = b
            elif r[b] < r[a]:
                chm[b] = a
            else:
                chm[a] = b
                r[b] += 1
            res -= 1
    print(res)


if __name__ == '__main__':
    main()
