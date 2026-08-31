for _ in range(int(input())):
    n=int(input())
    a=[int(i) for i in input().split()] ;summ=0 ; cnt=0; arr=[]
    if a[1]==-1 and a[0]!=-1:
        arr.append(a[0])
    for i in range(1,n-1):
        if a[i]!=-1:
            if a[i-1]==-1 or a[i+1]==-1:
                arr.append(a[i])
    if a[-2]==-1 and a[-1]!=-1:
        arr.append(a[-1])
    if arr:
        max1=max(arr)
        min1=min(arr)
        ans=(max1+min1)//2
        for i in range(n):
            if a[i]==-1:
                a[i]=ans
        maxx=-1
        for i in range(1,n):
            maxx=max(maxx,abs(a[i-1]-a[i]))
        print(maxx,ans)
    else:
        print(0,0)
