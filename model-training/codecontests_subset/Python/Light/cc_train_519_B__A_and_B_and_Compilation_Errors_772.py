m, a, b, d=int(input()),sorted(input().split()),sorted(input().split())+['s'],sorted(input().split())+['s','a']
for i in range(m):
    if a[i]!=b[i]:
        print(a[i])
        break
for i in range(m):
    if b[i]!=d[i]:
        print(b[i])
        break