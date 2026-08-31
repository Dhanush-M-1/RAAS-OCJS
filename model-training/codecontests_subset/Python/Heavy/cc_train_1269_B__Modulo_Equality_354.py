n, m = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))
a.sort()
b.sort()

bd = {}
for bi in b:
    if bi not in bd:
        bd[bi] = 0
    bd[bi] += 1
ad = {}
for ai in a:
    if ai not in ad:
        ad[ai] = 0
    ad[ai] += 1

xs = []
for bi in bd:
    if a[0] == bi:
        xi = 0
    elif a[0] < bi:
        xi = bi - a[0]
    else:
        xi = bi + m - a[0]

    valid = True
    for ai in ad:
        if (ai+xi)%m not in bd:
            valid = False
        else:
            valid = valid and ad[ai] == bd[(ai+xi)%m]

        if not valid:
            break

    if valid:
        xs.append(xi)

print(min(xs))
