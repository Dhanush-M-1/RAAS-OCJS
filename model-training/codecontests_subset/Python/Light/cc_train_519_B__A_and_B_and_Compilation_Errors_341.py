n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))
a.sort()
b.sort()
c.sort()
b.append(0)
c.append(0)
c.append(0)
for i in range(n):
    if (a[i] != b[i]):
        print(a[i])
        break;
for i in range(n - 1):
    if (b[i] != c[i]):
        print(b[i])
        break