for i in range(int(input())):
    n = int(input())
    a = [int(s) for s in input().split()]
    b = []
    if a[0] != -1 == a[1]:
        b.append(a[0])
    for j in range(1,n-1):
        if a[j] != -1 and (a[j-1] == -1 or a[j+1] == -1):
            b.append(a[j])
    if a[-1] != -1 == a[-2]:
        b.append(a[-1])
    if len(b) == 0:
        print(0,0)
    else:
        mi = min(b)
        ma = max(b)
        k = (mi+ma)//2
        md = 0
        for j in range(len(a)-1):
            md = max(md,abs((k if a[j] < 0 else a[j])-(k if a[j+1] < 0 else a[j+1])))
        print(md,k)