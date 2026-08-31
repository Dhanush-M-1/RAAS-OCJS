n = int(input())
a = sorted(map(int, input().split()))
b = sorted(map(int, input().split()))
c = sorted(map(int, input().split()))
for i in range(n):
    if i == n-1:
        print(a[i])
    elif a[i] != b[i]:
        print(a[i])
        break
for i in range(n-1):
    if i == n-2:
        print(b[i])
    elif b[i] != c[i]:
        print(b[i])
        break