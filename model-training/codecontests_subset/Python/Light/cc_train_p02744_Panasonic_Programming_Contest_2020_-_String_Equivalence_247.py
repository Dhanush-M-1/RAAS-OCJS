N = int(input())


def l(i):
    return chr(i + 96)


def f(i, L):
    if i == N + 1:
        print(''.join(list(map(l, L))))
        return
    for d in range(1, min(i + 1, len(set(L)) + 2)):
        f(i + 1, L + [d])


f(1, [])
