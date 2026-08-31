t = int(input())
for test in range(t):
    n = int(input())
    a = [int(x) for x in input().split()]
    mm = 0
    x = []
    for i in range(n):
        if a[i]==-1:
            if (i+1)<n and a[i+1]!=-1:
                x.append(a[i+1])
            if (i-1)>=0 and a[i-1]!=-1:
                x.append(a[i-1])
        else:
            if i+1<n and a[i+1]!=-1 and abs(a[i]-a[i+1])>mm:
                mm = abs(a[i]-a[i+1])
    if len(x)==0:
        print(mm,0)
        continue
    ss = min(x)
    ll = max(x)
    
    k = (ss+ll)//2
    for i in range(n):
        if a[i]==-1:
            a[i]=k
    for i in range(n):
        if (i+1)<n and abs(a[i]-a[i+1])>mm:
            mm = abs(a[i]-a[i+1])
    print(mm,k) 