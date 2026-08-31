N,K,Q = map(int,input().split())
A = list(map(int,input().split()))
SA = sorted(A)

def calc_max_a(min_a):
    cands = []
    seq = 0
    for i,a in enumerate(A):
        if a < min_a:
            if seq >= K:
                cands += sorted(A[i-seq:i])[:seq-K+1]
            seq = 0
        else:
            seq += 1
    if seq >= K:
        cands += sorted(A[-seq:])[:seq-K+1]
    if len(cands) < Q:
        return -1
    else:
        return sorted(cands)[Q-1]

min_a = 0
ans = float('inf')
for a in SA:
    if a == min_a: continue
    min_a = a
    max_a = calc_max_a(min_a)
    if max_a < 0: break
    ans = min(ans, max_a - min_a)
print(ans)