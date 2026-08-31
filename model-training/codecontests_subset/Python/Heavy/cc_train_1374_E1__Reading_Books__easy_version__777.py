n, k = map(int, input().split())
aa = []
bb = []
oo = []
for i in range(n):
    t, a, b = map(int, input().split())
    if (a==1):
        if (b==1):
            oo.append(t)
        else:
            aa.append(t)
    else:
        if (b==1):
            bb.append(t)
if (len(aa) + len(oo) < k) or (len(oo) + len(bb) < k):
    print(-1)
else:
    aa.sort(reverse = True)
    bb.sort(reverse = True)
    oo.sort(reverse= True)
    ans = 0
    for i in range(k):
        if len(oo)==0:
            ans += aa.pop()
            ans += bb.pop()
        elif len(aa)==0 or len(bb)==0:
            ans += oo.pop()
        else:
            if (oo[-1] < aa[-1]+bb[-1]):
                ans += oo.pop()
            else:
                ans += aa.pop()
                ans += bb.pop()
    print(ans)