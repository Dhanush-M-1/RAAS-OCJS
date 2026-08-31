T = int(input())
while T != 0:
    N = int(input())
    A = list(map(int,input().strip().split()))[:N]
    found = False
    if A[0] + A[1] <= A[N - 1]:
        found = True
    if found:
        ans = [1,2,N]
        print(*ans)
    else:
        print(-1)
    T -= 1