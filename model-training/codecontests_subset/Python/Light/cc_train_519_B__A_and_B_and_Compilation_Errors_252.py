input()
a = []
for i in [0,1,2]:
    s = 0
    for r in input().split():s += int(r)
    a += [s]
print(a[0]-a[1])
print(a[1]-a[2])