n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))

a.sort()
b.sort()
c.sort()

result1 = a[-1]
for i in range(len(a)-1):
    if a[i] != b[i]:
        result1 = a[i]
        break

result2 = b[-1]
for i in range(len(b)-1):
    if b[i] != c[i]:
        result2 = b[i]
        break

print(result1)
print(result2)