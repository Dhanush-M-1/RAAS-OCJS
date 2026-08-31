t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    m=0
    k=0
    adls=[]
    for i in range(n-1):
        if (a[i]!=-1 and a[i+1]==-1) or (a[i]==-1 and a[i+1]!=-1):
            adls.append(a[i]*a[i+1]//-1)
        elif a[i]!=-1 and a[i+1]!=-1:
            m=max(m, abs(a[i]-a[i+1]))
    if a[-1]!=-1 and a[-2]==-1:
        adls.append(a[-1])
    if len(adls)==0:
        print(0, 0)
    else:
        m=max(m, (max(adls)-min(adls)+1)//2)
        k=(max(adls)+min(adls)+1)//2
        print(m,k)

    