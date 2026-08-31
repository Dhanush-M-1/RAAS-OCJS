from math import inf
t = int(input())
for q in range(t):
    n = int(input())
    A = [int(i) for i in input().split()]
    mi = inf
    ma = -1 * inf
    for i in range(len(A)):
        if A[i] != -1:
            if i < len(A) - 1 and A[i + 1] == -1:
                mi = min(A[i], mi)
                ma = max(A[i], ma)
            if i > 0 and A[i - 1] == -1:
                mi = min(A[i], mi)
                ma = max(A[i], ma)
    if mi == inf:
        num = 0
    else:
        num = (mi + ma) // 2
    d = 0
    if A[0] == -1:
        A[0] = num
    for i in range(1, len(A)):
        if A[i] == -1:
            A[i] = num
        d = max(d, abs(A[i] - A[i - 1]))
    print(d, num)
