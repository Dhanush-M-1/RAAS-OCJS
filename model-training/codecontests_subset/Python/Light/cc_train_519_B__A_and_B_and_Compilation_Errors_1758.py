n = int(input())
a = sorted([int(s) for s in input().split()])
b = sorted([int(s) for s in input().split()])
c = sorted([int(s) for s in input().split()])
b.append(0)
c.append(0)
c.append(0)
i,j = 0, 0
while a[i] == b[i]:
    i += 1
while b[j] == c[j]:
    j += 1
print(a[i],b[j], sep='\n')
    