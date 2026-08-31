n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))

a.sort()
b.sort()
c.sort()

saida = []
for i in range(n):
    if i< len(b):
        if a[i] != b[i]:
            print(a[i])
            break
    else:
        print(a[i])

for i in range(n-1):
    if i< len(c):
        if b[i] != c[i]:
            print(b[i])
            break
    else:
        print(b[i])
