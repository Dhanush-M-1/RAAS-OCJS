n, k = map(int, input().split())

both, f, s = [], [], []

for i in range(n):
    t, x, y = map(int, input().split())

    if x == 1 and y == 1:
        both.append(t)
    elif x == 1:
        f.append(t)
    elif y == 1:
        s.append(t)



if min(len(f),len(s)) + len(both) < k:
    print(-1)
else:
    both = sorted(both)
    f = sorted(f)
    s = sorted(s)
    g = [both, f, s]
    for l in g:
        for j, v in enumerate(l):
            if j > 0:
                l[j] = l[j-1] + l[j]
    #print(both, f, s)
    #swap f and s
    if len(f) > len(s):
        b = f
        f = s
        s = b
    mn = 5*(10**9)
    if len(f) == 0:
        mn = both[k-1]
    for i in range(len(f)+1):
        if i > k:
            break
        elif i > 0:
            if i == k:
                mn = min(f[i-1] + s[i-1], mn)
            elif len(both) >= k - i:
                mn = min(f[i-1] + s[i-1] + both[k-i-1], mn)
        elif i == 0:
            if len(both) >= k:
                mn = both[k-1]


    print(mn)
                









                
