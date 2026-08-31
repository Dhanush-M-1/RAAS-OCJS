t = int(input())
for x in range(t):
    n = int(input())
    p = list(map(int, input().split()))
    d = {}
    g = 0
    s = 0
    b = 0
    for i in range(len(p)):
        if p[i] in d:
            d[p[i]] += 1
        else:
            d[p[i]] = 1
    z = list(d.keys())
    a = 0
    i = 0
    while a+d[z[i]] <= n//2:
        a+=d[z[i]]
        i+=1
    g = d[z[0]]
    j = 1
    while s<=g and j<len(set(p))-1:
        s+=d[z[j]]
        j+=1
    b=a-g-s
    if 0 < g < s and g < b:
        print(g, s, b)
    else:
        print(0, 0, 0)