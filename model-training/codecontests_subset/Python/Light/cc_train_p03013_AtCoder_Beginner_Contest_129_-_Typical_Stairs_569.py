n, m = map(int, input().split())
a = [1] * (n+1)
for _ in range(m):
    a[int(input())] = 0

for i in range(2,n+1):
    if a[i] != 0:
        a[i] = a[i-1] + a[i-2]
print(a[n]%(10**9 + 7))
