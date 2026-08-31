n,m = map(int,input().split())

a = [1] * (n+1)

for i in range(m):
    a[int(input())] = 0

for i in range(n+1):
    if i > 1:
        a[i] = (a[i-2] + a[i-1])%(10**9+7) * a[i]

print(a[n])
