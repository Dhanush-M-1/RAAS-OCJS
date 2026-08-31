T = int(input())
for _ in range(T):
    N = int(input())
    A = list(map(int, input().split()))
    a_i = A[0]
    a_j = A[1]
    ans = 0
    for k in range(2, N):
        if A[k] >= a_i + a_j:
            ans = k
            break
    if ans == 0:
        print(-1)
    else:
        print(1, 2, k+1)