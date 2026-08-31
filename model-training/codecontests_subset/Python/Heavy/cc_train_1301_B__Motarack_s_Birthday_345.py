T = int(input())
for t in range(T):
    n = int(input())
    A = [int(i) for i in input().split()]
    # remember to handle the case where everything is missing
    tmp = []
    if A[0] == -1 and A[1] != -1:
        tmp.append(A[1])
    for i in range(1, n-1):
        if A[i] == -1:
            if A[i+1] != -1:
                tmp.append(A[i+1])
            if A[i-1] != -1:
                tmp.append(A[i-1])
    if A[-1] == -1 and A[-2]!= -1:
        tmp.append(A[-2])
    if len(tmp) == 0:
        k = 0
    else:
        tmp = set(tmp)
        k = (min(tmp) + max(tmp)) // 2
    m = 0
    B = [A[i] if A[i] >= 0 else k for i in range(n)]
    for i in range(1,n):
        m = max(abs(B[i]-B[i-1]), m)
    print(m, k)
