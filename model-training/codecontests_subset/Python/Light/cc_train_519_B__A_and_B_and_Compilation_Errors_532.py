n = int(input())
a = sorted(list(map(int, input().split())))
b = sorted(list(map(int, input().split()))) + [0]
c = sorted(list(map(int, input().split()))) + [0]*2
e, f = '', ''

for i in range(n):
    if a[i] != b[i]:
        e = a[i]
        break
for j in range(n):
    if b[j] != c[j]:
        f = b[j]
        break

print(e)
print(f)