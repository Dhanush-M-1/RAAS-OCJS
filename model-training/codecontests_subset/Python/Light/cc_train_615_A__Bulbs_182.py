n, m = map(int, input().split())
A = []
for _ in range(n):
    a = list(map(int, input().split()))
    A.extend(a[1:])
if len(set(A)) == m:
    print("YES")
else:
    print("NO")