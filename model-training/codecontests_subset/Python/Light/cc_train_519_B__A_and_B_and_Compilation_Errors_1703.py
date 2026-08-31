R = lambda : map(int, input().split())
n = int(input())
a = list(sorted(R()))
b = list(sorted(R()))
c = list(sorted(R()))
for i in range(n - 1):
    if b[i] != a[i]:
        break
else:
    i += 1
x = a[i]
for i in range(n - 2):
    if b[i] != c[i]:
        break
else:
    i += 1
y = b[i]
print(x)
print(y)