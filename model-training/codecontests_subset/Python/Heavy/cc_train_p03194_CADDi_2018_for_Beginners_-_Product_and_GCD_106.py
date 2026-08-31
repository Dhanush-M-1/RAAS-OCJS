from collections import Counter


def d(P):
    c = Counter()
    i = 2
    while (P > 1):
        if P % i == 0:
            c.update([i])
            P //= i
            i -= 1
        i += 1
        if i > P ** 0.5:
            c.update([P])
            break
    return c


def solve(N, P):
    c = d(P)
    ans = 1
    for k in [k for k, v in c.items() if v >= N]:
        ans *= k ** (c[k] // N)
    return ans

if __name__ == "__main__":
    N, X = tuple(map(int, input().split(" ")))
    print(solve(N, X))
