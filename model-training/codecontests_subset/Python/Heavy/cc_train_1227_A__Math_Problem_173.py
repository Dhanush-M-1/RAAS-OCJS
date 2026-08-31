t = int(input())
for e in range(t):
    n = int(input())
    l = [0]*n
    r = [0]*n
    for i in range(n):
        a = list(map(int, input().split()))
        l[i] = a[0]
        r[i] = a[1]
    lans = 0
    rans = 0
    for i in range(n):
        if l[i]<l[lans]:
            lans = i
        if r[i]> r[rans]:
            rans = i
    for i in range(n):
        if r[i] < r[lans]:
            lans = i
        if l[i] > l[rans]:
            rans = i
    if l[rans] < r[lans]:
        print(0)
    else:
        print(l[rans] - r[lans])
