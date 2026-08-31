q = int(input())
for _ in range(q):
    n = int(input())
    A = list(map(int, input().split()))
    ref = A[0] + A[1]
    ans = 0
    for i, a in enumerate(A):
        if a >= ref:
            ans = i
            break
    if ans == 0:
        print(-1)
    else:
        print(1, 2, ans + 1)