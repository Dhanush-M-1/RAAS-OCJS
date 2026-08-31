n, k = map(int, input().split())

a = []
b = []
ab = []
ans = 0
for _ in range(n):
    t1, a1, b1 = map(int, input().split())
    if a1==1 and b1==1:
        ab.append(t1)
    elif a1==1 and b1==0:
        a.append(t1)
    elif a1==0 and b1==1:
        b.append(t1)
    else:
        pass

a.sort()
b.sort()
ab.sort()


if len(ab)+len(a)<k or len(ab)+len(b)<k:
    print("-1")
else:
    lena, lenb, lenab = len(a), len(b), len(ab)
    i, j = 0,0
    for _ in range(k):
        if i<lena and i<lenb and j<lenab:
            if a[i]+b[i]<ab[j]:
                ans += a[i]+b[i]
                i+=1
            else:
                ans += ab[j]
                j+=1
        elif i<lena and i<lenb:
            ans += a[i] + b[i]
            i += 1
        else:
            ans += ab[j]
            j+=1
    print(ans)