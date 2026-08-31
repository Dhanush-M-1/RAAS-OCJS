n = int(input())

a = list(map(int,input().split()))
b = list(map(int,input().split()))
c = list(map(int,input().split()))

a.sort()
b.sort()
c.sort()

b.append(0)
c.append(0)
c.append(0)

for i in range(n):
    if a[i] - b[i] != 0:
        print(a[i])
        break

for i in range(n):
    if b[i] - c[i] != 0:
        print(b[i])
        break