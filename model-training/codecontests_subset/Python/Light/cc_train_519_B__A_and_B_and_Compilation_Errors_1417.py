# https://codeforces.com/problemset/problem/519/B

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))

a.sort()
b.sort()
c.sort()

f = 0

for i in range(len(b)):
    if a[i] != b[i]:
        f = 1
        print(a[i])
        break

if not f:
    print(a[-1])

f = 0

for i in range(len(c)):
    if c[i] != b[i]:
        f = 1
        print(b[i])
        break

if not f:
    print(b[-1])