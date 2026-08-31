for t in range(int(input())):
    n = int(input())
    a = map(int, input().split())
    a = list(a)
    start = -1
    flag = False
    elems = []
    for i in range(1,n-1):
        if a[i] != -1 and (a[i-1]==-1 or a[i+1]==-1):
            elems.append(a[i])
    if len(a)>0 and a[1]==-1 and a[0] != -1:
        elems.append(a[0])
    if len(a)>1 and a[-2]==-1 and a[-1] != -1:
        elems.append(a[-1])
    #print(elems)
    if len(elems) == 0:
        if max(a) == -1:
            print('0 0')
        else:
            print('0',max(a))
        continue
    k = (max(elems)+min(elems))//2
    maxd = 0
    for i in range(n-1):
        if a[i]+a[i+1]==-2:
            diff = 0
        elif a[i]==-1:
            diff = abs(k-a[i+1])
        elif a[i+1]==-1:
            diff = abs(k-a[i])
        else:
            diff = abs(a[i]-a[i+1])
        maxd = max(maxd, diff)
    print(maxd,k)
