N, K, Q = map(int, input().split())
A = list(map(int, input().split()))
A_sorted = sorted(A)
ans = 10**10
for m in A_sorted:
    lists = []
    tmp = []
    for a in A:
        if a<m:
            lists.append(tmp)
            tmp = []
        else:
            tmp.append(a)
    lists.append(tmp)
    
    res = []
    for l in lists:
        length = len(l)
        if length<K:
            continue
        l.sort()
        res+=l[:length-K+1]
    res.sort()
    if len(res)>=Q:
        ans = min(ans, res[Q-1]-m)
print(ans)        