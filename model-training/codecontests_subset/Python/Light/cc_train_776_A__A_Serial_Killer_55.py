l1 = [n for n in input().split()]
m = int(input())
print(*l1, sep=" ")
for i  in range(0,m):
    l = [k for k in input().split()]
    p = []
    for j in range(2):
        if l[j] not in l1:
            p.append(l[j])
        if l1[j] not in l:
            p.append(l1[j])
    print(*p,sep=" ")
    l1 = p
