p = int(input())

de = []
for i in range(p):
    x = input().split(' ')
    l = int(x[0])
    r = int(x[1])
    d = int(x[2])
    de.append((l,r,d))

for l, r, d in de:
    if l <= d <= r:
        x = (r//d+1)*d
    else:
        x = d
    print(x)