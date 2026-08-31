n, m = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
from collections import Counter
CA = Counter(A)
CB = Counter(B)
X = []
for a, cnta in CA.items():
    S = set()
    for b, cntb in CB.items():
        if cnta == cntb:
            if b >= a:
                S.add(b-a)
            else:
                S.add(m+b-a)
    X.append(S)
ans = m+1
for i in X[0]:
    for j in range(len(X)):
        S = X[j]
        if i not in S:
            break
    else:
        ans = min(i, ans)
print(ans)
