n, k = map(int, input().split())
a, b, c, d = map(int, input().split())
B = []
for i in range(1, n+1):
    if i not in (a, b, c, d):
        B.append(i)
    else:
        i -= 1
A = [a, c] + B + [d, b]
C = [c, a] + B + [b, d]
R = set()
for i in range(n-1):
    R.add(tuple(sorted((A[i], A[i+1]))))
    R.add(tuple(sorted((C[i], C[i+1]))))
if tuple(sorted((a, b))) in R:
    print(-1)
    exit()
if tuple(sorted((c, d))) in R:
    print(-1)
    exit()
if len(R) > k:
    print(-1)
    exit()
print(*A)
print(*C)
