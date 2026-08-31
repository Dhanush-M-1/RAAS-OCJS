input()
a = sorted(map(int, input().split()))
b = sorted(map(int, input().split()))
c = sorted(map(int, input().split()))
i = 0
while i < len(b) and b[i] == a[i]:
    i += 1
print(a[i])
i = 0
while i < len(c) and c[i] == b[i]:
    i += 1
print(b[i])