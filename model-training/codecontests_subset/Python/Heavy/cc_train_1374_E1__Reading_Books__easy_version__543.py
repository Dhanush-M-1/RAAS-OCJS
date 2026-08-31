n, k = map(int, input().split())
l1 = []
l2 = []
l3 = []
n1 = n2 = n3 = 0
for i in range (n):
    a, b, c = map(int, input().split())
    if b == c == 1:
        l1.append(a)
        n1 += 1
    elif b == 1:
        l2.append(a)
        n2 += 1
    elif c == 1:
        l3.append(a)
        n3 += 1

if n1 + n2 < k or n1 + n3 < k:
    print(-1)
else:
    l1.sort()
    l2.sort()
    l3.sort()
    s1 = s2 = s = 0
    p = min(n2, n3)
    z1 = []
    for i in range (p):
        s1 += l2[i]
        s1 += l3[i]
        z1.append(s1)
        s1 = 0
    z2 = z1 + l1
    z2.sort()
    if len(z2) < k:
        print(-1)
    else:
        for i in range (k):
            s += z2[i]
        print(s)