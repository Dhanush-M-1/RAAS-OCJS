N = int(input())


def f(L):
    l = len(L)
    if l == N:
        print(''.join(list(map(lambda i: chr(i + 96), L))))
        return
    for d in range(1, min(l, max(L)) + 2):
        f(L + [d])


f([1])
