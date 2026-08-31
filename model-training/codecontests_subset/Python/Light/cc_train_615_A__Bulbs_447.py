data = [int(x) for x in input().split()]
y = []
for i in range(data[0]):
    y += [int(z) for z in input().split()][1:]
if all([n in y for n in range(1,data[1]+1)]):
    print("YES")
else:
    print("NO")