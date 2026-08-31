N = int(input())


def f(L, m):
    l = len(L)
    if l == N:
        print(''.join(list(map(lambda i: chr(i + 96), L))))
        return
    for d in range(1, min(l + 1, m + 1) + 1):
        f(L + [d], max(m, d))


f([1], 1)
