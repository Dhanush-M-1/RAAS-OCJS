n,m = map(int,input().split())

p = [True for _ in range(n+1)]

p[0] = 1
p[1] = 1

for _ in range(m):
    a = int(input())
    p[a] = 0

for i in range(2,n+1):
    if p[i]:
        p[i] = p[i-1] + p[i-2]

print(p[n]%(10**9+7))