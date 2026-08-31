def solve(A):
    if all(a == -1 for a in A):
        print(0, 0)
        return

    minval, maxval = float("inf"), float("-inf")
    m = float("-inf")
    for a, b in zip(A, A[1:]):
        if a == -1 and b >= 0:
            minval, maxval = min(minval, b), max(maxval, b)
        elif b == -1 and a >= 0:
            minval, maxval = min(minval, a), max(maxval, a)
        elif a >= 0 and b >= 0:
            m = max(m, abs(a - b))
    k = (minval + maxval) // 2
    m = max(m, maxval - k)
    print(m, k)


def main():
    t = int(input().strip())
    for _ in range(t):
        n = int(input().strip())
        A = [int(s) for s in input().strip().split()]
        solve(A)


main()
