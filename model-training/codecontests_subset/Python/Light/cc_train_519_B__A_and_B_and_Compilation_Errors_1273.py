n = int(input())
a = [int(i) for i in input().split()]
b = [int(i) for i in input().split()]
c = [int(i) for i in input().split()]
a.sort()
b.sort()
c.sort()
zh = a[n - 1]
for i in range(n - 1):
    if(a[i] != b[i]):
        zh = a[i]
        break
hz = b[n - 2]
for i in range(n - 2):
    if (b[i] != c[i]):
        hz = b[i]
        break
print(zh)
print(hz)