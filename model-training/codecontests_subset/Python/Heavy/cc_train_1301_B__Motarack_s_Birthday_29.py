def calc(A):
    min_, max_ = float('Inf'), 0
    found = False
    for i, a in enumerate(A):
        if a != -1:
            continue
        if 0 <= i - 1 and A[i - 1] != -1:
            found = True
            min_ = min(min_, A[i - 1])
            max_ = max(max_, A[i - 1])
        if i + 1 < len(A) and A[i + 1] != -1:
            found = True
            min_ = min(min_, A[i + 1])
            max_ = max(max_, A[i + 1])
    k = (min_ + max_) // 2 if found else 0
    res = 0
    for i in range(len(A)):
        if A[i] == -1:
            A[i] = k
        if i > 0:
            res = max(res, abs(A[i] - A[i - 1]))
    return res, k

if __name__ == '__main__':
    N = int(input())
    cases = []
    for _ in range(N):
        d = int(input())
        cases.append(list(map(int, input().split())))
    for c in cases:
        r = calc(c)
        print("{} {}".format(r[0], r[1]))