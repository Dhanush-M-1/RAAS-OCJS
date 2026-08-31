n = int(input())
a = sorted(list(map(int, input().split())))
b = sorted(list(map(int, input().split())))
c = sorted(list(map(int, input().split())))
for i in range(len(b)):
    a.remove(b[i])
for i in range(len(c)):
    b.remove(c[i])
print(a[0])
print(b[0])
