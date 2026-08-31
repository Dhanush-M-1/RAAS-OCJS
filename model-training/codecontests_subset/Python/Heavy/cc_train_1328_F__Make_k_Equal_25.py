N, K = map(int, input().split())
X = sorted(list(map(int, input().split())))
import sys;input=sys.stdin.readline
d = dict()
for x in X:
    if x not in d:
        d[x] = 0
    d[x] += 1
    if d[x] >= K:
        print(0)
        sys.exit()
L = [0]*N
b = X[0]
for i in range(1, N):
    L[i] = (X[i]-b)*i + L[i-1]
    b = X[i]

R = [0]*N
b = X[-1]
for i in range(N-2, -1, -1):
    R[i] = (b-X[i])*(N-1-i) + R[i+1]
    b = X[i]

r = 10**18
for i in range(N):
    cr = 10**18
    if i+1 >= K:
        cr = min(cr, L[i]-(i+1-K))
    if N-i >= K:
        cr = min(cr, R[i]-(N-i-K))
    if i+1 < K and N-i < K:
        cr = min(cr, L[i]+R[i]-(N-K))
#    print(i, cr)
    cr = max(cr, 0)
    r = min(cr, r)

#print(L, R)
print(r)
