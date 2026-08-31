n = int(input())
a = list(map(int, input().split()))
a = sorted(a)
b = list(map(int, input().split()))
b = sorted(b)
c = list(map(int, input().split()))
c = sorted(c)
for i in range(n-1):
    if not a[i] == b[i]:
        print(a[i])
        break
    if i == n-2:
        print(a[n-1])
for i in range(n-2):
    if not b[i] == c[i]:
        print(b[i])
        break
    if i == n-3:
        print(b[n-2])