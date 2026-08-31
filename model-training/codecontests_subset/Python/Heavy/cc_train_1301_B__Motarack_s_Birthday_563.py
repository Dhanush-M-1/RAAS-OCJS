import sys
readline = sys.stdin.readline
T = int(readline())
Ans = [None]*T
for qu in range(T):
    N = int(readline())
    A = list(map(int, readline().split()))
    res = 0
    candi = []
    for i in range(N-1):
        if A[i] >= 0 and A[i+1] >= 0:
            res = max(res, abs(A[i+1] - A[i]))
        if A[i] == -1 and A[i+1] >= 0:
            candi.append(A[i+1])
    for i in range(1, N):
        if A[i] == -1 and A[i-1] >= 0:
            candi.append(A[i-1])
    if candi:
        mini = min(candi)
        maxi = max(candi)
        med = (mini+maxi)//2 
        m = max(maxi-med, med-mini, res)
        k = med
    else:
        m = res
        k = 0
    Ans[qu] = (m, k)
print('\n'.join([f'{m} {k}' for m, k in Ans]))
