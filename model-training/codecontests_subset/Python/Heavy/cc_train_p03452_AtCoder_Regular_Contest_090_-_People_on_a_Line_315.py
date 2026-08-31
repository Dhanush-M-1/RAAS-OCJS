n, m = (int(x) for x in input().split())
p = [(i,0) for i in range(n)]

def check(i):
    j, d = p[i]
    if j != i:
        ii, dd = check(j)
        p[i] = (ii, d+dd)
    return p[i]

f = True
for _ in range(m):
    l, r, d = (int(x) for x in input().split())
    l-=1;r-=1
    li, ld = check(l)
    ri, rd = check(r)
    if li != ri:
        t = d+ld-rd
        if t >= 0:
            p[ri] = (li, t)
        else:
            p[li] = (ri, -t)
    else:
        if rd - ld != d:
            f = False
            break
print("Yes" if f else "No")
