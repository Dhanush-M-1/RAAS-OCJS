n = int(input())
a = sorted([int(i) for i in input().split()])
b = sorted([int(i) for i in input().split()])
c = sorted([int(i) for i in input().split()])
i = 0
while i < n-1 and a[i] == b[i]:
    i += 1
print(a[i])
i = 0
while i < n-2 and b[i] == c[i]:
    i += 1
print(b[i])