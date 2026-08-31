for _ in range(int(input())):
    N = int(input())
    A = list(map(int, input().split()))
    if A[0] + A[1] <= A[N-1]:
        print(1, 2, N)
    else:
        print(-1)