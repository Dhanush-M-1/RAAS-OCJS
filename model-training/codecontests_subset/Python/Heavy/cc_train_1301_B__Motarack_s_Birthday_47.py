n = int(input())
for v in range(n):
    l = int(input())
    a = list(map(int,(input().split())))
    t = []
    for i in range(l):
        if a[i]!=-1:
            if (i>0 and a[i-1]==-1) or (i<l-1 and a[i+1]==-1):
                t.append(a[i])
    if not t:
        print(0,0)
    else:
        mi = min(t)
        ma = max(t)
        k =(mi+ma)//2
        max_diff = 0
        for e in range(l-1):
            if a[e]==-1:
                a[e]=k
            if a[e+1]==-1:
                a[e+1]=k
            max_diff = max(max_diff,abs(a[e]-a[e+1]))
        print(max_diff,k)    







