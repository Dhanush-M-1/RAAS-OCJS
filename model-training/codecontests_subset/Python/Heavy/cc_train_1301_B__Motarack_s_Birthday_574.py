t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    b=[0]+a+[0]
    final=[b[i] for i in range(1,len(b)-1) if b[i]!=-1 and (b[i-1]==-1 or b[i+1]==-1)]
    final.sort()

    ans=0
    if len(final)==0:
        print(0, 1)
    else:

        mid = len(final) // 2
        mid=(final[0]+final[-1]+1)//2

        for i in range(0,len(a)):
            if a[i]==-1:
                a[i]=mid
        k=mid
        x=0
        for i in range(0,len(a)-1):
            x=max(x,abs(a[i]-a[i+1]))
        print(x,k)