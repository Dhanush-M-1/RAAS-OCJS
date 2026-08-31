def solve(L,N):
    first = N
    last = -1
    for i in range(N):
        if L[i] < i:
            first = i
            break
    for i in range(N-1,-1,-1):
        if L[i] < N-i-1:
            last = i
            break
    if last >= first:
        print("No")
        return

    for i in range(N):
        if L[i] >= i and L[i] >=  N-i-1 and i < first and i > last:
            print("Yes")
            return
    print("No")

t = int(input())
for cnt in range(t):
    N = int(input())
    L = list(map(int,input().split()))
    solve(L,N)

