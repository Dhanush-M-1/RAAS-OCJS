n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))

a.sort()
b.sort()
c.sort()

for i in range(n - 1):
    if a[i] != b[i]:
        print(a[i])
        break
else:
    print(a[-1])

for i in range(n - 2):
    if b[i] != c[i]:
        print(b[i])
        break
else:
    print(b[-1])