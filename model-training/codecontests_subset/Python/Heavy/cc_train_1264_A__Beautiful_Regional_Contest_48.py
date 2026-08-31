from collections import Counter


def read_ints(): return map(int, input().split())


def read_int(): return int(input())


t = read_int()
for _ in range(t):
    n = read_int()
    a = list(read_ints())
    if n < 10:
        print("0 0 0")
        continue

    cut = n//2
    if a[n//2-1] == a[n//2]: cut = a.index(a[n//2])
    if cut < 5:
        print("0 0 0")
        continue

    a = a[:cut]
    g = 0
    while g < cut and a[0] == a[g]: g += 1
    sb = a[g:]
    if len(sb) <= 2*g:
        print("0 0 0")
        continue
    cnt = Counter(sb)
    s = 0
    possible = False
    # print(sb)
    # print(cnt)
    last = -1
    for i, spi in enumerate(sb):
        if last != spi:
            last = spi
            i += (cnt[spi]-1)
            s += cnt[spi]
            b = len(sb) - s
            # print(g, s, b, g+s+b, n//2)
            if s > g and b > g:
                print(f'{g} {s} {b}')
                possible = True
                break
    if not possible:
        print("0 0 0")
        continue
