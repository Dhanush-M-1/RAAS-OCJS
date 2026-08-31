n = int(input())
l, r, d = [], [], []
for i in range(n):
    li, ri, di = map(int, input().split())
    l.append(li)
    r.append(ri)
    d.append(di)


for i in range(n):
    ans = 0
    if l[i] / d[i] > 1:
        ans = d[i]
    else:
        temp = r[i] // d[i] + 1
        ans = temp * d[i]
    print(ans)
