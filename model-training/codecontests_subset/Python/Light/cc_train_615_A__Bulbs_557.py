bb = [int(n) for n in input().split()]
l1 = []
for i in range(bb[0]):
    l = [int(m) for m in input().split()]
    for j in range(1,len(l)):
        if l[j] not in l1:
            l1.append(l[j])
if len(l1) == bb[1]:
    print("YES")
else:
    print("NO")
    