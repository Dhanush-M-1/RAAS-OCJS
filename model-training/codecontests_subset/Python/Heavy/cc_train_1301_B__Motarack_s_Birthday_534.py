import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    N, = map(int, input().split())
    A = list(map(int, input().split()))
    mnx = 10**9
    mxx = 0
    ms = 0
    for i in range(N):
        if A[i] == -1:
            if i != 0:
                if A[i-1] != -1:
                    mnx = min(mnx, A[i-1])
                mxx = max(mxx, A[i-1])
            if i != N-1:
                if A[i+1] != -1:
                    mnx = min(mnx, A[i+1])
                mxx = max(mxx, A[i+1])
        else:
            if i != N-1 and A[i+1] != -1:
                ms = max(ms, abs(A[i]-A[i+1]))
    rr = (mnx + mxx)//2
    print(max(ms, mxx-rr), rr)

