N = int(input())
K = int(input())

memo_d = dict()


def key_check(n, k):
    if k == 0:
        return 1
    elif n < 10 ** (k - 1):
        return 0
    elif n < 10:
        return n
    x = memo_d.get((n, k))
    if x is None:
        x = aez(n, k)
    return x


def aez(n, k):
    nq = n // 10
    nr = n % 10
    return nr * key_check(nq, k - 1) + (9 - nr) * key_check(nq - 1, k - 1) + key_check(nq, k)


if N < 10 ** (K - 1):
    ans = 0
elif N < 10:
    ans = N
else:
    ans = aez(N, K)
print(ans)
