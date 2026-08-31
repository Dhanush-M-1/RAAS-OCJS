n, k, q = [int(i) for i in input().split()]
a = [int(i) for i in input().split()]

#print(a)
ans = float("inf")
for i in range(n):
    y = a[i]

    c = []
    c_k = []
    for j in range(n):
        if a[j] >= y:
            c_k.append(a[j])
        else:
            c.append(c_k)
            c_k = []
    else:
        c.append(c_k)

    d = []
    for j in c:
        if len(j) >= k:
            j.sort()
            for l in range(len(j)-k+1):
                d.append(j[l])

    if len(d) >= q:
        d.sort()
        ans = min(ans, d[q-1] - d[0])

print(ans)

