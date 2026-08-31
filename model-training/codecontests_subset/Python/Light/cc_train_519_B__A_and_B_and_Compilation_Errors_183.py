n = int(input())
a = sorted(list(map(int, input().split())))
b = sorted(list(map(int, input().split()))) + [-1]
c = sorted(list(map(int, input().split()))) + [-1, -1]
for i in range(n):
    if a[i] != b[i]:
        print(a[i])
        break
for i in range(n):
    if b[i] != c[i]:
        print(b[i])
        break