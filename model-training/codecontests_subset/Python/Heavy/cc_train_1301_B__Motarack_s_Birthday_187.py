t=int(input())
for q in range(t):
    n=int(input())
    a=[int(x) for x in input().split()]
    maxd = 0
    mind=1000000000
    m=0
    countneg1=0
    countother=0
    for x in range(n):
        if x!=n-1 and a[x]!=-1 and a[x+1]!=-1 and abs(a[x]-a[x+1])>m:
            m=abs(a[x]-a[x+1])
        if a[x]==-1:
            countneg1+=1
        else:
            countother+=1
        if x!=n-1 and a[x] == -1 and a[x+1]!=-1:
            if maxd<a[x+1]:
                maxd=a[x+1]
            if mind>a[x+1]:
                mind=a[x+1]
        if a[x]==-1 and a[x-1]!=-1 and x!=0:
            if a[x-1]>maxd:
                maxd=a[x-1]
            if a[x-1]<mind:
                mind=a[x-1]
    if countother==0:
        print(0,1)
        continue
    diff=maxd-mind
    rtn=mind+((maxd-mind)//2)
    print(max(max(rtn-mind,maxd-rtn),m),rtn)
