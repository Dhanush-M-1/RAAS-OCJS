N, K, Q = map(int, input().split())
A = list(map(int, input().split()))
D = set()
for i in range(N):
    D.add(A[i])

D = list(D)
ans = float('inf')
for Y in D:
    T = []
    tmp = []
    for j in range(N):
        if A[j] >= Y:
            tmp.append(A[j])
        else:
            if len(tmp) >= K:
                tmp = sorted(tmp)
                T += tmp[:len(tmp) - K + 1]
            tmp = []

    if len(tmp) >= K:
        tmp = sorted(tmp)
        T += tmp[:len(tmp) - K + 1]

    if len(T) >= Q:
        T = sorted(T)
        T = T[:Q]
        ans = min(ans, T[-1] - T[0])

print(ans)
