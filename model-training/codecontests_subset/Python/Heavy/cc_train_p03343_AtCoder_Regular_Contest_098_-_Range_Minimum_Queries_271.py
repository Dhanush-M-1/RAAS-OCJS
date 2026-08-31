N, K, Q = map(int, input().split())
*A, = map(int, input().split())

ans = 10**18
for i in range(N):
    pv = A[i]
    res = []; tmp = []
    for a in A:
        if pv <= a:
            tmp.append(a)
        else:
            if len(tmp) >= K:
                tmp.sort()
                res.extend(tmp[:len(tmp)-K+1])
            tmp = []
    if len(tmp) >= K:
        tmp.sort()
        res.extend(tmp[:len(tmp)-K+1])
    if Q <= len(res):
        res.sort()
        ans = min(ans, res[Q-1]-res[0])
print(ans)