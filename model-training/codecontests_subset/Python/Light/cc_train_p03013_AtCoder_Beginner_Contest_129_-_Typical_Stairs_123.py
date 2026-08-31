n, m = list(map(int, input().split()))
a = {}

for i in range(m):
    a[int(input())] = True

c = [0] * (n+1)
c[0] = 1

for i in range(1, n+1):
    if not i in a:
        c[i] = c[i-1] + c[i-2]

print(c[n] % 1000000007)