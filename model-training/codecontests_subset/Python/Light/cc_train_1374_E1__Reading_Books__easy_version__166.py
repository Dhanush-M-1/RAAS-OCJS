n, k = map(int, input().split())
L1, L2, L3 = [], [], []
for i in range(n):
    t, a, b = map(int, input().split())
    if a*2+b == 1:
        L1.append(t)
    elif a*2+b == 2:
        L2.append(t)
    elif a*2+b == 3:
        L3.append(t)
m = min(len(L1), len(L2))
if len(L3) + m < k:
    print(-1)
else:
    L1.sort()
    L2.sort()
    L3.sort()
    X = []
    for i in range(m):
        X.append(L1[i]+L2[i])
    for i in range(len(L3)):
        X.append(L3[i])
    X.sort()
    print(sum(X[i] for i in range(k)))