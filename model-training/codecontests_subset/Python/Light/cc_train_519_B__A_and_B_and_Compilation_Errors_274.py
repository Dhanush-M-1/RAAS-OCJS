n = int(input())
a = [int(j) for j in input().split(' ')]
b = [int(j) for j in input().split(' ')]
c = [int(j) for j in input().split(' ')]
a.sort()
b.sort()
c.sort()
for idx, j in enumerate(a):
    if idx<n-1 and b[idx]!=j:
        print(j)
        break
    elif idx==n-1:
        print(j)
for idx, j in enumerate(b):
    if idx<n-2 and c[idx]!=j:
        print(j)
        break
    elif idx==n-2:
        print(j)