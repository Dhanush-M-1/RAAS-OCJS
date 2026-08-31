n = int(input())
a = sorted(list(map(int, input().split())))
b = sorted(list(map(int, input().split()))) + [-1]
c = sorted(list(map(int, input().split()))) + [-1] * 2

x, y, z = 0, 0, 0
first = 0
second = 0

while (first == 0) or (second == 0):
    if (a[x] == b[y]) and (b[y] == c[z]):
        x += 1
        y += 1
        z += 1
    elif a[x] != b[y]:
        first = a[x]
        x += 1
    elif a[x] != c[z]:
        second = a[x]
        x += 1
        y += 1

print(first, second, sep = '\n')