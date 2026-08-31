T = int(input())
for i in range(T):
    N = int(input())
    A = list(map(int, input().split()))
    z = A[0] + A[1]
    flag = 0
    for j in range(2,N):
        if A[j]>=z:
            flag = 1
            break
    if flag==1:
        print(1, 2, j+1)
    else:
        print(-1)