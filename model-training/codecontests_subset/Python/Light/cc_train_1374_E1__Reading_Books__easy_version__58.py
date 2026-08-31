# from bisect import bisect_left
# TC = int(input())

# for tc in range(TC):
N, K = map(int, input().split())
T = []
A = []
B = []
O = []
for b in range(N):
    v, a, b = map(int, input().split())
    if a == 1 and b == 1:
        T.append(v)
    elif a == 1:
        A.append(v)
    elif b == 1:
        B.append(v)
    else:
        O.append(v)

A.sort()
B.sort()

S = []
for i in range(min(len(A),len(B))):
    S.append(A[i]+B[i])

R = S + T

if len(R) >= K:
    R.sort()
    print(sum(R[:K]))
else:
    print(-1)
